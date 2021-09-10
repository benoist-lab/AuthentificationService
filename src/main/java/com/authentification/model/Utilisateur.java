package com.authentification.model;

import lombok.Data;

@Data
public class Utilisateur {
	private Long id;
	private String login;
	private String password;
	private int droit;
	private Long idPersonne;
}
