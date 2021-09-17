package fr.humanbooster.fx.katchaka.business;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Invitation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnvoi;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLecture;
    private boolean estAccepte;
    @ManyToOne
    private Personne expediteur;
    @ManyToOne
    private Personne destinataire;
    @OneToOne
    private VieCommune vieCommune;

}