package fr.humanbooster.fx.katchaka.dao;

import fr.humanbooster.fx.katchaka.business.Invitation;
import fr.humanbooster.fx.katchaka.business.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvitationDao extends JpaRepository<Invitation, Long> {

    List<Invitation> findByDestinataireAndEstAccepteIsNull(Personne personne);

    List<Invitation> findByExpediteurAndEstAccepteIsNull(Personne personne);

    Invitation findByDestinataireAndId(Personne destinataire, Long idInvitation);
}
