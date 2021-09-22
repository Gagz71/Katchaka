package fr.humanbooster.fx.katchaka.business;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;


@Entity
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom;

	@JsonIgnore
	@OneToMany(mappedBy = "ville", cascade= CascadeType.REMOVE)
	private List<Personne> personnes;

	public Ville() {
	}
	

	public Ville(String nom) {
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


	@Override
	public String toString() {
		return "Ville [id=" + id + ", nom=" + nom + "]";
	}
	
	
}
