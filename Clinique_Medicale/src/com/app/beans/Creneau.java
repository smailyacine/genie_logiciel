package com.app.beans;

import org.joda.time.DateTime;

public class Creneau {

	private Long id;
	private String hours;
	private DateTime time;
	private String identifiantdocteur;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public DateTime getTime() {
		return time;
	}
	public void setTime(DateTime time) {
		this.time = time;
	}
	public String getIdentifiantdocteur() {
		return identifiantdocteur;
	}
	public void setIdentifiantdocteur(String identifiantdocteur) {
		this.identifiantdocteur = identifiantdocteur;
	}
	
}
