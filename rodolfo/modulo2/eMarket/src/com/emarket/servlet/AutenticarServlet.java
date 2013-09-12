package com.emarket.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InicioServlet
 */
@WebServlet("/Autenticar")
public class AutenticarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		
		String mensaje = "El usuario es válido";
		
		if (!usuario.equals(clave))
			mensaje = "El usuario no es válido";
		
		request.setAttribute("mensaje", mensaje);
		
		getServletContext().getRequestDispatcher("/Home").forward(request, response);
	}

}
