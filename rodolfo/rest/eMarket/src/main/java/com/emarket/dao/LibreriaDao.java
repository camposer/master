package com.emarket.dao;

import javax.persistence.EntityManagerFactory;

import com.emarket.model.Libreria;

public class LibreriaDao extends BaseDao<Libreria, Integer> implements ILibreriaDao {
	public LibreriaDao(EntityManagerFactory entityManagerFactory) {
		super(entityManagerFactory);
	}
	
	public LibreriaDao(EntityManagerFactory entityManagerFactory, boolean autoCommit) {
		super(entityManagerFactory, autoCommit);
	}

}
