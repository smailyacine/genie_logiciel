package com.app.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.beans.Rdv;
import com.app.dao.DAOException;
import com.app.dao.DAOFactory;
import com.app.dao.RdvDao;

public class SupprimerRdv extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "docteur";
	public static final String ATT_SESSION_LISTE_RDV = "ListeRdv";
	public static final String ATT_SESSION_USER = "sessionPatient";
	public static final String VUE_CONNECT = "/connexionPatient";
	public static final String ATT_SUPPRIMER_RDV = "idRdv";
	public static final String COOKIE_DERNIERE_CONNEXION = "derniereConnexion";
	public static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";
	public static final String VUE = "/WEB-INF/voireRdv.jsp";
	public static final String CONF_DAO_FACTORY= "daofactory";
	public static final int COOKIE_MAX_AGE = 60 * 60 * 24 * 365; // 1 an
	private RdvDao rdvDao;
	private String resultat_ajax;
	public void init() throws ServletException {
		/* Récupération d'une instance de notre DAO Utilisateur */
		this.rdvDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY )).getRdvDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute(ATT_SESSION_USER) == null){
			response.sendRedirect( request.getContextPath() + VUE_CONNECT );
		}else{
		
		Long id = Long.parseLong(request.getParameter(ATT_SUPPRIMER_RDV));
		if(id == null){
			this.getServletContext().getRequestDispatcher( VUE).forward( request, response );
		} else{
	
		try {
			rdvDao.annulerRdv(id);

		}catch( DAOException e ) {
			resultat_ajax = "Échec de lors de l'annulation de rendez-vous : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}
		/* ----------------------------- Supprimer le rendez-vous de la session ------------------------------------------*/
	    ArrayList<Rdv> listRdv= (ArrayList<Rdv>) session.getAttribute(ATT_SESSION_LISTE_RDV);
		for(int i=0;i < listRdv.size(); i++){
			if(listRdv.get(i).getId() == id){
				listRdv.remove(i);
			}
		}
		session.setAttribute(ATT_SESSION_LISTE_RDV,listRdv);
		this.getServletContext().getRequestDispatcher( VUE).forward( request, response );


	}
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/*
	 * M�thode utilitaire g�rant la cr�ation d'un cookie et son ajout � la
	 * r�ponse HTTP.
	 */

}