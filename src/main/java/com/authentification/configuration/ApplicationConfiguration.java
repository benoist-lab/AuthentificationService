package com.authentification.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.authentification.sqlite.BaseInitialiser;



@Configuration
public class ApplicationConfiguration {

		//Base Données
	  @Bean
	  DefaultConfigurationBean configBeanBaseInitiliser () {
	      return new DefaultConfigurationBean (BaseInitialiser.class,"baseInitialiser","initialiserBase");
	  }
}
