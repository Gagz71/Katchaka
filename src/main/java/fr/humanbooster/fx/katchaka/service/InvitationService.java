package fr.humanbooster.fx.katchaka.service;

import fr.humanbooster.fx.katchaka.business.Invitation;
import fr.humanbooster.fx.katchaka.business.Personne;

import java.util.Collection;
import java.util.List;

public interface InvitationService {

    Invitation ajouterInvitation(Long idDestinataire, Long idExpediteur);

    List<Invitation> recupererInvitations();

    Invitation recupererInvitation(Long idInvitation);

    Invitation recupererInvitationParDestinataireEtId(Personne destinataire, Long id);

    Invitation updateInvitation(Invitation invitation, Boolean estAccepte);

    List<Invitation> recupererInvitationsRecuesSansReponse(Personne personne);

    List<Invitation> recupererInvitationsEnvoyeesSansReponse(Personne personne);

}
