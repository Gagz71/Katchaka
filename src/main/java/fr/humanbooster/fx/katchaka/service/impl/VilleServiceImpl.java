package fr.humanbooster.fx.katchaka.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.katchaka.business.Ville;
import fr.humanbooster.fx.katchaka.dao.VilleDao;
import fr.humanbooster.fx.katchaka.service.VilleService;

// On indique à Spring que cette classe appartient à la couche de service
@Service
public class VilleServiceImpl implements VilleService {

	// Ce service a besoin d'une DAO
	private VilleDao villeDao;
	
	// Constructeur qui va provoquer une injection de dépendance
	// La dépendance est villeDao
	// Spring va tout d'abord instancier un objet de type VilleDao
	// avant d'instancier un objet de type VilleService
	public VilleServiceImpl(VilleDao villeDao) {
		super();
		this.villeDao = villeDao;
	}


	@Override
	public Ville ajouterVille(String nom) {
		return villeDao.save(new Ville(nom));
	}


	@Override
	public List<Ville> recupererVilles() {
		return villeDao.findAll();
	}


	@Override
	public Ville recupererVille(String nom) {
		// On fait appel à une méthode par dérivation
		return villeDao.findByNom(nom);
	}

	@Override
	public Ville recupererVille(Long id) {

		//Ne pas oublier .orElse pour éviter erreur d'incompatibilité Optionnal jsais pas quoi
		return villeDao.findById(id).orElse(null);
	}

	@Override
	public List<Ville> recupererVilles(String nom) {
		return villeDao.findByNomContaining(nom);
	}

	@Override
	public boolean supprimerVille(Long id) {

		Ville ville = villeDao.findById(id).orElse(null);

		if(ville == null){
			return false;
		}
		villeDao.delete(ville);
		return true;

	}

	@Override
	public Ville enregistrerVille(Ville ville) {
		return villeDao.save(ville);
	}
}
