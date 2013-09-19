package com.indra.formacion.hibernate.service;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.indra.formacion.hibernate.dao.ILibroDao;
import com.indra.formacion.hibernate.dao.IOfreceDao;
import com.indra.formacion.hibernate.exception.CustomException;
import com.indra.formacion.hibernate.model.Libro;
import com.indra.formacion.hibernate.model.Ofrece;

public class LibroServiceImpl implements ILibroService {
	@Autowired
	private ILibroDao libroDao;
	@Autowired
	private IOfreceDao ofreceDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void agregarLibro(Libro libro) throws CustomException {
		try {
			libroDao.agregar(libro);
			
			if (libro.getOfreces() != null && libro.getOfreces().size() > 0) {
				for (Ofrece o : libro.getOfreces()) {
					o.setLibro(libro); // OJO: Si este objeto no es persistente esto falla!
					
					ofreceDao.agregar(o);
				}
			}
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage());
		} 
	}

	@Override
	public List<Libro> obtenerLibros() throws CustomException {
		// TODO: Agregar más código de lógica de datos...
		// FIXME: Esto devuelve un error cuando X
		try {
			return libroDao.obtenerTodos();
		} catch (PersistenceException e) {
			e.printStackTrace();
			
			throw new CustomException(e.getMessage());
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	public void setLibroDao(ILibroDao libroDao) {
		this.libroDao = libroDao;
	}

	public void setOfreceDao(IOfreceDao ofreceDao) {
		this.ofreceDao = ofreceDao;
	}

	public ILibroDao getLibroDao() {
		return libroDao;
	}

	public IOfreceDao getOfreceDao() {
		return ofreceDao;
	}

}
