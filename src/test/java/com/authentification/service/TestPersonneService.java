package com.authentification.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.authentification.model.Personne;

import lombok.RequiredArgsConstructor;

@SpringBootTest 
@RunWith(SpringRunner.class)
@RequiredArgsConstructor
public class TestPersonneService {
	
	@Autowired
	PersonneService personneService;
	
	@Test
	public void testFindById () {
		Personne personne;
		
		//Personne Existante
		 personne=personneService.findById((long) 3);
		 assertTrue (personne!=null,"la personne d'id=3 n'existe pas");
		
		 // Personne Inexistante
		 assertThrows(EntityNotFoundException.class, () ->{
			 personneService.findById((long) 999);
			 }, "une personne inexistante a été trouvée");
		
	}

	Personne personne=null;

	@Test
	public void testFindByNomPrenom () {
		

		//Personne Existante
		assertDoesNotThrow(() ->{
			personne=personneService.findByNomPrenom("Xavier","Charles");
		}, "une personne existante n'a pas été trouvée");
		 assertTrue (personne!=null,"la personne 'Xavier Charles' n'existe pas");
		 assertTrue (personne.getId()==2,"la personne 'Xavier Charles' n'a pas le bon identifiant");
		
		 // Personne Inexistante
		 assertThrows(EntityNotFoundException.class, () ->{
			 personneService.findByNomPrenom("Fantomes","toto");
			 }, "une personne inexistante a été trouvée");
		
	}
	
}
