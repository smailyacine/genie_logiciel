package com.app.beans;

public class Docteur {
	
	
	 private long   id;
	 private String identifiant;
	 private String nom;
	 private String prenom;
	 private String adresse;
	 private String telephone;
	 private String email;
	 private String sexe;
	 private int num_assurance;
	 
	 
	public String getNom() {
		return nom;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public int getNum_assurance() {
		return num_assurance;
	}
	public void setNum_assurance(int num_assurance) {
		this.num_assurance = num_assurance;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	 
	
	

}
