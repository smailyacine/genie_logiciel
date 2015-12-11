package com.app.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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

import com.app.beans.Creneau;
import com.app.beans.Docteur;
import com.app.beans.Patient;
import com.app.dao.DAOException;
import com.app.dao.DAOFactory;
import com.app.dao.DocteurDao;
import com.app.dao.RdvDao;

public class AjouterNouveauCreneau extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "docteur";
	public static final String ATT_FORM = "form";
	public static final String VUE_CONNECT = "/connexionDocteur";
	public static final String DATE_CRENEAU = "date";
	public static final String ATT_SESSION_USER = "sessionDocteur";
	public static final String ATT_SESSION_RDV_CRENEAU = "sessionCreneau";
	public static final String ATT_SESSION_DOCTEUR_LISTE = "sessionDocteurListe";
	public static final String COOKIE_DERNIERE_CONNEXION = "derniereConnexion";
	public static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";
	public static final String VUE = "/WEB-INF/validerNouveauCreneau.jsp";
	public static final String VUE_SUCCES = "/WEB-INF/afficherDocteur.jsp";
	public static final String CONF_DAO_FACTORY= "daofactory";
	public static final int COOKIE_MAX_AGE = 60 * 60 * 24 * 365; // 1 an
	private RdvDao rdvDao;
	private String resultat_liste_docteur;
	private String resultat_ajax;
	public void init() throws ServletException {
		/* Récupération d'une instance de notre DAO Utilisateur */
		this.rdvDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY )).getRdvDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute(ATT_SESSION_USER) == null){
			response.sendRedirect( request.getContextPath() + VUE_CONNECT );
		}else{
			Long creneauId = Long.parseLong(request.getParameter("creneauId")) ;
			Docteur docteur = (Docteur) session.getAttribute(ATT_SESSION_USER);
			String date = (String) session.getAttribute(DATE_CRENEAU);
		try {
			rdvDao.creerRdv_docteur(docteur.getIdentifiant(),date,creneauId);

		}catch( DAOException e ) {
			resultat_ajax = "Échec de la confirmation de rendez-vous : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}
		/* ------------------------- récuperation d'une session etchatgement de liste des médecins ----------------------------------------------------*/
		this.getServletContext().getRequestDispatcher( VUE).forward( request, response );
	}
	}
	/*
	 * M�thode utilitaire g�rant la cr�ation d'un cookie et son ajout � la
	 * r�ponse HTTP.
	 */

}