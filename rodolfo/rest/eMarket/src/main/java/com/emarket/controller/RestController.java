package com.emarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emarket.exception.CustomException;
import com.emarket.model.Libro;
import com.emarket.service.LibroServiceFactory;

@Controller
@RequestMapping("/rest/libros/*")
public class RestController {
	@Autowired
	LibroServiceFactory libroServiceFactory;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public @ResponseBody Boolean agregar(@RequestBody Libro libro) {
		Boolean retorno = true;
		
		try {
			libroServiceFactory.createLibroService().agregarLibro(libro);
		} catch (CustomException ce) {
			ce.printStackTrace();
			retorno = false;
		}
		
		return retorno;
		
	}

	@RequestMapping(value="/", method=RequestMethod.PUT)
	public @ResponseBody Boolean modificar(@RequestBody Libro libro) {
		Boolean retorno = true;
		
		try {
			libroServiceFactory.createLibroService().modificarLibro(libro);
		} catch (CustomException ce) {
			ce.printStackTrace();
			retorno = false;
		}
		
		return retorno;
		
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Libro> listar() {
		List<Libro> retorno = null;
		
		try {
			retorno = libroServiceFactory.createLibroService().obtenerLibros();
		} catch (CustomException ce) {
			ce.printStackTrace();
		}
		
		return retorno;
		
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody Libro obtener(@PathVariable Integer id) {
		Libro retorno = null;
		
		try {
			retorno = libroServiceFactory.createLibroService().obtenerLibro(id);
		} catch (CustomException ce) {
			ce.printStackTrace();
		}
		
		return retorno;
		
	}

}
