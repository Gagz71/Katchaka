package fr.humanbooster.fx.katchaka.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.katchaka.business.Statut;
import fr.humanbooster.fx.katchaka.dao.StatutDao;
import fr.humanbooster.fx.katchaka.service.StatutService;

@Service
public class StatutServiceImpl implements StatutService {

	private StatutDao statutDao;
	
	public StatutServiceImpl(StatutDao statutDao) {
		super();
		this.statutDao = statutDao;
	}

	@Override
	public Statut ajouterStatut(String nom) {
		return statutDao.save(new Statut(nom));
	}

	@Override
	public List<Statut> recupererStatuts() {
		return statutDao.findAll();
	}

	@Override
	public Statut recupererStatut(String nom) {
		return statutDao.findByNom(nom);
	}

	@Override
	public Statut recupererStatut(Long id) {
		//Si l'id n'est pas trouvé -> on renvoie null
		return statutDao.findById(id).orElse(null);
	}
}