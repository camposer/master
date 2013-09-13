package com.indra.formacion.hibernate.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.indra.formacion.hibernate.dao.ILibreriaDao;
import com.indra.formacion.hibernate.dao.ILibroDao;
import com.indra.formacion.hibernate.dao.IOfreceDao;
import com.indra.formacion.hibernate.dao.LibreriaDao;
import com.indra.formacion.hibernate.dao.LibroDao;
import com.indra.formacion.hibernate.dao.OfreceDao;
import com.indra.formacion.hibernate.dao.TransactionProxy;
import com.indra.formacion.hibernate.dao.TransactionProxyFactory;
import com.indra.formacion.hibernate.service.ILibreriaService;
import com.indra.formacion.hibernate.service.ILibroService;
import com.indra.formacion.hibernate.service.LibreriaServiceImpl;
import com.indra.formacion.hibernate.service.LibroServiceImpl;

@Configuration
public class Config {
	/**
	 * Ref: libroDao y LibroService
	 * @return
	 */
	@Bean
	public ILibroService libroService() {
		return new LibroServiceImpl();
	}
	
	@Bean
	public ILibreriaService libreriaService() {
		return new LibreriaServiceImpl();
	}
	
	@Bean(initMethod="init")
	public ILibroDao libroDao() {
		LibroDao libroDao = new LibroDao(false);
		libroDao.setEntityManagerFactory(entityManagerFactory());
		return libroDao;
	}

	@Bean(initMethod="init")
	public IOfreceDao ofreceDao() {
		OfreceDao ofreceDao = new OfreceDao(false);
		ofreceDao.setEntityManagerFactory(entityManagerFactory());
		return ofreceDao;
	}

	@Bean(initMethod="init")
	public ILibreriaDao libreriaDao() {
		LibreriaDao libreriaDao = new LibreriaDao();
		libreriaDao.setEntityManagerFactory(entityManagerFactory());
		return libreriaDao;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("LibreriaJPA");
	}

	@Bean
	public TransactionProxyFactory transactionProxyFactory() {
		return new TransactionProxyFactory();
	}
	
	@Bean(initMethod="init")
	@Scope("prototype")
	public TransactionProxy transactionProxy() {
		return new TransactionProxy();
	}
}
