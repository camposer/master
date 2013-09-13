package com.indra.formacion.hibernate.dao;

import com.indra.formacion.hibernate.model.Libro;

public class LibroDao extends BaseDao<Libro, Integer> implements ILibroDao {
	public LibroDao() {
	}

	public LibroDao(boolean autoCommit) {
		super(autoCommit);
	}

}
