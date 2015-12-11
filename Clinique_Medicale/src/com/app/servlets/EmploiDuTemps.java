package com.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmploiDuTemps extends HttpServlet {

    public static final String VUE_EMPLOITEMPS   = "/WEB-INF/emploiTemps.jsp";
    

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* À la réception d'une requête GET, simple affichage du formulaire */
    	this.getServletContext().getRequestDispatcher( VUE_EMPLOITEMPS ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    }
    }