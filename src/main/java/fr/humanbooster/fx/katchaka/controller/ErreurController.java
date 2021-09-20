package fr.humanbooster.fx.katchaka.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class ErreurController implements ErrorController {

    public static final Logger logger = LogManager.getLogger(Logger.class.getName());

    @RequestMapping("/erreur")
    public ModelAndView handleError(HttpServletRequest request){

        Object codeRetour = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        System.out.println(new Date() + " une erreur est survenue !");

        if (codeRetour != null){
            System.out.println("Code retour: "+codeRetour);
            logger.error(request.getRequestURI()+" : erreur: " + codeRetour + request);
        }

        return new ModelAndView("erreur");
    }
}
