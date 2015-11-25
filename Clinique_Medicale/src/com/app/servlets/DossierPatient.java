package com.app.servlets;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DossierPatient extends HttpServlet {
	public static final String ATT_SESSION_USER = "sessionPatient";
	public static final String COOKIE_ID_USER = "idpatient";
    public static final String VUE_DOSSIER   = "/WEB-INF/dossierpatient.jsp";
    public static final String VUE_CONNEXION   = "/WEB-INF/dossierpatient.jsp";
    

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* À la réception d'une requête GET, simple affichage du formulaire */
    	String idpatient = getCookieValue(request, COOKIE_ID_USER);
    	HttpSession session = request.getSession();
    	if (idpatient != null || session.getAttribute(ATT_SESSION_USER) != null ) {
    		this.getServletContext().getRequestDispatcher( VUE_DOSSIER  ).forward( request, response );
    	}
    	else{
    		this.getServletContext().getRequestDispatcher( VUE_CONNEXION  ).forward( request, response );
    	}
    	
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        
    }
	private static String getCookieValue(HttpServletRequest request, String nom) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie != null && nom.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
    }
    