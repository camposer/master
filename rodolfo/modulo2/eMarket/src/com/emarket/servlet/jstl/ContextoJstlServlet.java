package com.emarket.servlet.jstl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emarket.util.ProductoUtil;

/**
 * Servlet implementation class ContextoServlet
 */
@WebServlet("/ContextoJstl")
public class ContextoJstlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextoJstlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String texto = request.getParameter("texto");
		
		request.setAttribute("texto", "request:" + texto); // => Ámbito de petición
		request.getSession().setAttribute("texto", "session:" + texto); // => Ámbito de sesión
		getServletContext().setAttribute("texto", "application:" + texto); // => Ámbito de contexto del servlet
		
		request.setAttribute("productos", ProductoUtil.obtenerTodos());
		getServletContext().getRequestDispatcher("/imprimirContextoJstl.jsp").forward(request, response);
		
	}

}
