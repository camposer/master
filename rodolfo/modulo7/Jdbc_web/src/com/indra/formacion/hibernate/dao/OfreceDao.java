package com.indra.formacion.hibernate.dao;

import com.indra.formacion.hibernate.model.Ofrece;

public class OfreceDao extends BaseDao<Ofrece, Integer> implements IOfreceDao {
	public OfreceDao() {
	}

	public OfreceDao(boolean autoCommit) {
		super(autoCommit);
	}

}
