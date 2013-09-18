package com.indra.formacion.hibernate.service;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;

import com.indra.formacion.hibernate.dao.ILibreriaDao;
import com.indra.formacion.hibernate.exception.CustomException;
import com.indra.formacion.hibernate.model.Libreria;

public class LibreriaServiceImpl implements ILibreriaService {
	@Autowired
	private ILibreriaDao libreriaDao;

	@Override
	public List<Libreria> obtenerLibrerias() throws CustomException {
		try {
			return libreriaDao.obtenerTodos();
		} catch (PersistenceException e) {
			System.err.println("Error obteniendo las librerías");
			e.printStackTrace();
			
			throw new CustomException(e.getMessage());
		}
	}

	public ILibreriaDao getLibreriaDao() {
		return libreriaDao;
	}

	public void setLibreriaDao(ILibreriaDao libreriaDao) {
		this.libreriaDao = libreriaDao;
	}

	
}
