package com.indra.formacion.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.indra.formacion.jdbc.dao.ILibroDao;
import com.indra.formacion.jdbc.dao.IOfreceDao;
import com.indra.formacion.jdbc.dao.LibroDao;
import com.indra.formacion.jdbc.dao.OfreceDao;
import com.indra.formacion.jdbc.service.ILibroService;
import com.indra.formacion.jdbc.service.LibroServiceFactory;
import com.indra.formacion.jdbc.service.LibroServiceImpl;

@Configuration
public class Config {
	/**
	 * 1. El nombre del método es el id del bean
	 * 2. El tipo de retorno es el tipo del bean (referencia) que será utilizada por el cliente
	 * 3. El retorno (clase concreta) de la función es equivalente a la propiedad class del bean 
	 * 4. Por defecto el scope es singleton, debo especificar lo contrario sino quiero que sea así
	 * 5. Debe colocarse la anotación Bean para que Spring reconozca que está ante uno
	 * @return ILibroDao
	 */
	@Bean
	@Scope("prototype")
	public ILibroDao libroDao() {
		return new LibroDao();
	}
	
	@Bean
	@Scope("prototype")
	public IOfreceDao ofreceDao() {
		return new OfreceDao();
	}
	
	@Bean
	@Scope("prototype")
	public ILibroService libroService() {
		return new LibroServiceImpl();
	}
	
	@Bean
	public LibroServiceFactory libroServiceFactory() {
		return new LibroServiceFactory();
	}
}
