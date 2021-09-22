package fr.humanbooster.fx.katchaka.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.humanbooster.fx.katchaka.business.Ville;
import fr.humanbooster.fx.katchaka.service.VilleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Le RestController fait appel à la bibliothèque Jackson pour sérialiser les retours des méthodes
@RequestMapping("api/")
//rajouter api car url déjà prise par autre controller
public class KatchakaRestController {

    private VilleService villeService;

    public KatchakaRestController(VilleService villeService) {
        this.villeService = villeService;
    }

    @PostMapping("villes/{nom}")
    public Ville ajouterVille(@PathVariable String nom){
        return villeService.ajouterVille(nom);
    }

    @GetMapping("villes")
    public List<Ville> recupererVilles(){
        return villeService.recupererVilles();
    }

    @GetMapping("ville/{id}")
    public Ville recupererVille(@PathVariable Long id){
        return villeService.recupererVille(id);
    }

    //Pour le delete, si clé étrangère dans la classe -> cascade !
    //Exemple => liste de personnes dans villes -> si on supprime ville il faut que les personnes de cette ville se supprime -> cascade sur la liste des personnes dans la classe Ville
    // -> Mais Personne a liste d'invit donc si on supprime des personnes d'une ville -> supprimer invitation des personnes, interets des personnes etc .. donc cascade sur toutes les listes dans personnes
    @DeleteMapping("ville/{id}")
    public boolean supprimerVille(@PathVariable Long id){
        return villeService.supprimerVille(id);
    }

    @PutMapping("/ville/{id}/{nom}")
    public Ville modifierVille(@PathVariable Long id, @PathVariable String nom){
        Ville ville = villeService.recupererVille(id);
        if(ville != null){
            ville.setNom(nom);
            return villeService.enregistrerVille(ville);
        }
        return null;
    }


}
