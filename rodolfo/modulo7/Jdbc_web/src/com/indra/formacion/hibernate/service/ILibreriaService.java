package com.indra.formacion.hibernate.service;

import java.util.List;

import com.indra.formacion.hibernate.exception.CustomException;
import com.indra.formacion.hibernate.model.Libreria;

public interface ILibreriaService {
	public List<Libreria> obtenerLibrerias() throws CustomException;
}
