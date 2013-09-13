package com.indra.formacion.hibernate.dao;

import com.indra.formacion.hibernate.model.Libreria;

public class LibreriaDao extends BaseDao<Libreria, Integer> implements ILibreriaDao {
	public LibreriaDao() {
	}

	public LibreriaDao(boolean autoCommit) {
		super(autoCommit);
	}

}
