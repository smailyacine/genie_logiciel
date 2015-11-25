package com.app.beans;

public class Consultation {

	private Long ID;
	private String nomPatient;
	private String nomDocteur;
	private String prenomPatient;
	private String prenomDocteur;
	private String date;
	private String diagnostique;
	private String test;

	public Consultation() {
		
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}





	public String getDiagnostique() {
		return diagnostique;
	}

	public void setDiagnostique(String diagnostique) {
		this.diagnostique = diagnostique;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getNomPatient() {
		return nomPatient;
	}

	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}

	public String getNomDocteur() {
		return nomDocteur;
	}

	public void setNomDocteur(String nomDocteur) {
		this.nomDocteur = nomDocteur;
	}

	public String getPrenomPatient() {
		return prenomPatient;
	}

	public void setPrenomPatient(String prenomPatient) {
		this.prenomPatient = prenomPatient;
	}

	public String getPrenomDocteur() {
		return prenomDocteur;
	}

	public void setPrenomDocteur(String prenomDocteur) {
		this.prenomDocteur = prenomDocteur;
	}


	

}
