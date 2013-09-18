package com.indra.formacion.hibernate.dao;

import org.springframework.stereotype.Component;

import com.indra.formacion.hibernate.model.Ofrece;

@Component
public class OfreceDao extends BaseDao<Ofrece, Integer> implements IOfreceDao {
	public OfreceDao() {
	}

	public OfreceDao(boolean autoCommit) {
		super(autoCommit);
	}

}
