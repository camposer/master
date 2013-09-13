package com.indra.formacion.hibernate.service;

public abstract class LibreriaServiceFactory {
	public static ILibreriaService createLibreriaService() {
		return new LibreriaServiceImpl();
	}
}
