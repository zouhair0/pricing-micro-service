package com.freelance.pricingmicroservice.dao;

import java.util.List;

import com.freelance.pricingmicroservice.model.Mission;

public interface MissionDao {
	
	public void calculateRate(Mission mission);
	public Mission ajouterUneDemande(Mission mission);
	public List<Mission> findDemandes();	
}
