package com.authentification.model;

import lombok.Data;

@Data
public class Personne {

	private Long id;
	private String nom;
	private String prenom;
	
	public Personne () {}
	
	public Personne (Long id, String nom, String prenom) {
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
	}
	
	
}
