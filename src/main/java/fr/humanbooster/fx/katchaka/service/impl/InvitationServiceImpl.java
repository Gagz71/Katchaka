package fr.humanbooster.fx.katchaka.service.impl;

import fr.humanbooster.fx.katchaka.business.Invitation;
import fr.humanbooster.fx.katchaka.business.Personne;
import fr.humanbooster.fx.katchaka.dao.InvitationDao;
import fr.humanbooster.fx.katchaka.service.InvitationService;
import fr.humanbooster.fx.katchaka.service.PersonneService;
import fr.humanbooster.fx.katchaka.util.ProgramSms;
import fr.humanbooster.fx.katchaka.util.ProgramSmsSend;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationServiceImpl implements InvitationService {

    private InvitationDao invitationDao;
    private PersonneService personneService;
    private ProgramSms programSms;
    private ProgramSmsSend programSmsSend;

    public InvitationServiceImpl(InvitationDao invitationDao, PersonneService personneService) {
        this.invitationDao = invitationDao;
        this.personneService = personneService;
        programSmsSend = new ProgramSmsSend();
    }

    @Override
    public Invitation ajouterInvitation(Long idDestinataire, Long idExpediteur) {

        Personne destinataire = personneService.recupererPersonne(idDestinataire);
        Invitation invitation = new Invitation(destinataire, personneService.recupererPersonne(idExpediteur));
        ProgramSms.getSmsAccount();
        programSmsSend.sendSms(destinataire.getTelephone());

        return invitationDao.save(invitation);
    }

    @Override
    public List<Invitation> recupererInvitations() {
        return invitationDao.findAll();
    }

    @Override
    public Invitation recupererInvitation(Long idInvitation) {
        return invitationDao.findById(idInvitation).orElse(null);
    }

    @Override
    public Invitation updateInvitation(Invitation invitation, Boolean estAccepte) {

        if(invitation == null){
            return null;
        } else{
            if(invitation.isEstAccepte() == null){
                //Pr la première et dernière fois l'invité peut décider s'il accepte ou décline l'invit
                invitation.setEstAccepte(estAccepte);
                invitationDao.save(invitation);
            }

            return invitation;
        }

    }

    @Override
    public Invitation recupererInvitationParDestinataireEtId(Personne destinataire, Long id) {
        return invitationDao.findByDestinataireAndId(destinataire, id);
    }

    @Override
    public List<Invitation> recupererInvitationsRecuesSansReponse(Personne personne) {
        return invitationDao.findByDestinataireAndEstAccepteIsNull(personne);
    }

    @Override
    public List<Invitation> recupererInvitationsEnvoyeesSansReponse(Personne personne) {
        return invitationDao.findByExpediteurAndEstAccepteIsNull(personne);
    }


}
