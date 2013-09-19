package com.emarket.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.emarket.dao.ILibreriaDao;
import com.emarket.dao.ILibroDao;
import com.emarket.dao.IOfreceDao;
import com.emarket.dao.LibreriaDao;
import com.emarket.dao.LibroDao;
import com.emarket.dao.OfreceDao;
import com.emarket.service.ILibroService;
import com.emarket.service.LibroService;
import com.emarket.service.LibroServiceFactory;

@Configuration
//@EnableTransactionManagement(proxyTargetClass=true)
public class Config {
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("LibreriaJPA");
	}

	@Bean
	public EntityManager entityManager() {
		return entityManagerFactory().createEntityManager();
	}

	@Bean 
	@Scope(value="prototype")
	public ILibroDao libroDao() {
		return new LibroDao(entityManagerFactory());
	}

	@Bean 
	@Scope(value="prototype")
	public ILibreriaDao libreriaDao() {
		return new LibreriaDao(entityManagerFactory());
	}
	
	@Bean 
	@Scope(value="prototype")
	public IOfreceDao ofreceDao() {
		return new OfreceDao(entityManagerFactory());
	}

	@Bean
	public LibroServiceFactory libroServiceFactory() {
		return new LibroServiceFactory();
	}

	@Bean 
	@Scope(value="prototype")
	public ILibroService libroService() {
		return new LibroService();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory());
	}
		
}
