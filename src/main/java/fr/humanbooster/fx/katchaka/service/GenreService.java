package fr.humanbooster.fx.katchaka.service;

import java.util.List;

import fr.humanbooster.fx.katchaka.business.Genre;

public interface GenreService {

	Genre ajouterGenre(String nom);
	
	List<Genre> recupererGenres();

	Genre recupererGenre(String nom);
}


