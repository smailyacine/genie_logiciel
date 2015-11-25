package com.app.servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.app.metiers.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import com.app.beans.Consultation;
import com.app.beans.Patient;
import com.app.dao.ConsultationDao;
import com.app.dao.DAOFactory;
import com.app.dao.DocteurDao;

public class ListeConsultation extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "docteur";
	public static final String ATT_FORM = "form";
	public static final String ATT_SESSION_RESULTAT = "resultat_liste_docteur";
	public static final String ATT_CONSULTATION_LISTE = "consultationListe";
	public static final String ATT_CONSULTATION_FORM = "consultationForm";
	public static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";
	public static final String VUE = "/WEB-INF/consultationPatient.jsp";
	public static final String CONF_DAO_FACTORY= "daofactory";
	public static final String ATT_SESSION_USER = "sessionPatient";
	private ConsultationDao consultationDao;
	private DocteurDao docteurDao;
	public void init() throws ServletException {
    	/* Récupération d'une instance de notre DAO Utilisateur */
    	this.consultationDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY )).getConsultationDao();
    	this.docteurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY )).getDocteurDao();
    	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/* --------------------------------        récupérer la liste des consltations     ------------------------------------------------------------*/
		
	ArrayList<Consultation> consultationListe =  new ArrayList<Consultation>();
	HttpSession session = request.getSession();
	Patient patient = (Patient) session.getAttribute(ATT_SESSION_USER);
	ConsultationMetiers consultationForm = new ConsultationMetiers(consultationDao,docteurDao);
	consultationListe = consultationForm.consultationPatient(patient);
	

	/* ------------------------- récuperation d'une session etchatgement de liste des médecins ----------------------------------------------------*/
	
	session.setAttribute(ATT_CONSULTATION_LISTE,consultationListe );
	session.setAttribute( ATT_CONSULTATION_FORM,consultationForm );
	
	this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/*
	 * M�thode utilitaire g�rant la cr�ation d'un cookie et son ajout � la
	 * r�ponse HTTP.
	 */
	
}