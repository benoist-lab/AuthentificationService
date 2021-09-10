package com.authentification;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.authentification.repository.PersonneRepository;


//https://www.codejava.net/frameworks/spring-boot/how-to-use-jdbc-with-spring-boot
//https://www.vogella.com/tutorials/SpringJDBC/article.html		 RowMapper
//https://mkyong.com/spring-boot/spring-boot-jdbc-examples/

@SpringBootApplication
public class AuthentificationServiceApplication {
	
    @Qualifier("personneRepositoryImpl")              // Test JdbcTemplate
    private PersonneRepository personneRepository;

	public static void main(String[] args) {
		SpringApplication.run(AuthentificationServiceApplication.class, args);
	}

}
