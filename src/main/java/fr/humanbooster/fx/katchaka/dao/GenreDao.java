package fr.humanbooster.fx.katchaka.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.katchaka.business.Genre;

public interface GenreDao extends JpaRepository<Genre, Long> {

	// Methode par dérivation
	/**
	 * Methode qui renvoit le genre dont le nom
	 * est donné en paramètre
	 * @param nom du genre
	 * @return un objet de type Genre, null si le genre correspondant
	 * 			n'a pas été trouvé
	 */
	Genre findByNom(String nom);

}
