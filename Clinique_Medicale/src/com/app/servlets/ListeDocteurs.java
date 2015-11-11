package com.app.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Map;
import java.util.HashMap;

import com.app.beans.Patient;
import com.app.forms.CreationPatientForm;

public class ListeDocteurs extends HttpServlet {
    public static final String ATT_PATIENT = "docteur";
    public static final String ATT_FORM   = "form";
    public static final String ATT_SESSION_PATIENT = "docteurs";
    public static final String VUE = "/WEB-INF/listerDocteurs.jsp";


    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* À la réception d'une requête GET, simple affichage du formulaire */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
}

