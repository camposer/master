package com.emarket.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class LibroServiceFactory implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	
	public ILibroService createLibroService() {
		return applicationContext.getBean("libroService", ILibroService.class);
	}
	
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
}
