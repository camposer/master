package com.emarket.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emarket.dao.ILibreriaDao;
import com.emarket.dao.ILibroDao;
import com.emarket.dao.IOfreceDao;
import com.emarket.exception.CustomException;
import com.emarket.model.Libreria;
import com.emarket.model.Libro;
import com.emarket.model.Ofrece;

public class LibroService implements ILibroService {
	@Autowired ILibroDao libroDao;
	@Autowired ILibreriaDao libreriaDao;
	@Autowired IOfreceDao ofreceDao;
	
	@Override
	@Transactional
	public void agregarLibro(Libro libro) throws CustomException {
		
		try {
			
			libroDao.agregar(libro);
			// IMPORTANTISIMO: libro es un objeto persistente!!
			
			if (libro.getLibrerias() != null) for (Libreria libreriaTransient : libro.getLibrerias()) {
				Libreria libreria = libreriaDao.obtener(libreriaTransient.getId());
				
				libro.setId(800); // Causando el error!!
				Ofrece ofrece = new Ofrece();
				ofrece.setLibro(libro); // Aquí es persistente porque ya fue persistido arriba!!
				ofrece.setLibreria(libreria);
				
				ofreceDao.agregar(ofrece);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public void modificarLibro(Libro libro) throws CustomException {
		try {
			Libro l = libroDao.obtener(libro.getId());
			l.setTitulo(libro.getTitulo());
			l.setPrecio(libro.getPrecio());
			l.setAutor(libro.getAutor());
			libroDao.modificar(l);
			
			// TODO: Agregar resto de la implementación (a futuro y probablemente!)
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public void eliminarLibro(Integer id) throws CustomException {
		try {
			libroDao.remover(id);
			
			// TODO: Agregar resto de la implementación (a futuro y probablemente!)
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public List<Libro> obtenerLibros() throws CustomException {
		try {
			return libroDao.obtenerTodos();
			
			// TODO: Agregar resto de la implementación (a futuro y probablemente!)
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public Libro obtenerLibro(Integer id) throws CustomException {
		try {
			return libroDao.obtener(id);
			
			// TODO: Agregar resto de la implementación (a futuro y probablemente!)
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public List<Libreria> obtenerLibrerias() throws CustomException {
		try {
			return libreriaDao.obtenerTodos();
			
			// TODO: Agregar resto de la implementación (a futuro y probablemente!)
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage());
		}
	}

}
