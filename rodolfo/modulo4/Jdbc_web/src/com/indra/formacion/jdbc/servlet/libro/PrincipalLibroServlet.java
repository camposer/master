package com.indra.formacion.jdbc.servlet.libro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indra.formacion.jdbc.exception.CustomException;
import com.indra.formacion.jdbc.service.ILibreriaService;
import com.indra.formacion.jdbc.service.LibreriaServiceFactory;

/**
 * Servlet implementation class PrincipalServlet
 */
@WebServlet("/libro/Principal")
public class PrincipalLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PrincipalLibroServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ILibreriaService libreriaService = LibreriaServiceFactory.createLibreriaService();
		
		try {
			request.setAttribute("librerias", libreriaService.obtenerLibrerias());
		} catch (CustomException e) {
			System.err.println("Error obteniendo librerías");
			e.printStackTrace();
		}
		
		getServletContext().getRequestDispatcher("/libro/principal.jsp").forward(request, response);
	}

}
