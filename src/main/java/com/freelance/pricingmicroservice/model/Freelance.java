package com.freelance.pricingmicroservice.model;

public class Freelance {
	
	String nom;
	String location;
	
	public Freelance() {
	}
	
	public Freelance(String nom, String location) {
		this.nom = nom;
		this.location = location;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
}
