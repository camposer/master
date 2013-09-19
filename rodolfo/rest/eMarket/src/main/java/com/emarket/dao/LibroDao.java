package com.emarket.dao;

import javax.persistence.EntityManagerFactory;

import com.emarket.model.Libro;

public class LibroDao extends BaseDao<Libro, Integer> implements ILibroDao {
	public LibroDao(EntityManagerFactory entityManagerFactory) {
		super(entityManagerFactory);
	}
	
	public LibroDao(EntityManagerFactory entityManagerFactory, boolean autoCommit) {
		super(entityManagerFactory, autoCommit);
	}
}
