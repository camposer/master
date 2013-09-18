package com.indra.formacion.hibernate.service;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;

import com.indra.formacion.hibernate.dao.BaseDao;
import com.indra.formacion.hibernate.dao.ILibroDao;
import com.indra.formacion.hibernate.dao.IOfreceDao;
import com.indra.formacion.hibernate.dao.TransactionProxy;
import com.indra.formacion.hibernate.dao.TransactionProxyFactory;
import com.indra.formacion.hibernate.exception.CustomException;
import com.indra.formacion.hibernate.model.Libro;
import com.indra.formacion.hibernate.model.Ofrece;

public class LibroServiceImpl implements ILibroService {
	@Autowired
	private ILibroDao libroDao;
	@Autowired
	private IOfreceDao ofreceDao;
	@Autowired
	private TransactionProxyFactory transactionProxyFactory;
	
	@SuppressWarnings("rawtypes")
	@Override
	public void agregarLibro(Libro libro) throws CustomException {
		TransactionProxy proxy = null;
		try {
			proxy = transactionProxyFactory.createTransactionProxy();
			proxy.join((BaseDao) libroDao);
			proxy.join((BaseDao) ofreceDao);

			libroDao.agregar(libro);
			
			if (libro.getOfreces() != null && libro.getOfreces().size() > 0) {
				for (Ofrece o : libro.getOfreces()) {
					o.setLibro(libro); // OJO: Si este objeto no es persistente esto falla!
					
					ofreceDao.agregar(o);
				}
			}
			
			proxy.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			if (proxy != null) {
				try {
					proxy.rollback();
				} catch (PersistenceException e1) {
					e1.printStackTrace();
				}
			}
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

	public TransactionProxyFactory getTransactionProxyFactory() {
		return transactionProxyFactory;
	}

	public void setTransactionProxyFactory(
			TransactionProxyFactory transactionProxyFactory) {
		this.transactionProxyFactory = transactionProxyFactory;
	}

	public ILibroDao getLibroDao() {
		return libroDao;
	}

	public IOfreceDao getOfreceDao() {
		return ofreceDao;
	}

}
