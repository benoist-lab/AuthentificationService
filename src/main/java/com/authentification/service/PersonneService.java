package com.authentification.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.authentification.model.Personne;
import com.authentification.repository.PersonneRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonneService {

	private final PersonneRepository personneRepository;
	
    public int save(Personne personne) {
    	return personneRepository.save(personne);
    }

    public int update(Personne personne) {
    	return personneRepository.update(personne);
    }

    public int deleteById(Long id) {
    	return personneRepository.deleteById(id);
    }
    
    public List<Personne> findAll (){
    	return personneRepository.findAll();
    }

    public Personne findById(Long id){
    	Optional<Personne> personne;
    	
    	try {
    		personne=personneRepository.findById(id);
    	}catch (Exception e) {
    		throw new EntityNotFoundException ("personne non trouvée");
    	}
    	if (!personne.isPresent()) {
    		throw new EntityNotFoundException ("personne non trouvée");
    	}
    	
    	return personne.get();
    }
	
    public Personne findByNomPrenom(String nom, String prenom){
    	Optional<Personne> personne;
    	
    	try {
    		personne=personneRepository.findByNomPrenom(nom,prenom);
    	}catch (Exception e) {
    		throw new EntityNotFoundException ("personne non trouvée");
    	}
//    	if (!personne.isPresent()) {
//    		throw new EntityNotFoundException ("personne non trouvée");
//    	}
    	
    	return personne.get();
    }
}
