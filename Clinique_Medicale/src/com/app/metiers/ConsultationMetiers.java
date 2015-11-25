package com.app.metiers;

import java.util.ArrayList;

import com.app.beans.Consultation;
import com.app.beans.Docteur;
import com.app.beans.Patient;
import com.app.dao.ConsultationDao;
import com.app.dao.DAOException;
import com.app.dao.DocteurDao;

public class ConsultationMetiers {

	private ConsultationDao consultationtDao;
	private String resultat_consultation_liste;
	public ConsultationMetiers(ConsultationDao consultationDao, DocteurDao docteurDao) {
		this.consultationtDao = consultationDao;
	}


	public ArrayList<Consultation> consultationPatient(Patient patient){
		ArrayList<Consultation> consultation = new ArrayList<Consultation>();
		try {
			consultation = consultationtDao.trouverPatient(patient);
			if(consultation == null){
				
				resultat_consultation_liste = "Pas de consultation pour effectué pour Vous.";
			}
			else{
				resultat_consultation_liste = "La liste des consultation effectué par vous .";
			}
		}
		catch ( DAOException e ) {
			resultat_consultation_liste = "Échec de la connexion du table de consultation : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}
		return consultation;
	
}

}
