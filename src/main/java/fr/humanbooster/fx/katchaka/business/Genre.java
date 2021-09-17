package fr.humanbooster.fx.katchaka.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@Table(name="genre")
public class Genre {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    
    @OneToMany (mappedBy="genre")
    private List<Personne> personnes;
    
    @OneToMany (mappedBy="genreRecherche")
    private List<Personne> personnesRecherchant;
    
    public Genre() {
	}
    
    public Genre(String nom) {
    	this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	public List<Personne> getPersonnesRecherchant() {
		return personnesRecherchant;
	}

	public void setPersonnesRecherchant(List<Personne> personnesRecherchant) {
		this.personnesRecherchant = personnesRecherchant;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", nom=" + nom + "]";
	}
    
}