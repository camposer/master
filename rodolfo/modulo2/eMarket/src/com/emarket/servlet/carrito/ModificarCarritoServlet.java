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
 * Servlet implementation class ModificarCarritoServlet
 */
@WebServlet("/ModificarCarrito")
public class ModificarCarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarCarritoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] productoIds = request.getParameterValues("productoId");
		Object oproductos = request.getSession().getAttribute("productos");
		List<Producto> productos = null;
		
		if (oproductos != null) {
			productos = (List<Producto>) oproductos;
			
			for (String sproductoId : productoIds) {
				Integer productoId = Integer.parseInt(sproductoId);
				
				for (int i = 0; i < productos.size(); i++) {
					if (productos.get(i).getId() == productoId) {
						Integer cantidad = Integer.parseInt(request.getParameter("cantidad" + productoId));
						
						if (cantidad > 0)  // Actualizo la cantidad del producto en el array en sesión
							productos.get(i).setCantidad(cantidad);
						else // Remuevo el producto del array en sesión
							productos.remove(i);
					}
				}
				
			}

			request.getSession().setAttribute("productos", productos);
		} 
		
		response.sendRedirect("MostrarCarrito");
	}

}
