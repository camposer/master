package com.indra.formacion.jdbc.service;

public abstract class LibreriaServiceFactory {
	public static ILibreriaService createLibreriaService() {
		return new LibreriaServiceImpl();
	}
}
