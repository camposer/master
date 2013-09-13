package com.indra.formacion.hibernate.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.indra.formacion.hibernate.exception.CustomException;
import com.indra.formacion.hibernate.model.Libreria;
import com.indra.formacion.hibernate.model.Libro;
import com.indra.formacion.hibernate.model.Ofrece;
import com.indra.formacion.hibernate.service.ILibreriaService;
import com.indra.formacion.hibernate.service.ILibroService;

@Controller
@RequestMapping("/libro/*")
public class LibroController {
	@Autowired
	ILibreriaService libreriaService;
	@Autowired
	ILibroService libroService;
	
	@RequestMapping("principal")
	public String principal(HttpServletRequest request) {
		try {
			request.setAttribute("librerias", libreriaService.obtenerLibrerias());
		} catch (CustomException e) {
			System.err.println("Error obteniendo librerías");
			e.printStackTrace();
		}
		
		return "/libro/principal.jsp";
	}
	
	@RequestMapping("agregar")
	public String agregar(HttpServletRequest request) {
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String sprecio = request.getParameter("precio");
		String slibreriaId = request.getParameter("libreriaId");
		
		// TODO: Incluir validaciones...
		
		Libreria libreria = new Libreria();
		libreria.setId(Integer.parseInt(slibreriaId));
					
		Libro libro = null;
		
		Ofrece o = new Ofrece(libro, libreria, Float.parseFloat(sprecio));
		List<Ofrece> ofreces = Arrays.asList(new Ofrece[] { o });
		
		libro = new Libro(titulo, autor, Float.parseFloat(sprecio), ofreces);
		try {
			libroService.agregarLibro(libro);
		} catch (CustomException e) {
			System.err.println("Error al agregar un libro");
			e.printStackTrace();
		}
		
		return "redirect:/libro/principal.do";

	}
	
	@RequestMapping("listar")
	public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("libros", libroService.obtenerLibros());
		} catch (CustomException e) {
			System.err.println("Error trayendo los libros");
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/libro/listar.jsp").include(request, response);

	}
}
