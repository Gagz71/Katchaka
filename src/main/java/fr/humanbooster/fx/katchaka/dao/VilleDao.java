package fr.humanbooster.fx.katchaka.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.katchaka.business.Ville;

public interface VilleDao extends JpaRepository<Ville, Long> {

	// Methode par dérivation
	Ville findByNom(String nom);

	List<Ville> findByNomStartingWith(String debut);
	List<Ville> findByNomContaining(String nom);
}
