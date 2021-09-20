package fr.humanbooster.fx.katchaka.business;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Personne {

    private static final int NB_CREDITS_INITIAL = 500;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Pattern(regexp="^[A-Za-z0-9]+$", message="Le pseudo doit contenir uniquement des chiffres et des lettres")
    private String pseudo;

    @Size(min = 5)
    private String motDePasse;

    @Email
    private String email;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateDeNaissance;

    @Lob
    @Size(min = 20)
    private String bio;
    private int nbCredits;
    private boolean estFumeur;


    @ManyToOne
    private Genre genre;


    @ManyToOne
    private Genre genreRecherche;


    @ManyToOne
    private Ville ville;


    @ManyToOne
    private Statut statut;

    @NotEmpty(message = "Merci de choisir au moins un interet")
    @ManyToMany
    private List<Interet> interets;

    @OneToMany(mappedBy = "expediteur")
    private List<Message> messagesEnvoyes;

    @OneToMany(mappedBy = "destinataire")
    private List<Message> messagesRecus;
    
    @OneToMany(mappedBy= "expediteur", fetch = FetchType.EAGER)
    private List<Invitation> invitationsEnvoyees;

    @OneToMany(mappedBy= "destinataire")
    private List<Invitation> invitationsRecues;

    public Personne() {
		nbCredits = NB_CREDITS_INITIAL;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public int getNbCredits() {
		return nbCredits;
	}

	public void setNbCredits(int nbCredits) {
		this.nbCredits = nbCredits;
	}

	public boolean isEstFumeur() {
		return estFumeur;
	}

	public void setEstFumeur(boolean estFumeur) {
		this.estFumeur = estFumeur;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Genre getGenreRecherche() {
		return genreRecherche;
	}

	public void setGenreRecherche(Genre genreRecherche) {
		this.genreRecherche = genreRecherche;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public List<Interet> getInterets() {
		return interets;
	}

	public void setInterets(List<Interet> interets) {
		this.interets = interets;
	}

	public List<Message> getMessagesEnvoyes() {
		return messagesEnvoyes;
	}

	public void setMessagesEnvoyes(List<Message> messagesEnvoyes) {
		this.messagesEnvoyes = messagesEnvoyes;
	}

	public List<Message> getMessagesRecus() {
		return messagesRecus;
	}

	public void setMessagesRecus(List<Message> messagesRecus) {
		this.messagesRecus = messagesRecus;
	}

	public List<Invitation> getInvitationsEnvoyees() {
		return invitationsEnvoyees;
	}

	public void setInvitationsEnvoyees(List<Invitation> invitationsEnvoyees) {
		this.invitationsEnvoyees = invitationsEnvoyees;
	}

	public List<Invitation> getInvitationsRecues() {
		return invitationsRecues;
	}

	public void setInvitationsRecues(List<Invitation> invitationsRecues) {
		this.invitationsRecues = invitationsRecues;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", pseudo=" + pseudo + ", motDePasse=" + motDePasse + ", email=" + email
				+ ", dateDeNaissance=" + dateDeNaissance + ", bio=" + bio + ", nbCredits=" + nbCredits + ", estFumeur="
				+ estFumeur + ", genre=" + genre + ", genreRecherche=" + genreRecherche + ", ville=" + ville
				+ ", statut=" + statut + "]";
	}
    
}