package com.emarket.servlet.carrito;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emarket.to.Producto;

/**
 * Servlet implementation class EliminarCarritoServlet
 */
@WebServlet("/EliminarCarrito")
public class EliminarCarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarCarritoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		Integer id = Integer.parseInt(sid);
		Object oproductos = request.getSession().getAttribute("productos");
		
		if (oproductos != null) {
			List<Producto> productos = (List<Producto>) oproductos;
			
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i).getId() == id) {
					productos.remove(i);
					break;
				}
			}
			
			request.getSession().setAttribute("productos", productos);

			response.sendRedirect("MostrarCarrito");

		} else {
			response.sendRedirect("Principal");
			
		}
		
	}

}
