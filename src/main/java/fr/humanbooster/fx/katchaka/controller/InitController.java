package fr.humanbooster.fx.katchaka.controller;

import fr.humanbooster.fx.katchaka.business.Interet;
import fr.humanbooster.fx.katchaka.business.Personne;
import fr.humanbooster.fx.katchaka.business.Ville;
import fr.humanbooster.fx.katchaka.service.*;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class InitController {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // Le contrôleur a besoin de services
    // autrement dit il délègue des traitements à un ou plusieurs services
    private VilleService villeService;
    private StatutService statutService;
    private InteretService interetService;
    private GenreService genreService;
    private PersonneService personneService;

    public InitController(VilleService villeService, StatutService statutService, InteretService interetService, GenreService genreService, PersonneService personneService) {
        this.villeService = villeService;
        this.statutService = statutService;
        this.interetService = interetService;
        this.genreService = genreService;
        this.personneService = personneService;
    }


    // Cette méthode serva invoquée dès que Spring a injecté tous les objets
    @PostConstruct
    private void init() {

        //getSmsAccount();

        if (villeService.recupererVilles().isEmpty()) {
            villeService.ajouterVille("Lyon");
            villeService.ajouterVille("Khouribga");
            villeService.ajouterVille("Mâcon");
            villeService.ajouterVille("Grenoble");
            villeService.ajouterVille("Annecy");
            villeService.ajouterVille("Melun");
            villeService.ajouterVille("Autun");
            villeService.ajouterVille("Paris");
            villeService.ajouterVille("Casa");
            villeService.ajouterVille("Le Creusot");
            villeService.ajouterVille("Kyoto");
            villeService.ajouterVille("Shinganshina");
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
            interetService.ajouterInteret("Sauver le monde");
            interetService.ajouterInteret("Histoire");
            interetService.ajouterInteret("Oenologie");
            interetService.ajouterInteret("Jeux vidéo");
            interetService.ajouterInteret("Poney");
            interetService.ajouterInteret("Jardinage");
            interetService.ajouterInteret("Astro-physique");
            interetService.ajouterInteret("Musique");
            interetService.ajouterInteret("Religon");
            interetService.ajouterInteret("Humour");
            interetService.ajouterInteret("Télévision");
            interetService.ajouterInteret("Sports");
            interetService.ajouterInteret("Ménage");
            interetService.ajouterInteret("Bataille");
            interetService.ajouterInteret("Manger des gens");
        }

        if (genreService.recupererGenres().isEmpty()) {
            genreService.ajouterGenre("Femme");
            genreService.ajouterGenre("Homme");
            genreService.ajouterGenre("Sans préférence");
            genreService.ajouterGenre("Titan");
        }

        if (personneService.recupererPersonnes().isEmpty()) {

            Personne mikasa = new Personne();
            mikasa.setPseudo("Mikasa");
            try {
                mikasa.setDateDeNaissance(simpleDateFormat.parse("1991-05-16"));
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            mikasa.setEmail("mikasa@snk.sh");
            mikasa.setMotDePasse("123456");
            mikasa.setEstFumeur(true);
            mikasa.setBio("Shinzooo Sasageyo ! Tatakeo ! C'est moi la plus forte ");
            mikasa.setGenre(genreService.recupererGenre("Femme"));
            mikasa.setGenreRecherche(genreService.recupererGenre("Homme"));
            mikasa.setVille(villeService.recupererVille("Kyoto"));
            mikasa.setStatut(statutService.recupererStatut("Célibataire"));
            List<Interet> interetsMikasa = new ArrayList<>();
            interetsMikasa.add(interetService.recupererInteret("Bataille"));
            interetsMikasa.add(interetService.recupererInteret("Religon"));
            interetsMikasa.add(interetService.recupererInteret("Sauver le monde"));
            mikasa.setInterets(interetsMikasa);
            personneService.ajouterPersonne(mikasa);

            Personne armin = new Personne();
            armin.setPseudo("Armin");
            try {
                armin.setDateDeNaissance(simpleDateFormat.parse("1991-05-05"));
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            armin.setEmail("armin@snk.sh");
            armin.setMotDePasse("123457");
            armin.setGenre(genreService.recupererGenre("Homme"));
            armin.setGenreRecherche(genreService.recupererGenre("Sans préférence"));
            armin.setVille(villeService.recupererVille("Kyoto"));
            armin.setStatut(statutService.recupererStatut("Célibataire"));
            List<Interet> interetsArmin = new ArrayList<>();
            interetsArmin.add(interetService.recupererInteret("Musculation"));
            interetsArmin.add(interetService.recupererInteret("Jardinage"));
            interetsArmin.add(interetService.recupererInteret("Histoire"));
            armin.setInterets(interetsArmin);
            personneService.ajouterPersonne(armin);

            Personne ymir = new Personne();
            ymir.setPseudo("Ymir");
            try {
                ymir.setDateDeNaissance(simpleDateFormat.parse("1980-01-01"));
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ymir.setGenre(genreService.recupererGenre("Femme"));
            ymir.setGenreRecherche(genreService.recupererGenre("Femme"));
            ymir.setVille(villeService.recupererVille("Shinganshina"));
            ymir.setStatut(statutService.recupererStatut("Séparé(e)"));
            List<Interet> interetsYmir = new ArrayList<>();
            interetsYmir.add(interetService.recupererInteret("Escalade"));
            interetsYmir.add(interetService.recupererInteret("Manga"));
            interetsYmir.add(interetService.recupererInteret("Manger des gens"));
            ymir.setInterets(interetsYmir);
            personneService.ajouterPersonne(ymir);

            //Utilisation d'une boucle pour la création de 100 personnes
            for (int i = 1; i <= 50; i++) {
                Personne livai = new Personne();
                livai.setPseudo("Livai" + i);
                try {
                    livai.setDateDeNaissance(simpleDateFormat.parse("1992-03-15"));
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                livai.setGenre(genreService.recupererGenre("Homme"));
                livai.setGenreRecherche(genreService.recupererGenre("Femme"));
                livai.setVille(villeService.recupererVille("Shinganshina"));
                livai.setStatut(statutService.recupererStatut("Célibataire"));
                List<Interet> interetsLivai = new ArrayList<>();
                interetsLivai.add(interetService.recupererInteret("Bataille"));
                interetsLivai.add(interetService.recupererInteret("Ménage"));
                livai.setInterets(interetsLivai);
                personneService.ajouterPersonne(livai);
            }

        }


        List<Personne> femmesCelibatairesDeMacon = personneService.recupererPersonnes(
                villeService.recupererVille("Macon"),
                genreService.recupererGenre("Femme"),
                statutService.recupererStatut("Célibataire")
        );

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
