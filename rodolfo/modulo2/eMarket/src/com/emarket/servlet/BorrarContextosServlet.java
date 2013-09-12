package com.emarket.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BorrarContextosServlet
 */
@WebServlet("/BorrarContextos")
public class BorrarContextosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarContextosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * No borramos los atributos de request porque desaparece tras dar una respuesta
		 * No borramos los atributos de servletConfig porque son declarativos! 
		 */
		
		request.getSession().removeAttribute("texto"); // => Removiendo el atributo específico!
		request.getSession().invalidate(); // => Invalido toda la sesión! (borra todos los atributos)

		getServletContext().removeAttribute("texto"); // => Removiendo el atributos específico!
	
		//getServletContext().getRequestDispatcher("/ImprimirContexto").forward(request, response);
		response.sendRedirect("ImprimirContexto");
	}

}
