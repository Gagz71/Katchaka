package fr.humanbooster.fx.katchaka.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.humanbooster.fx.katchaka.business.Genre;
import fr.humanbooster.fx.katchaka.business.Interet;
import fr.humanbooster.fx.katchaka.business.Personne;
import fr.humanbooster.fx.katchaka.business.Statut;
import fr.humanbooster.fx.katchaka.business.Ville;
import fr.humanbooster.fx.katchaka.dao.PersonneDao;
import fr.humanbooster.fx.katchaka.service.PersonneService;

@Service
public class PersonneServiceImpl implements PersonneService {

	private PersonneDao personneDao;
	
	public PersonneServiceImpl(PersonneDao personneDao) {
		super();
		this.personneDao = personneDao;
	}
	@Override
	public Personne ajouterPersonne(Personne personne) {
		return personneDao.save(personne);
	}

	@Override
	public Personne recupererPersonne(Long id) {
		return personneDao.findById(id).orElse(null);
	}

	@Override
	public List<Personne> recupererPersonnes() {
		return personneDao.findAll();
	}


	@Override
	public List<Personne> recupererPersonnes(String nom) {
		return personneDao.findByPseudoContaining(nom);
	}

	@Override
	public List<Personne> recupererPersonnes(Long idVille) {
		return personneDao.findByVille(idVille);
	}
	
	@Override
	public List<Personne> recupererPersonnes(Ville ville, Genre genre) {
		return personneDao.findByVilleAndGenre(ville, genre);
	}

	@Override
	public List<Personne> recupererPersonnes(Ville ville, Genre genre, Statut statut) {
		return personneDao.findByVilleAndGenreAndStatut(ville, genre, statut);
	}

	@Override
	public List<Personne> recupererPersonnes(Ville ville, Genre genre, Statut statut, Date dateDebut, Date dateFin) {
		return personneDao.findByVilleAndGenreAndStatutAndDateDeNaissanceBetween(ville, genre, statut, dateDebut, dateFin);
	}

	@Override
	public List<Personne> recupererPersonnes(List<Ville> villes, Genre genre, Statut statut, Date dateDebut, Date dateFin, Interet interet) {
		return personneDao.findByVilleInAndGenreAndStatutAndDateDeNaissanceBetweenAndInteretsContains(villes, genre, statut, dateDebut, dateFin, interet);
	}

	@Override
	public List<Personne> recupererPersonnesNAyantPasEncoreInvite() {
		return personneDao.findSansInvitation();
	}

	@Override
	public List<Personne> recupererPersonnesTrieesParNbInterets() {
		return personneDao.findOrderByNbInterets();
	}

	@Override
	public Page<Personne> recupererPersonnes(String filtre, Pageable pageable) {
		// On transmet le filtre et le pageable à la DAO
		return personneDao.findByPseudoContaining(filtre, pageable);
	}
}
