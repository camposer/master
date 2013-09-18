package com.indra.formacion.hibernate.dao;

import org.springframework.stereotype.Component;

import com.indra.formacion.hibernate.model.Libro;

@Component
public class LibroDao extends BaseDao<Libro, Integer> implements ILibroDao {
	public LibroDao() {
	}

	public LibroDao(boolean autoCommit) {
		super(autoCommit);
	}

}
