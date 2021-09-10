package com.authentification.repository.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.authentification.model.Personne;

public class PersonneRowMapper implements RowMapper <Personne> {

	@Override
	public Personne mapRow(ResultSet rs, int rowNum) throws SQLException {
		Personne personne=new Personne ();

		personne.setId(rs.getLong("id"));
		personne.setNom(rs.getString("nom"));
		personne.setPrenom(rs.getString ("prenom"));
		
		return personne;
	}

}
