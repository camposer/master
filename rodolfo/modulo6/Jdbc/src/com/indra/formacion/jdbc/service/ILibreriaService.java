package com.indra.formacion.jdbc.service;

import java.util.List;

import com.indra.formacion.jdbc.exception.CustomException;
import com.indra.formacion.jdbc.model.Libreria;

public interface ILibreriaService {
	public List<Libreria> obtenerLibrerias() throws CustomException;
}
