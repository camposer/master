package com.indra.formacion.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.indra.formacion.jdbc.ConnectionFactory;
import com.indra.formacion.jdbc.dao.ILibreriaDao;
import com.indra.formacion.jdbc.dao.ILibroDao;
import com.indra.formacion.jdbc.dao.IOfreceDao;
import com.indra.formacion.jdbc.dao.LibreriaDao;
import com.indra.formacion.jdbc.dao.LibroDao;
import com.indra.formacion.jdbc.dao.OfreceDao;
import com.indra.formacion.jdbc.dao.TransactionProxy;
import com.indra.formacion.jdbc.dao.TransactionProxyFactory;
import com.indra.formacion.jdbc.service.ILibreriaService;
import com.indra.formacion.jdbc.service.ILibroService;
import com.indra.formacion.jdbc.service.LibreriaServiceImpl;
import com.indra.formacion.jdbc.service.LibroServiceImpl;

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
	
	@Bean
	public ILibroDao libroDao() {
		LibroDao libroDao = new LibroDao();
		libroDao.setConnectionFactory(connectionFactory());
		return libroDao;
	}

	@Bean
	public IOfreceDao ofreceDao() {
		OfreceDao ofreceDao = new OfreceDao();
		ofreceDao.setConnectionFactory(connectionFactory());
		return ofreceDao;
	}

	@Bean
	public ILibreriaDao libreriaDao() {
		LibreriaDao libreriaDao = new LibreriaDao();
		libreriaDao.setConnectionFactory(connectionFactory());
		return libreriaDao;
	}

	@Bean
	public ConnectionFactory connectionFactory() {
		return new ConnectionFactory();
	}
	
	@Bean
	public TransactionProxyFactory transactionProxyFactory() {
		return new TransactionProxyFactory();
	}

	@Bean(initMethod="init") // OJO: El bean es inyectado después de creada la instancia!!
	@Scope("prototype")
	public TransactionProxy transactionProxy() {
		return new TransactionProxy();
	}

}
