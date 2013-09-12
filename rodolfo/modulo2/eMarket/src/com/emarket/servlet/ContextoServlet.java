package com.emarket.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextoServlet
 */
@WebServlet("/Contexto")
public class ContextoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String texto = request.getParameter("texto");
		
		request.setAttribute("texto", texto); // => Ámbito de petición
		request.getSession().setAttribute("texto", texto); // => Ámbito de sesión
		getServletContext().setAttribute("texto", texto); // => Ámbito de contexto del servlet
		
		getServletContext().getRequestDispatcher("/ImprimirContexto").forward(request, response);
		
	}

}
