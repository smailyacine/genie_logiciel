package com.app.beans;

import org.joda.time.DateTime;

public class Rdv {

	private String nomPatient;
	private String prenomPatient;
	private String nomDocteur;
	private String prenomDocteur;
	private String specialite;
	private String creneau;
	private DateTime time;
	public String getNomPatient() {
		return nomPatient;
	}
	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}
	public String getPrenomPatient() {
		return prenomPatient;
	}
	public void setPrenomPatient(String prenomPatient) {
		this.prenomPatient = prenomPatient;
	}
	public String getNomDocteur() {
		return nomDocteur;
	}
	public void setNomDocteur(String nomDocteur) {
		this.nomDocteur = nomDocteur;
	}
	public String getPrenomDocteur() {
		return prenomDocteur;
	}
	public void setPrenomDocteur(String prenomDocteur) {
		this.prenomDocteur = prenomDocteur;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getCreneau() {
		return creneau;
	}
	public void setCreneau(String creneau) {
		this.creneau = creneau;
	}
	public DateTime getTime() {
		return time;
	}
	public void setTime(DateTime time) {
		this.time = time;
	}
}
