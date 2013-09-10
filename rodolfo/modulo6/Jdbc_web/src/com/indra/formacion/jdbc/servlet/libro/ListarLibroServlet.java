package com.indra.formacion.jdbc.servlet.libro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indra.formacion.jdbc.exception.CustomException;
import com.indra.formacion.jdbc.service.ILibroService;
import com.indra.formacion.jdbc.service.LibroServiceFactory;

/**
 * Servlet implementation class ListarLibroServlet
 */
@WebServlet("/libro/Listar")
public class ListarLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarLibroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ILibroService libroService = LibroServiceFactory.createLibroService();
		
		try {
			request.setAttribute("libros", libroService.obtenerLibros());
		} catch (CustomException e) {
			System.err.println("Error trayendo los libros");
			e.printStackTrace();
		}
		
		getServletContext().getRequestDispatcher("/libro/listar.jsp").include(request, response);
	}

}
