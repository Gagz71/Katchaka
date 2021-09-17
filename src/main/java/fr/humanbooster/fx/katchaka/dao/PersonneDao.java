package fr.humanbooster.fx.katchaka.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.humanbooster.fx.katchaka.business.Genre;
import fr.humanbooster.fx.katchaka.business.Interet;
import fr.humanbooster.fx.katchaka.business.Personne;
import fr.humanbooster.fx.katchaka.business.Statut;
import fr.humanbooster.fx.katchaka.business.Ville;

public interface PersonneDao extends JpaRepository<Personne, Long> {

	// Par dérivation
	List<Personne> findByVille(Ville ville);

	// Par HQL
	@Query("FROM Personne where ville=:ville")
	List<Personne> findByVille2(@Param("ville") Ville ville);
	
	@Query("FROM Personne where ville.id=:idDeLaVille")
	List<Personne> findByVille(@Param("idDeLaVille") Long idville);
	
	// Par dérivation
	List<Personne> findByVilleAndGenre(Ville ville, Genre genre);

	// Par HQL
	@Query("FROM Personne where ville=:ville AND genre=:genre ORDER BY interets.size DESC")
	List<Personne> findByVilleAndGenre2(@Param("ville") Ville ville, @Param("genre") Genre genre);

	List<Personne> findByVilleAndGenreAndStatut(Ville ville, Genre genre, Statut statut);
	
	List<Personne> findByEstFumeurIsTrue();
	
	List<Personne> findByEstFumeurIsTrueAndVille(Ville ville);
	
	List<Personne> findByVilleAndGenreAndStatutAndDateDeNaissanceBetween(Ville ville, Genre genre, Statut statut,
			Date dateDebut, Date dateFin);
	
	List<Personne> findByVilleInAndGenreAndStatutAndDateDeNaissanceBetweenAndInteretsContains(List<Ville> villes, Genre genre, Statut statut, Date dateDebut,  Date dateFin, Interet interet);
	
	// Cette méthode est annnotée avec @Query
	// par défaut on doit trouver une requête HQL
	@Query("FROM Personne p WHERE p.invitationsEnvoyees is empty")
	List<Personne> findSansInvitation();
	
	// Cette méthode fait référence à une requête SQL
	@Query(value="SELECT * FROM personne where nbCredits>450 LIMIT 3", nativeQuery=true)
	List<Personne> findHighest3NbCredits();
	
	@Query("FROM Personne ORDER BY interets.size DESC")
	List<Personne> findOrderByNbInterets();

	List<Personne> findByPseudoContaining(String nom);

	Page<Personne> findByPseudoContaining(String filtre, Pageable pageable);

}