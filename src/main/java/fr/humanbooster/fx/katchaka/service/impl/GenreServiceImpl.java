package fr.humanbooster.fx.katchaka.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.katchaka.business.Genre;
import fr.humanbooster.fx.katchaka.dao.GenreDao;
import fr.humanbooster.fx.katchaka.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

	private GenreDao genreDao;
	
	public GenreServiceImpl(GenreDao genreDao) {
		super();
		this.genreDao = genreDao;
	}

	@Override
	public Genre ajouterGenre(String nom) {
		return genreDao.save(new Genre(nom));
	}

	@Override
	public List<Genre> recupererGenres() {
		return genreDao.findAll();
	}

	@Override
	public Genre recupererGenre(String nom) {
		return genreDao.findByNom(nom);
	}

}
