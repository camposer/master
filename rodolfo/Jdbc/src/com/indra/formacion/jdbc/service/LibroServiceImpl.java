package com.indra.formacion.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.indra.formacion.jdbc.dao.ILibroDao;
import com.indra.formacion.jdbc.dao.IOfreceDao;
import com.indra.formacion.jdbc.dao.LibroDao;
import com.indra.formacion.jdbc.dao.OfreceDao;
import com.indra.formacion.jdbc.exception.CustomException;
import com.indra.formacion.jdbc.model.Libro;
import com.indra.formacion.jdbc.model.Ofrece;

class LibroServiceImpl implements ILibroService {
	private ILibroDao libroDao;
	private IOfreceDao ofreceDao;
	
	public LibroServiceImpl() {
		libroDao = new LibroDao();
		ofreceDao = new OfreceDao();
	}

	@Override
	public void agregarLibro(Libro libro) throws CustomException {
		// TODO: Agregar más código de lógica de datos...
		Connection con = null;
		try {
			libroDao.setAutoCommit(false);
			con = libroDao.abrirConexion();
			Integer libroId = libroDao.agregar(libro);
			
			// TODO: Pedir la conexión y pasarla al ofreceDao...
			ofreceDao.setAutoCommit(false);
			ofreceDao.setConexion(con);
			
			if (libro.getOfreces() != null && libro.getOfreces().size() > 0) {
				for (Ofrece o : libro.getOfreces()) {
					Libro l = new Libro();
					l.setId(libroId);
					o.setLibro(l);
					
					ofreceDao.agregar(o);
				}
			}
			
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (con != null)
				con.rollback();
			
			throw new CustomException(e.getMessage());
		} finally {
			if (con != null)
				con.close();
		}
	}

	@Override
	public List<Libro> obtenerLibros() throws CustomException {
		// TODO: Agregar más código de lógica de datos...
		try {
			return libroDao.obtenerTodos();
		} catch (SQLException e) {
			e.printStackTrace();
			
			throw new CustomException(e.getMessage());
		}
	}

}
