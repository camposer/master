package com.emarket.dao;

import javax.persistence.EntityManagerFactory;

import com.emarket.model.Ofrece;

public class OfreceDao extends BaseDao<Ofrece, Integer> implements IOfreceDao {
	public OfreceDao(EntityManagerFactory entityManagerFactory) {
		super(entityManagerFactory);
	}
	
	public OfreceDao(EntityManagerFactory entityManagerFactory, boolean autoCommit) {
		super(entityManagerFactory, autoCommit);
	}

}
