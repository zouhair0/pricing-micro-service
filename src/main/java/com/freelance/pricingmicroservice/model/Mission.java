package com.freelance.pricingmicroservice.model;

public class Mission {
	
	String duree;
	String commercialRelation;
	Freelance freelance;
	Client client;
	
	public Mission() {	
	}
	
	public Mission(String duree, String commercialRelation, Freelance freelance, Client client) {
		this.duree = duree;
		this.commercialRelation = commercialRelation;
		this.freelance = freelance;
		this.client = client;	
	}
	
	public Freelance getFreelance() {
		return freelance;
	}

	public void setFreelance(Freelance freelance) {
		this.freelance = freelance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public String getDuree() {
		return duree;
	}
	
	public void setDuree(String duree) {
		this.duree = duree;
	}

	public String getCommercialRelation() {
		return commercialRelation;
	}
	
	public void setCommercialRelation(String commercialRelation) {
		this.commercialRelation = commercialRelation;
	}
}
