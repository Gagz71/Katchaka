package fr.humanbooster.fx.katchaka.service;

import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.katchaka.business.Genre;
import fr.humanbooster.fx.katchaka.business.Interet;
import fr.humanbooster.fx.katchaka.business.Personne;
import fr.humanbooster.fx.katchaka.business.Statut;
import fr.humanbooster.fx.katchaka.business.Ville;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonneService {

	Personne ajouterPersonne(Personne personne);

	Personne recupererPersonne(Long id);
	
	List<Personne> recupererPersonnes();

	List<Personne> recupererPersonnes(String nom);

	List<Personne> recupererPersonnes(Long idVille);
	
	List<Personne> recupererPersonnes(Ville ville, Genre genre);

	List<Personne> recupererPersonnes(Ville recupererVilleParNom, Genre recupererGenre, Statut recupererStatut);

	List<Personne> recupererPersonnes(Ville recupererVille, Genre recupererGenre, Statut recupererStatut,
			Date dateDebut, Date dateFin);

	List<Personne> recupererPersonnes(List<Ville> villes, Genre recupererGenre, Statut recupererStatut, Date dateDebut,
			Date dateFin, Interet recupererInteret);
	
	List<Personne> recupererPersonnesNAyantPasEncoreInvite();
	
	List<Personne> recupererPersonnesTrieesParNbInterets();

	Page<Personne> recupererPersonnes(String filtre, Pageable pageable);

    boolean supprimerPersonne(Long id);

	Personne recupererPersonne(String email, String motDePasse);
}
