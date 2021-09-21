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

    public Message() {
        // TODO Auto-generated constructor stub
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public Date getDateLecture() {
        return dateLecture;
    }

    public void setDateLecture(Date dateLecture) {
        this.dateLecture = dateLecture;
    }

    public VieCommune getVieCommune() {
        return vieCommune;
    }

    public void setVieCommune(VieCommune vieCommune) {
        this.vieCommune = vieCommune;
    }

    public Personne getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(Personne expediteur) {
        this.expediteur = expediteur;
    }

    public Personne getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Personne destinataire) {
        this.destinataire = destinataire;
    }

    @Override
    public String toString() {
        return "Message [id=" + id + ", contenu=" + contenu + ", dateEnvoi=" + dateEnvoi + ", dateLecture="
                + dateLecture + ", vieCommune=" + vieCommune + ", expediteur=" + expediteur + ", destinataire="
                + destinataire + "]";
    }

}
