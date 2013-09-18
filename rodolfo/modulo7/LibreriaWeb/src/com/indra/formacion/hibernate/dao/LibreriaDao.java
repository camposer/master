package com.indra.formacion.hibernate.dao;

import org.springframework.stereotype.Component;

import com.indra.formacion.hibernate.model.Libreria;

@Component
public class LibreriaDao extends BaseDao<Libreria, Integer> implements ILibreriaDao {
	public LibreriaDao() {
	}

	public LibreriaDao(boolean autoCommit) {
		super(autoCommit);
	}

}
