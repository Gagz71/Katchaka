package fr.humanbooster.fx.katchaka.filters;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

@Component
@Order(1) //1er filtre que Spring devra appliquer (avant que la méthode dans le contrôleur soit invoquée)
public class CheckPointFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(new Date() + "dans doFilter de CheckPointFilter");

        //Hydratation de l'objet request avec un attribut msDepart
        servletRequest.setAttribute("msDepart", new Date().getTime());

        //On passe la main
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
