package com.isaque.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.isaque.bookstore.service.BDService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private BDService bdService;

	//@Value("${spring.jpa.hibernate.ddl-auto}")
	//private String strategy;

	@Bean
	public void instanciaBancoDeDados() {

		this.bdService.instanciaBancoDeDados();

	}
}
