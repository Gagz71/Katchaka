package fr.humanbooster.fx.katchaka.business;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String contenu;
    private Date dateEnvoi;
    private Date dateLecture;
    @ManyToOne
    private VieCommune vieCommune;
    @ManyToOne
    private Personne expediteur;
    @ManyToOne
    private Personne destinataire;
}