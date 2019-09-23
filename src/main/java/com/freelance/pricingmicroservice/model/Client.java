package com.freelance.pricingmicroservice.model;

public class Client {
	
	String nom;
	String location;
	
	public Client() {
	}
	
	public Client(String nom, String location) {
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
