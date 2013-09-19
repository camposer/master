package com.emarket.controller;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emarket.exception.CustomException;
import com.emarket.model.Libreria;
import com.emarket.model.Libro;
import com.emarket.service.ILibroService;
import com.emarket.service.LibroServiceFactory;

@Controller
@RequestMapping("/libro/*")
public class LibroController {
	@Autowired
	LibroServiceFactory libroServiceFactory;
	
	@RequestMapping("agregar")
	public String agregar(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8"); // Opción corta
		
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String sprecio = request.getParameter("precio");
		Float precio = Float.parseFloat(sprecio);
		String slibreriaIds[] = request.getParameterValues("libreriaId");

		Libro libro = new Libro(titulo, autor, precio);
		List<Libreria> librerias = new LinkedList<Libreria>();
		if (slibreriaIds != null) for (String slibreriaId : slibreriaIds) {
			Libreria libreria = new Libreria();
			libreria.setId(Integer.parseInt(slibreriaId));
			librerias.add(libreria);
		}
		libro.setLibrerias(librerias);
		
		try {
			libroServiceFactory.createLibroService().agregarLibro(libro);
		} catch (CustomException e) {
			String error = "Ha ocurrido una excepción obteniendo los libros";
			System.err.println(error);
			e.printStackTrace();
		}

		return "redirect:main.em";
	}
	
	@RequestMapping("eliminar")
	public String eliminar(HttpServletRequest request) {
		String sid = request.getParameter("id");
		Integer id = Integer.parseInt(sid);

		// TODO: Algunas cosas
		try {
			libroServiceFactory.createLibroService().eliminarLibro(id);
		} catch (CustomException e) {
			String error = "Ha ocurrido una excepción removiendo los libros";
			System.err.println(error);
			e.printStackTrace();
		}
		
		
		return "redirect:main.em";
	}
	
	@RequestMapping("main")
	public String main(HttpServletRequest request) {
		// TODO: Voy con este!
		try {
			request.setAttribute("librerias", libroServiceFactory.createLibroService().obtenerLibrerias());
		} catch (CustomException e) {
			String error = "Ha ocurrido una excepción obteniendo los libros";
			System.err.println(error);
			e.printStackTrace();

		}
		
		return "/libro/main.jsp";
	}

	@RequestMapping("modificar")
	public String modificar(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8"); // Opción corta
		// TODO: Aquí un par de cosas también
		String sid = request.getParameter("id");
		Integer id = Integer.parseInt(sid);
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String sprecio = request.getParameter("precio");
		Float precio = Float.parseFloat(sprecio);
		String slibreriaId = request.getParameter("libreriaId");
		Integer libreriaId = Integer.parseInt(slibreriaId);
		
		Libreria libr = new Libreria();
		libr.setId(libreriaId);
		Libro libro = new Libro(titulo, autor, precio);
		
		// TODO: Modificar aquí, faltan las librerías
		libro.setId(id);
		try {
			libroServiceFactory.createLibroService().modificarLibro(libro);
		} catch (CustomException e) {
			String error = "Ha ocurrido una excepción modificando los libros";
			System.err.println(error);
			e.printStackTrace();
		}

		
		return "redirect:main.em";
	}

	@RequestMapping("mostrar")
	public String mostrar(HttpServletRequest request) {
		String sid = request.getParameter("id"); // Viene de la petición (request)
		Integer id = Integer.parseInt(sid);
		
		// TODO: Necesito modificarlo con el main
		String uri = "/libro/mostrarLibro.jsp";
		try {
			ILibroService libroService = libroServiceFactory.createLibroService();
			request.setAttribute("libro", libroService.obtenerLibro(id));
			request.setAttribute("librerias", libroService.obtenerLibrerias());
		} catch (CustomException e) {
			String error = "Ha ocurrido un error obteniendo el libro con id = " + id;
			System.err.println(error);
			e.printStackTrace();
			
			uri = "/libro/error.jsp";
		}
		
		return uri;
	}

	@RequestMapping("listar")
	public String listar(HttpServletRequest request) {
		String uri = "/libro/mostrarLibros.jsp";
		try {
			request.setAttribute("libros", libroServiceFactory.createLibroService().obtenerLibros());
		} catch (CustomException e) {
			String error = "Ha ocurrido una excepción obteniendo los libros";
			System.err.println(error);
			e.printStackTrace();

			request.setAttribute("error", error);
			uri = "/libro/error.jsp";
		}
		
		return uri;
	}

	@RequestMapping(value="listarJSON", produces="application/json")
	public @ResponseBody List<Libro> listarJSON(HttpServletRequest request) throws CustomException {
		return libroServiceFactory.createLibroService().obtenerLibros();
	}

	@RequestMapping(value="echoJSON", produces="application/json", consumes="application/json")
	public @ResponseBody Libro echoJSON(@RequestBody Libro libro) {
		return libro;
	}

}
