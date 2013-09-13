package com.indra.formacion.jdbc.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.indra.formacion.jdbc.dao.ILibreriaDao;
import com.indra.formacion.jdbc.dao.LibreriaDao;
import com.indra.formacion.jdbc.exception.CustomException;
import com.indra.formacion.jdbc.model.Libreria;

public class LibreriaServiceImpl implements ILibreriaService {
	@Autowired
	private ILibreriaDao libreriaDao;

	@Override
	public List<Libreria> obtenerLibrerias() throws CustomException {
		try {
			return libreriaDao.obtenerTodos();
		} catch (SQLException e) {
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
