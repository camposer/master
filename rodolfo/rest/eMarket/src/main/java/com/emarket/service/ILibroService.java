package com.emarket.service;


import java.util.List;

import com.emarket.exception.CustomException;
import com.emarket.model.Libreria;
import com.emarket.model.Libro;

public interface ILibroService {
	public void agregarLibro(Libro libro) throws CustomException;
	public void modificarLibro(Libro libro) throws CustomException;
	public void eliminarLibro(Integer id) throws CustomException;
	public List<Libro> obtenerLibros() throws CustomException;
	public Libro obtenerLibro(Integer id) throws CustomException;
	public List<Libreria> obtenerLibrerias() throws CustomException;
}
