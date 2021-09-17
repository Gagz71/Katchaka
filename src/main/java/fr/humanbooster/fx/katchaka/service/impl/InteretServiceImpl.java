package fr.humanbooster.fx.katchaka.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.katchaka.business.Interet;
import fr.humanbooster.fx.katchaka.dao.InteretDao;
import fr.humanbooster.fx.katchaka.service.InteretService;

@Service
public class InteretServiceImpl implements InteretService {

	private InteretDao interetDao;
	
	public InteretServiceImpl(InteretDao interetDao) {
		super();
		this.interetDao = interetDao;
	}

	@Override
	public Interet ajouterInteret(String nom) {
		return interetDao.save(new Interet(nom));
	}

	@Override
	public List<Interet> recupererInterets() {
		return interetDao.findAll();
	}

	@Override
	public List<Interet> recupererInterets(String nom) {
		return interetDao.findByNomContaining(nom);
	}

	@Override
	public Interet recupererInteret(String nom) {
		return interetDao.findByNom(nom);
	}

}
