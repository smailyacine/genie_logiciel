package com.app.dao;

import java.util.ArrayList;
import java.util.Date;

import org.joda.time.DateTime;

import com.app.beans.Creneau;
import com.app.beans.Rdv;

public interface  RdvDao {

	ArrayList<Creneau> trouverRdv(String docteur_identifiant,String date);
	ArrayList<Rdv> trouverRdv(String patientidentifiant);
	void creerRdv_docteur(String identifiant_docteur,String date, Long id_creneau);
	void updateRdv_patient(String id_patient,Creneau creneau,String date);
	void annulerRdv(Long id);
	void supprimerCreneau(String identifiant, Long id, String date);
}
