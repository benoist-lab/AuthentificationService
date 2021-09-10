package com.authentification.repository;

import java.util.List;
import java.util.Optional;

import com.authentification.model.Personne;

public interface PersonneRepository {

    int save(Personne personne);

    int update(Personne personne);

    int deleteById(Long id);
    
	List<Personne> findAll ();

    Optional<Personne> findById(Long id);
    
    Optional<Personne> findByNomPrenom(String nom, String prenom);
    
	/*
    int count();

    int save(Book book);

    int update(Book book);

    int deleteById(Long id);


    List<Book> findByNameAndPrice(String name, BigDecimal price);


    String getNameById(Long id);
	 */
}
