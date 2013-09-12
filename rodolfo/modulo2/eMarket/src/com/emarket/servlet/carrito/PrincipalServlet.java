package com.emarket.servlet.carrito;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emarket.to.Producto;
import com.emarket.util.ProductoUtil;

/**
 * Servlet implementation class PrincipalServlet
 */
@WebServlet("/Principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrincipalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("productos", ProductoUtil.obtenerTodos());
		
		getServletContext().getRequestDispatcher("/carrito/principal.jsp").forward(request, response);
		
	}

}
