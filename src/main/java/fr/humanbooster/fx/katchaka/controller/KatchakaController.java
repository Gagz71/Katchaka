package fr.humanbooster.fx.katchaka.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import fr.humanbooster.fx.katchaka.business.*;
import fr.humanbooster.fx.katchaka.service.*;
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
    private InvitationService invitationService;

    private final HttpSession httpSession;

    // Ce constructeur va provoquer l'injection de dépendances
    public KatchakaController(VilleService villeService, StatutService statutService, InteretService interetService,
                              GenreService genreService, PersonneService personneService, HttpSession httpSession, InvitationService invitationService) {
        super();
        this.villeService = villeService;
        this.statutService = statutService;
        this.interetService = interetService;
        this.genreService = genreService;
        this.personneService = personneService;
        this.httpSession = httpSession;
        this.invitationService = invitationService;
    }

    // Méthode qui traite une requête HTTP dont la méthode est GET et l'URL villes
    // Cette méthode est invoquée lorsqu'un internaute se rend
    // sur l'URL http://localhost:8080 car elle prend en charge
    // l'URL /
    @GetMapping({"/", "index", "login"})
    public ModelAndView home(){
        return new ModelAndView("login");
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

    @PostMapping({"login"})
    public ModelAndView personneLogin(@RequestParam(name="EMAIL")String email, @RequestParam(name="PASSWORD")String motDePasse){

        Personne personne = personneService.recupererPersonne(email, motDePasse);

        if(personne == null){
            return home();
        } else{
            httpSession.setAttribute("personne", personne);
            System.out.println(personne);
            return dashboard();
        }
    }

    @GetMapping({"dashboard"})
    public ModelAndView dashboard(){

        ModelAndView mv = new ModelAndView("dashboard");

        Personne personne = (Personne) httpSession.getAttribute("personne");

        List<Invitation> invitationsRecues = invitationService.recupererInvitationsRecuesSansReponse(personne);
        List<Invitation> invitationsEnvoyes = invitationService.recupererInvitationsEnvoyeesSansReponse(personne);

        System.out.println(invitationsRecues);
        System.out.println(invitationsEnvoyes);

        if(personne == null){
            return home();
        }
        mv.addObject("invitationsRecues", invitationService.recupererInvitationsRecuesSansReponse(personne));
        mv.addObject("invitationsEnvoyes", invitationService.recupererInvitationsEnvoyeesSansReponse(personne));

        return mv;
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
            //On envoie à la vue un objet personne
            //objet personne qui sera injecté dans le formulaire hml
            mv.addObject("personne", personne);
            //On envoie à la vue la liste des villes
            mv.addObject("villes", villeService.recupererVilles());
            mv.addObject("genres", genreService.recupererGenres());
            mv.addObject("statuts", statutService.recupererStatuts());
            mv.addObject("interets", interetService.recupererInterets());

        }
        return mv;
    }

    @GetMapping({"personneId"})
    public ModelAndView personneIdGet(@RequestParam(name="ID", required = false) Long id){
        ModelAndView mv = new ModelAndView("personneId");
        Personne personneId = personneService.recupererPersonne(id);
        mv.addObject("personneId", personneId);
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

    @GetMapping({"invitation"})
    public ModelAndView invitationsGet(@RequestParam(name="ID")Long idDestinataire){

        //Récupération de la personne en session
        Personne expediteur = (Personne) httpSession.getAttribute("personne");

        if(expediteur == null){
            return new ModelAndView("redirect:login");
        } else{
            Long idExpediteur = expediteur.getId();
            List<Invitation> invitationsEnvoyees = expediteur.getInvitationsEnvoyees();
            //ajout de la nouvelle invitation à la liste des invitations envoyées
            invitationsEnvoyees.add(invitationService.ajouterInvitation(idDestinataire, idExpediteur));

            System.out.println(expediteur);
            return new ModelAndView ("redirect:dashboard");

        }
    }

    @GetMapping({"responseInvitation"})
    public ModelAndView responseInvitation(@RequestParam("ID") Long idInvitation, @RequestParam("EST_ACCEPTE") boolean estAccepte){
        //Le @RequestParam => dans les liens accepter/décliner on a demander l'ID et el CHOIX

        //On récupère l'invitation dont l'id est donné en param
        Invitation invitation = invitationService.recupererInvitation(idInvitation);

        //Mise à jour du bool est accepté si l'invité à cliquer sur le lien accepter
        invitationService.updateInvitation(invitation, estAccepte);

        return new ModelAndView("redirect:dashboard");
    }

    @GetMapping({"logout"})
    public ModelAndView personneLogout(){
        httpSession.invalidate();
        return new ModelAndView("redirect:login");

    }



}