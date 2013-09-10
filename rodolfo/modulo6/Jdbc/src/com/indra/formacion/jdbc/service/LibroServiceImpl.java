package com.indra.formacion.jdbc.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.indra.formacion.jdbc.dao.BaseDao;
import com.indra.formacion.jdbc.dao.ILibroDao;
import com.indra.formacion.jdbc.dao.IOfreceDao;
import com.indra.formacion.jdbc.dao.LibroDao;
import com.indra.formacion.jdbc.dao.OfreceDao;
import com.indra.formacion.jdbc.dao.TransactionProxy;
import com.indra.formacion.jdbc.exception.CustomException;
import com.indra.formacion.jdbc.model.Libro;
import com.indra.formacion.jdbc.model.Ofrece;

public class LibroServiceImpl implements ILibroService, ApplicationContextAware {
	private ILibroDao libroDao;
	private IOfreceDao ofreceDao;
	private ApplicationContext context;
	
	@Override
	public void agregarLibro(Libro libro) throws CustomException {
		libroDao = context.getBean("libroDao", ILibroDao.class);
		ofreceDao = context.getBean("libreriaDao", IOfreceDao.class);;

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
		libroDao = context.getBean("libroDao", ILibroDao.class);

		// TODO: Agregar más código de lógica de datos...
		// FIXME: Esto devuelve un error cuando X
		try {
			return libroDao.obtenerTodos();
		} catch (SQLException e) {
			e.printStackTrace();
			
			throw new CustomException(e.getMessage());
		}
	}

	public void setLibroDao(ILibroDao libroDao) {
		this.libroDao = libroDao;
	}

	public void setOfreceDao(IOfreceDao ofreceDao) {
		this.ofreceDao = ofreceDao;
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		
		this.context = context;
		
	}

	
}
