package com.freelance.pricingmicroservice.dao;

import org.springframework.stereotype.Repository;

import com.freelance.pricingmicroservice.model.Freelance;
import com.freelance.pricingmicroservice.model.Mission;
import com.freelance.pricingmicroservice.model.Client;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Repository
public class MissionDaoImpl implements MissionDao {
	
	public static List<Mission> demandes = new ArrayList<>();
	static {
		Freelance freelance = new Freelance("freelance 1", "Espagne");
		Client client = new Client("client 1", "Espagne");
		demandes.add( new Mission("1 Year","4 Months", freelance, client));
	}
	
	@Override
	public Mission ajouterUneDemande(Mission mission) {	
		demandes.add(mission);
		return mission;
	}
	
	@Override
	public List<Mission> findDemandes() {
		return demandes;
	}
	
	@Override
	public void calculateRate (Mission mission) {	

		//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader("src/main/resources/static/regles/regles.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray reglesList = (JSONArray) obj;
            
            // Parcourir toutes les régles définit dans le JSON
            for (int i = 0; i < reglesList.size(); i++) {
            	JSONArray or = (JSONArray) ((( ((JSONObject) ((JSONObject) ((JSONObject) reglesList.get(i)).get("regle")).get("restrictions")).get("@or"))));
            	
//            	System.out.println("Durée de la relation" + ((JSONObject) ((JSONObject) ((JSONObject) ((JSONObject) reglesList.get(i)).get("regle")).get("restrictions")).get("clientLocation")));
//            	Iterator<JSONObject> iterator = or.iterator();
//                while (iterator.hasNext()) {  	
//                    System.out.println((  ( iterator.next().get("mission.duration")) ));
//                }
            	
            	// Chercher si la régle qui corresponde parmi la liste des régles pour envoyer le taux correspondant
            	if( ((JSONObject) ((JSONObject) ((JSONObject) ((JSONObject) reglesList.get(i)).get("regle")).get("restrictions")).get("clientLocation")).get("country").equals(mission.getClient().getLocation()) )
            		System.out.println("Rate : " + (String) ((JSONObject) ((JSONObject) reglesList.get(i)).get("regle")).get("rate"));
            	else 
            		System.out.println("Rate : 10");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
}
