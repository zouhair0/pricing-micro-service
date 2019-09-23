package com.freelance.pricingmicroservice.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.freelance.pricingmicroservice.dao.MissionDao;
import com.freelance.pricingmicroservice.model.Client;
import com.freelance.pricingmicroservice.model.Freelance;
import com.freelance.pricingmicroservice.model.Mission;

@RestController
public class MissionController {
	
	@Autowired
	MissionDao missionDao;
	
	// Récupérer la liste des demandes
	@RequestMapping(value="/listMissions", method=RequestMethod.GET)
	public List<Mission> afficherLesMissions() {
		return missionDao.findDemandes() ;
	}
	
//	// Calculer le pourcentage à partir de l'ID de la régle dans le JSON
//	@GetMapping(value="/Mission/{id}")
//	public String appliquerRegle (@PathVariable int id) {
//		return missionDao.calculateRate (id);
//	}
	
	// Poster les éléments necessaires pour évaluer le pourcentage d'une mission
	@PostMapping(value="/addDemande")
	public void inputDemande(@RequestBody Mission mission) {
		missionDao.ajouterUneDemande(mission);
	}
	
	// Calculer le pourcentage à partir de la mission poster en json avec postman
	@PostMapping(value="/rate")
	public void appliquerRegle (@RequestBody Mission mission) {
		 missionDao.calculateRate (mission);
	}
		
}
