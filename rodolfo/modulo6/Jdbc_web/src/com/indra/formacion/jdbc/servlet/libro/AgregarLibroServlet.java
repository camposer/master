package com.indra.formacion.jdbc.servlet.libro;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indra.formacion.jdbc.exception.CustomException;
import com.indra.formacion.jdbc.model.Libreria;
import com.indra.formacion.jdbc.model.Libro;
import com.indra.formacion.jdbc.model.Ofrece;
import com.indra.formacion.jdbc.service.ILibroService;

/**
 * Servlet implementation class AgregarLibroServlet
 */
@WebServlet("/libro/Agregar")
public class AgregarLibroServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarLibroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		ILibroService libroService = getApplicationContext().getBean("libroService", ILibroService.class);
		try {
			libroService.agregarLibro(libro);
		} catch (CustomException e) {
			System.err.println("Error al agregar un libro");
			e.printStackTrace();
		}
		
		response.sendRedirect("Principal");
	}

}
