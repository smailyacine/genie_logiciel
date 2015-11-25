package com.app.servlets;

import java.io.IOException;
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

import com.app.beans.Docteur;
import com.app.dao.DAOException;
import com.app.dao.DAOFactory;
import com.app.dao.DocteurDao;

public class RecupDocsMenu extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "docteur";
	public static final String ATT_FORM = "form";
	public static final String ATT_SESSION_RESULTAT = "resultat_liste_docteur";
	public static final String ATT_SESSION_DOCTEUR_LISTE = "sessionDocteurListe";
	public static final String COOKIE_DERNIERE_CONNEXION = "derniereConnexion";
	public static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";
	public static final String VUE = "/WEB-INF/prendreRDV.jsp";
	public static final String VUE_SUCCES = "/WEB-INF/afficherDocteur.jsp";
	public static final String CONF_DAO_FACTORY= "daofactory";
	public static final int COOKIE_MAX_AGE = 60 * 60 * 24 * 365; // 1 an
	private DocteurDao docteurDao;
	private String resultat_liste_docteur;
	private String resultat_ajax;
	public void init() throws ServletException {
    	/* Récupération d'une instance de notre DAO Utilisateur */
    	this.docteurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY )).getDocteurDao();
    	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/* --------------------------------        récupérer la liste des médecins     ------------------------------------------------------------*/
	
		
		String specialite =  request.getParameter("specialite");
		if(specialite == null){
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}
		else{
		ArrayList<Docteur> listedocteur =  new ArrayList<Docteur>();
		
		try {
				listedocteur = docteurDao.trouverSpecialite(specialite);
				if(listedocteur == null){
					resultat_liste_docteur = "Pas de médecin disponible pour le moment !.";
				}
				else{
					resultat_liste_docteur = "Liste des médecins .";
				} 
		}catch( DAOException e ) {
			resultat_liste_docteur = "Échec de la connexion lors de la récupération de liste des médecins : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}
		resultat_ajax = "<select name = \"docteurliste\" id =\"docteurliste\"  onchange=\"EmploiDuTemps(this.options[this.selectedIndex].value)\">";
		resultat_ajax += "<option value= \"1\" \">"+" Veillez selectionnez un medcin "+"</option>";
		for(Docteur d: listedocteur){
		resultat_ajax +="<option value =\""+ d.getIdentifiant() +"\">"+d.getNom()+ " " +d.getPrenom()+"</option>";
		}
		resultat_ajax += "</select>";
		
		/* ------------------------- récuperation d'une session etchatgement de liste des médecins ----------------------------------------------------*/
		
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