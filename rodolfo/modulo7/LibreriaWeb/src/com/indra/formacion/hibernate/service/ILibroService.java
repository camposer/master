package com.indra.formacion.hibernate.service;

import java.util.List;

import com.indra.formacion.hibernate.exception.CustomException;
import com.indra.formacion.hibernate.model.Libro;

public interface ILibroService {
	public void agregarLibro(Libro libro) throws CustomException;
	public List<Libro> obtenerLibros() throws CustomException;
}
