package com.app.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
import com.app.dao.DAOException;
import com.app.dao.DAOFactory;
import com.app.dao.DocteurDao;
import com.app.dao.RdvDao;

public class AjouterCreneauMedcin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String creaneau1 = "08:00-08:30";
	public static final String creaneau2 = "08:30-09:00";
	public static final String creaneau3 = "09:00-09:30";
	public static final String creaneau4 = "09:30-10:00";
	public static final String creaneau5 = "10:00-10:30";
	public static final String creaneau6 = "10:30-11:00";
	public static final String creaneau7 = "11:00-11:30";
	public static final String creaneau8 = "11:30-12:00";
	public static final String creaneau9 = "14:00-14:30";
	public static final String creaneau10 = "14:30-15:00";
	public static final String creaneau11 = "15:00-15:30";
	public static final String creaneau12 = "15:30-16:00";

	
	public static final String ATT_USER = "docteur";
	public static final String DATE_CRENEAU = "date";
	public static final String ATT_FORM = "form";
	public static final String ATT_SESSION_USER = "sessionDocteur";
	public static final String LISTE_CRENEAUX_DOC = "listeDisponible";
	public static final String ATT_SESSION_RDV_CRENEAU = "sessionCreneau";
	public static final String COOKIE_DERNIERE_CONNEXION = "derniereConnexion";
	public static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";
	public static final String VUE_CONNECT = "/connexionDocteur";
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
	/* --------------------------------        récupérer la liste des médecins     ------------------------------------------------------------*/
		HttpSession session = request.getSession();
		 LinkedHashMap<String, Integer> CreneauxListeString = new  LinkedHashMap<>();
		 String date =  request.getParameter("date");
		CreneauxListeString.put(creaneau1,1);
		CreneauxListeString.put(creaneau2,2);
		CreneauxListeString.put(creaneau3,3);
		CreneauxListeString.put(creaneau4,4);
		CreneauxListeString.put(creaneau5,5);
		CreneauxListeString.put(creaneau6,6);
		CreneauxListeString.put(creaneau7,7);
		CreneauxListeString.put(creaneau8,8);
		CreneauxListeString.put(creaneau9,9);
		CreneauxListeString.put(creaneau10,10);
		CreneauxListeString.put(creaneau11,11);
		CreneauxListeString.put(creaneau12,12);
		
		if(session.getAttribute(ATT_SESSION_USER) == null){
			response.sendRedirect( request.getContextPath() + VUE_CONNECT );
		}else{
		
		ArrayList<Creneau> listecreneau =  new ArrayList<Creneau>();
		Docteur docteur = (Docteur) session.getAttribute(ATT_SESSION_USER);
		try {
			listecreneau = rdvDao.trouverRdv(docteur.getIdentifiant(), date);
				if(listecreneau.size() == 0){
					resultat_ajax = "<div class=\"erreur\"> toutes la journée est vide !.</div>";
				}
				else{
					
					resultat_ajax = "<div class=\"creneau_exist\">Liste des créneaux déja pris:</div>";
					for(int i=0; i<listecreneau.size(); i++){
						if(listecreneau.get(i).getId() == 1){
							CreneauxListeString.remove(creaneau1);
							
						}else if (listecreneau.get(i).getId() == 2){
							CreneauxListeString.remove(creaneau2);
							
						}else if (listecreneau.get(i).getId() == 3){
							CreneauxListeString.remove(creaneau3);
							
						}else if (listecreneau.get(i).getId() == 4){
							CreneauxListeString.remove(creaneau4);
							
						}else if (listecreneau.get(i).getId() == 5){
							CreneauxListeString.remove(creaneau5);
						}else if (listecreneau.get(i).getId() == 6){
							CreneauxListeString.remove(creaneau6);
						}else if (listecreneau.get(i).getId() == 7){
							CreneauxListeString.remove(creaneau7);
						}else if (listecreneau.get(i).getId() == 8){
							CreneauxListeString.remove(creaneau8);
						}else if (listecreneau.get(i).getId() == 9){
							CreneauxListeString.remove(creaneau9);
						}else if (listecreneau.get(i).getId() == 10){
							CreneauxListeString.remove(creaneau10);
						}else if (listecreneau.get(i).getId() == 11){
							CreneauxListeString.remove(creaneau11);
						}else if (listecreneau.get(i).getId() == 12){
							CreneauxListeString.remove(creaneau12);
						}
						
					}
					
				} 
		}catch( DAOException e ) {
			resultat_ajax = "Échec de la connexion lors de la récupération des créneaux : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}
		
		
		/* ------------------------- récuperation d'une session etchatgement de liste des médecins ----------------------------------------------------*/
		session.setAttribute(DATE_CRENEAU, date);
		session.setAttribute(LISTE_CRENEAUX_DOC, CreneauxListeString);
		session.setAttribute(ATT_SESSION_RDV_CRENEAU, listecreneau);
		response.setContentType("text/xml");
	    response.setHeader("Cache-Control", "no-cache");
	    response.getWriter().write(resultat_ajax);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/*
	 * M�thode utilitaire g�rant la cr�ation d'un cookie et son ajout � la
	 * r�ponse HTTP.
	 */
	
}