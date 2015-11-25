package com.app.dao;

import java.util.ArrayList;

import org.joda.time.DateTime;

import com.app.beans.Creneau;
import com.app.beans.Rdv;

public interface  RdvDao {

	ArrayList<Creneau> trouverRdv(String docteur_identifiant,String date);
	void creerRdv_docteur(String identifiant_docteur, int id_creneau);
	void updateRdv_patient(String id_patient,Creneau creneau,String date);
}
