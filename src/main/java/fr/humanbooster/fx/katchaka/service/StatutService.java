package fr.humanbooster.fx.katchaka.service;

import java.util.List;

import fr.humanbooster.fx.katchaka.business.Statut;

public interface StatutService {

	Statut ajouterStatut(String nom);

	List<Statut> recupererStatuts();

	Statut recupererStatut(String nom);
	Statut recupererStatut(Long id);

}
