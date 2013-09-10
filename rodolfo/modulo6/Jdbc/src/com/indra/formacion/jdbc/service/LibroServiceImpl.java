package com.indra.formacion.jdbc.service;

import java.sql.SQLException;
import java.util.List;

import com.indra.formacion.jdbc.dao.BaseDao;
import com.indra.formacion.jdbc.dao.ILibroDao;
import com.indra.formacion.jdbc.dao.IOfreceDao;
import com.indra.formacion.jdbc.dao.LibroDao;
import com.indra.formacion.jdbc.dao.OfreceDao;
import com.indra.formacion.jdbc.dao.TransactionProxy;
import com.indra.formacion.jdbc.exception.CustomException;
import com.indra.formacion.jdbc.model.Libro;
import com.indra.formacion.jdbc.model.Ofrece;

class LibroServiceImpl implements ILibroService {
	private ILibroDao libroDao;
	private IOfreceDao ofreceDao;
	
	@Override
	public void agregarLibro(Libro libro) throws CustomException {
		libroDao = new LibroDao();
		ofreceDao = new OfreceDao();

		TransactionProxy proxy = null;
		try {
			proxy = new TransactionProxy(); // begin transaction
			proxy.join((BaseDao) libroDao);
			proxy.join((BaseDao) ofreceDao);

			libroDao.agregar(libro);
			
			if (libro.getOfreces() != null && libro.getOfreces().size() > 0) {
				for (Ofrece o : libro.getOfreces()) {
					o.setLibro(libro);
					
					ofreceDao.agregar(o);
				}
			}
			
			proxy.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (proxy != null) {
				try {
					proxy.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			throw new CustomException(e.getMessage());
		} finally {
			if (proxy != null) {
				try {
					proxy.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<Libro> obtenerLibros() throws CustomException {
		libroDao = new LibroDao();

		// TODO: Agregar más código de lógica de datos...
		// FIXME: Esto devuelve un error cuando X
		try {
			return libroDao.obtenerTodos();
		} catch (SQLException e) {
			e.printStackTrace();
			
			throw new CustomException(e.getMessage());
		}
	}

}
