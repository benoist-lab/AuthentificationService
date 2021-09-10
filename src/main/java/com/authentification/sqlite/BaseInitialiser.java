package com.authentification.sqlite;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.authentification.model.Personne;
import com.authentification.service.PersonneService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BaseInitialiser {
	private static final Boolean INITIALISATION_ACTIVE=true;


    private static final Logger logger = LoggerFactory.getLogger(BaseInitialiser.class);
	
    //@Autowired
	private final JdbcTemplate jdbcTemplate;
	
	private final PersonneService personneService;
	
	public void initialiserBase () {
		Personne personne;
		
		logger.info(">>> INITIALISATION DE LA BASE DE DONNEES <<<");
		
		// Table PErsonne
		logger.info("Table personne:");
		jdbcTemplate.execute("DROP TABLE IF EXISTS Personne");
		jdbcTemplate.execute("CREATE TABLE Personne(" +
                "id INTEGER PRIMARY KEY,"
                + "nom VARCHAR(255),"
                + " prenom VARCHAR(255)"
                + ")");
		
		
		logger.info("insertion d'une personne:");
		insererPersonne("Dupond", "Albert");
		insererPersonne("Xavier", "Charles");
		insererPersonne("Toulon", "Yvette");
		insererPersonne("De la cours", "Jean-Pierre");
		 
		 
		logger.info("liste des personnes:");
		 for(Personne perso:personneService.findAll()) {
			 afficherPersonne (perso);
		 }
		 
		 
		 //Table Utilisateur
		 logger.info("Table utilisateur:");
		jdbcTemplate.execute("DROP TABLE IF EXISTS Utilisateur");
		
		jdbcTemplate.execute("CREATE TABLE Utilisateur(" +
	                "id INTEGER PRIMARY KEY,"
	                + "login VARCHAR(255),"
	                + " password VARCHAR(255),"
	                + " droit INTEGER,"
	                + " idPersonne INTEGER,"
	                + " FOREIGN KEY(idPersonne) REFERENCES Personne(id)"
	                + ")");
				
		logger.info(">>> INITIALISATION TERMINEE <<<");
						
	}
    
	
	private void insererPersonne(String nom, String prenom) {
		Personne personne;
		
		personne=new Personne ();
		
		personne.setNom(nom);
		
		personne.setPrenom(prenom);
		
		personneService.save(personne);
	}
	
	private void afficherPersonne (Personne personne) {
		logger.info("personne "+personne.getId()+": "+personne.getNom()+" "+personne.getPrenom());
		
		
	}
    
}
