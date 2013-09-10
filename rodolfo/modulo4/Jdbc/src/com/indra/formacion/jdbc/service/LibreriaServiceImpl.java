package com.indra.formacion.jdbc.service;

import java.sql.SQLException;
import java.util.List;

import com.indra.formacion.jdbc.dao.ILibreriaDao;
import com.indra.formacion.jdbc.dao.LibreriaDao;
import com.indra.formacion.jdbc.exception.CustomException;
import com.indra.formacion.jdbc.model.Libreria;

class LibreriaServiceImpl implements ILibreriaService {
	private ILibreriaDao libreriaDao;

	@Override
	public List<Libreria> obtenerLibrerias() throws CustomException {
		libreriaDao = new LibreriaDao();
		
		try {
			return libreriaDao.obtenerTodos();
		} catch (SQLException e) {
			System.err.println("Error obteniendo las librerías");
			e.printStackTrace();
			
			throw new CustomException(e.getMessage());
		}
	}

}
