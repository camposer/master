package com.indra.formacion.hibernate.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class LibroServiceFactory implements ApplicationContextAware {
	private ApplicationContext context;
	
	public static ILibroService createLibroService() {
		return new LibroServiceImpl();
	}

	/*
	public ILibroService createLibroService() {
		return context.getBean("libroService", ILibroService.class);
	}
	*/

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
		
	}
}
