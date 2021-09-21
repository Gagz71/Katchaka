package fr.humanbooster.fx.katchaka.business;

import fr.humanbooster.fx.katchaka.business.Message;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class VieCommune {
    
    private static final int NB_CREDITS_PAR_DEFAUT = 10;
    
    // Determine quell est la clé primaire de la table
    @Id
    
    // L'annotation ci-dessous ajoute un auto-incrément sur la collone id VieCommune
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private int nbCredits;
    
    // Tous les messages échangés pendant la vie commune
    @OneToMany(mappedBy="vieCommune")
    private List<Message> messages;
    
    @OneToOne
    private Invitation invitation;

}