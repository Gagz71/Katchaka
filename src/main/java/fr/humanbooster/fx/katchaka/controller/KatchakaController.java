package fr.humanbooster.fx.katchaka.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import fr.humanbooster.fx.katchaka.business.Statut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.fx.katchaka.business.Interet;
import fr.humanbooster.fx.katchaka.business.Personne;
import fr.humanbooster.fx.katchaka.business.Ville;
import fr.humanbooster.fx.katchaka.service.GenreService;
import fr.humanbooster.fx.katchaka.service.InteretService;
import fr.humanbooster.fx.katchaka.service.PersonneService;
import fr.humanbooster.fx.katchaka.service.StatutService;
import fr.humanbooster.fx.katchaka.service.VilleService;

// On indique à Spring que cette classe fait partie de la couche contrôleur
@Controller
public class KatchakaController {

       private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

       // Le contrôleur a besoin de services
       // autrement dit il délègue des traitements à un ou plusieurs services
       private VilleService villeService;
       private StatutService statutService;
       private InteretService interetService;
       private GenreService genreService;
       private PersonneService personneService;

       // Ce constructeur va provoquer l'injection de dépendances
       public KatchakaController(VilleService villeService, StatutService statutService, InteretService interetService,
                                 GenreService genreService, PersonneService personneService) {
              super();
              this.villeService = villeService;
              this.statutService = statutService;
              this.interetService = interetService;
              this.genreService = genreService;
              this.personneService = personneService;
       }

       // Méthode qui traite une requête HTTP dont la méthode est GET et l'URL villes
       // Cette méthode est invoquée lorsqu'un internaute se rend
       // sur l'URL http://localhost:8080 car elle prend en charge
       // l'URL /
       @GetMapping({"/", "index"})
       public ModelAndView home(){
              return new ModelAndView("index");
       }

       @GetMapping({ "villes"})
       public ModelAndView villesGet(@RequestParam(name="FILTRE", defaultValue = "", required = false) String filtre) {
              // On crée un objet de type ModelAndView qui pointe vers la vue villes.jsp
              ModelAndView mav = new ModelAndView("villes");
              // On place dans le model toutes les villes
              mav.addObject("villes", villeService.recupererVilles(filtre));
              // On place dans le mav le filtre en cours
              mav.addObject("filtre", filtre);
              return mav;
       }

       // Méthode qui traite une requête HTTP dont la méthode est GET et l'URL ville
       @GetMapping({"ajouterVille"})
       public ModelAndView villeGet() {
              // On redirige vers la vue ville.jsp
              return new ModelAndView("ville");
       }

       // Méthode qui traite une requête HTTP dont la méthode est POST et l'URL ville
       @PostMapping({"ville"})
       public ModelAndView villePost(@RequestParam("NOM") String nom) {
              villeService.ajouterVille(nom);
              return new ModelAndView("redirect:villes");
       }

       @GetMapping({"interets"})
       public ModelAndView interetsGet(@RequestParam(name="FILTRE", defaultValue="", required = false)String filtre){
              ModelAndView mv = new ModelAndView( "interets");
              mv.addObject("interets", interetService.recupererInterets(filtre));
              mv.addObject("filtre", filtre);
              return mv;

       }

       @GetMapping({"ajouterInteret"})
       public ModelAndView interetGet(){
              return new ModelAndView("interet");
       }

       @PostMapping({"interet"})
       public ModelAndView interetPost(@RequestParam("NOMINT") String nom){
              interetService.ajouterInteret(nom);
              return new ModelAndView("redirect:interets");
       }

       @GetMapping({"personnes"})
       public ModelAndView personnesGet(@RequestParam(name="FILTRE", defaultValue="", required = false)String filtre, @PageableDefault(size=10, page=0, sort="pseudo") Pageable pageable){
              ModelAndView mv = new ModelAndView("personnes");
              Page<Personne> pageDePersonnes = personneService.recupererPersonnes(filtre, pageable);
              mv.addObject("pageDePersonnes", pageDePersonnes);
              mv.addObject("filtre", filtre);
              return mv;
       }

       @PostMapping({"personne"})
       public ModelAndView personnePost(@Valid @ModelAttribute Personne personne, BindingResult result){

              if(result.hasErrors()){
                     ModelAndView mv = personneGet(personne.getId());
                     mv.addObject("personne", personne);
                     return mv;
              } else{
                     personneService.ajouterPersonne(personne);
                     return new ModelAndView("redirect:personnes");
              }
       }

       @GetMapping({"personne"})
       public ModelAndView personneGet(@RequestParam(name="ID", required = false) Long id){

              System.out.println(new Date() + ": nouvelle requête http avec méthode get");
              ModelAndView mv = new ModelAndView("personne");
              Personne personne = null;
              if (id == null){
                     personne = new Personne();
                     //On envoie à la vue un objet personne
                     //objet personne qui sera injecté dans le formulaire hml
                     mv.addObject("personne", personne);
                     //On envoie à la vue la liste des villes
                     mv.addObject("villes", villeService.recupererVilles());
                     mv.addObject("genres", genreService.recupererGenres());
                     mv.addObject("statuts", statutService.recupererStatuts());
                     mv.addObject("interets", interetService.recupererInterets());

              } else{
                     personne = personneService.recupererPersonne(id);

              }
              return mv;
       }

       @GetMapping("supprimerPersonne")
       public ModelAndView personneDelete(@RequestParam(name="ID") Long id) {
              personneService.supprimerPersonne(id);
              return new ModelAndView("redirect:personnes");
       }

       @GetMapping({"statut"})
       public ModelAndView statutGet(@RequestParam(name="ID") Long id){
              System.out.println(new Date() + ": nouvelle requête http avec méthode get");
              //On redirige vers la vue statut.jsp
              ModelAndView mv = new ModelAndView("statut");
              Statut statut = statutService.recupererStatut(id);
              if(statut != null){
                     mv.addObject("statut", statut);
                     return mv;
              } else{
                     return home();
              }
       }

       @GetMapping({"statuts"})
       public ModelAndView statusGet(){
              ModelAndView mv = new ModelAndView("statuts");
              mv.addObject("statuts", statutService.recupererStatuts());
              return mv;
       }

       // Cette méthode serva invoquée dès que Spring a injecté tous les objets
       @PostConstruct
       private void init() {

              if (villeService.recupererVilles().isEmpty()) {
                     villeService.ajouterVille("Lyon");
                     villeService.ajouterVille("Macon");
                     villeService.ajouterVille("Grenoble");
                     villeService.ajouterVille("Annecy");
                     villeService.ajouterVille("Melun");
                     villeService.ajouterVille("Autun");
                     villeService.ajouterVille("Paris");
              }

              if (statutService.recupererStatuts().isEmpty()) {
                     statutService.ajouterStatut("Célibataire");
                     statutService.ajouterStatut("Séparé(e)");
                     statutService.ajouterStatut("Divorcé(e)");
                     statutService.ajouterStatut("Veuf/veuve");
              }

              if (interetService.recupererInterets().isEmpty()) {
                     interetService.ajouterInteret("Moto GP");
                     interetService.ajouterInteret("Formule 1");
                     interetService.ajouterInteret("Manga");
                     interetService.ajouterInteret("Escalade");
                     interetService.ajouterInteret("Guitar éléectrique");
                     interetService.ajouterInteret("Musculation");
                     interetService.ajouterInteret("Course");
                     interetService.ajouterInteret("Boxe thailandaise");
                     interetService.ajouterInteret("Histoire");
                     interetService.ajouterInteret("Oenologie");
                     interetService.ajouterInteret("Jeux vidéo");
                     interetService.ajouterInteret("Poney");
                     interetService.ajouterInteret("Jardinage");
                     interetService.ajouterInteret("Astro-physique");
              }

              if (genreService.recupererGenres().isEmpty()) {
                     genreService.ajouterGenre("Femme");
                     genreService.ajouterGenre("Homme");
              }

              if (personneService.recupererPersonnes().isEmpty()) {
                     //Utilisation d'une boucle pour la création de 100 personnes
                     for (int i = 1; i <= 100; i++) {
                            Personne joaquim = new Personne();
                            joaquim.setPseudo("Joaquim" + i);
                            try {
                                   joaquim.setDateDeNaissance(simpleDateFormat.parse("1980-01-01"));
                            } catch (ParseException e) {
                                   // TODO Auto-generated catch block
                                   e.printStackTrace();
                            }
                            joaquim.setGenre(genreService.recupererGenre("Homme"));
                            joaquim.setGenreRecherche(genreService.recupererGenre("Femme"));
                            joaquim.setVille(villeService.recupererVille("Paris"));
                            joaquim.setStatut(statutService.recupererStatut("Célibataire"));
                            List<Interet> interetsJoaquim = new ArrayList<>();
                            interetsJoaquim.add(interetService.recupererInteret("Escalade"));
                            interetsJoaquim.add(interetService.recupererInteret("Manga"));
                            joaquim.setInterets(interetsJoaquim);
                            personneService.ajouterPersonne(joaquim);
                     }
                     Personne evan = new Personne();
                     evan.setPseudo("Evan");
                     try {
                            evan.setDateDeNaissance(simpleDateFormat.parse("1987-09-26"));
                     } catch (ParseException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                     }
                     evan.setGenre(genreService.recupererGenre("Homme"));
                     evan.setGenreRecherche(genreService.recupererGenre("Femme"));
                     evan.setVille(villeService.recupererVille("Macon"));
                     evan.setStatut(statutService.recupererStatut("Célibataire"));
                     List<Interet> interetsEvan = new ArrayList<>();
                     interetsEvan.add(interetService.recupererInteret("Moto GP"));
                     evan.setInterets(interetsEvan);
                     personneService.ajouterPersonne(evan);

                     Personne tomate = new Personne();
                     tomate.setPseudo("Tomate");
                     try {
                            tomate.setDateDeNaissance(simpleDateFormat.parse("1991-05-05"));
                     } catch (ParseException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                     }
                     tomate.setGenre(genreService.recupererGenre("Femme"));
                     tomate.setGenreRecherche(genreService.recupererGenre("Homme"));
                     tomate.setVille(villeService.recupererVille("Macon"));
                     tomate.setStatut(statutService.recupererStatut("Célibataire"));
                     List<Interet> interetsTomate = new ArrayList<>();
                     interetsTomate.add(interetService.recupererInteret("Musculation"));
                     interetsTomate.add(interetService.recupererInteret("Jardinage"));
                     interetsTomate.add(interetService.recupererInteret("Histoire"));
                     tomate.setInterets(interetsTomate);
                     personneService.ajouterPersonne(tomate);

                     Personne joaquim = new Personne();
                     joaquim.setPseudo("Joaquim");
                     try {
                            joaquim.setDateDeNaissance(simpleDateFormat.parse("1980-01-01"));
                     } catch (ParseException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                     }
                     joaquim.setGenre(genreService.recupererGenre("Homme"));
                     joaquim.setGenreRecherche(genreService.recupererGenre("Femme"));
                     joaquim.setVille(villeService.recupererVille("Paris"));
                     joaquim.setStatut(statutService.recupererStatut("Célibataire"));
                     List<Interet> interetsJoaquim = new ArrayList<>();
                     interetsJoaquim.add(interetService.recupererInteret("Escalade"));
                     interetsJoaquim.add(interetService.recupererInteret("Manga"));
                     joaquim.setInterets(interetsJoaquim);
                     personneService.ajouterPersonne(joaquim);

              }

              List<Personne> femmesCelibatairesDeMacon = personneService.recupererPersonnes(
                      villeService.recupererVille("Macon"),
                      genreService.recupererGenre("Femme"),
                      statutService.recupererStatut("Célibataire"));

              System.out.println(femmesCelibatairesDeMacon);

              // Dates pour les trentenaires
              Calendar calendar = Calendar.getInstance();
              calendar.add(Calendar.YEAR, -39);
              Date dateDebut = calendar.getTime();
              calendar = Calendar.getInstance();
              calendar.add(Calendar.YEAR, -30);
              Date dateFin = calendar.getTime();

              List<Personne> femmesTrentenairesCelibatairesDeMacon = personneService.recupererPersonnes(
                      villeService.recupererVille("Macon"),
                      genreService.recupererGenre("Femme"),
                      statutService.recupererStatut("Célibataire"),
                      dateDebut,
                      dateFin
              );

              System.out.println(femmesTrentenairesCelibatairesDeMacon);

              // Dates pour les quadra
              calendar = Calendar.getInstance();
              calendar.add(Calendar.YEAR, -49);
              dateDebut = calendar.getTime();
              calendar = Calendar.getInstance();
              calendar.add(Calendar.YEAR, -40);
              dateFin = calendar.getTime();
              List<Ville> villes = new ArrayList<>();
              villes.add(villeService.recupererVille("Paris"));
              villes.add(villeService.recupererVille("Grenoble"));

              List<Personne> hommesQuadragenairesCelibatairesDeParisOuGrenobleAimantEscalade =
                      personneService.recupererPersonnes(
                              villes,
                              genreService.recupererGenre("Homme"),
                              statutService.recupererStatut("Célibataire"),
                              dateDebut,
                              dateFin,
                              interetService.recupererInteret("Escalade")
                      );

              System.out.println(hommesQuadragenairesCelibatairesDeParisOuGrenobleAimantEscalade);

              System.out.println("Personnes n'ayant pas encore invité : ");
              for (Personne personne : personneService.recupererPersonnesNAyantPasEncoreInvite()) {
                     System.out.println(personne.getPseudo());
              }

              System.out.println("Personnes triées sur leur nombre d'intérets décroissant : ");
              for (Personne personne : personneService.recupererPersonnesTrieesParNbInterets()) {
                     System.out.println(personne);
              }

              System.out.println("Tous les habitants d'une ville donnée en paramètre : ");
              for (Personne personne : personneService.recupererPersonnes(villeService.recupererVille("Paris").getId())) {
                     System.out.println(personne);
              }


       }

}