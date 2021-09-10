package com.authentification.repository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.authentification.model.Personne;
import com.authentification.repository.RowMapper.PersonneRowMapper;
import com.authentification.sqlite.BaseInitialiser;

import lombok.RequiredArgsConstructor;

@Repository
@PropertySource("classpath:sql/personne.req")
@RequiredArgsConstructor
public class PersonneRepositoryImpl implements PersonneRepository {

    private static final Logger logger = LoggerFactory.getLogger(PersonneRepositoryImpl.class);
	
	private final JdbcTemplate jdbcTemplate;
	
	@Value ("${insert_personne}")
	private String REQ_INSERT_PERSONNE;
	
	@Value ("${update_personne}")
	private String REQ_UPDATE_PERSONNE;
	
	@Value ("${delete_personne}")
	private String REQ_DELETE_PERSONNE;
	
	@Value ("${select_All}")
	private String REQ_SELECT_ALL;
	
	@Value("${select_ID}")
	private String REQ_SELECT_ID;
	
	@Value("${SELECT_NOM_PRENOM}")
	private String  REQ_SELECT_NOM_PRENOM;

	@Override
	public int save(Personne personne) {
      return jdbcTemplate.update(REQ_INSERT_PERSONNE,personne.getNom (), personne.getPrenom ());
	}

	@Override
	public int update(Personne personne) {
        return jdbcTemplate.update(REQ_UPDATE_PERSONNE,personne.getNom (), personne.getPrenom (),personne.getId());
	}

	@Override
	public int deleteById(Long id) {
        return jdbcTemplate.update(REQ_DELETE_PERSONNE, id);
	}

	@Override
	public List<Personne> findAll() {
		return jdbcTemplate.query(REQ_SELECT_ALL, new PersonneRowMapper ());
        
	}

	@Override
	public Optional<Personne> findById(Long id) {
		return Optional.of (jdbcTemplate.queryForObject(REQ_SELECT_ID, new PersonneRowMapper (),id));
	}

	@Override
	public Optional<Personne> findByNomPrenom(String nom, String prenom) {
		return Optional.of (jdbcTemplate.queryForObject(REQ_SELECT_NOM_PRENOM, new PersonneRowMapper (),new Object [] {nom,prenom}));
	}


}
