package fr.humanbooster.fx.katchaka.service;

import java.util.List;

import fr.humanbooster.fx.katchaka.business.Interet;

public interface InteretService {

	Interet ajouterInteret(String nom);
	
	List<Interet> recupererInterets();

	List<Interet> recupererInterets(String nom);

	Interet recupererInteret(String string);
	
}
