package com.emarket.servlet.carrito;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emarket.to.Producto;
import com.emarket.util.ProductoUtil;

/**
 * Servlet implementation class AgregarCarritoServlet
 */
@WebServlet("/AgregarCarrito")
public class AgregarCarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarCarritoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] productoIds = request.getParameterValues("productoId");
		HttpSession sesion = request.getSession();
		List<Producto> productos = new LinkedList<Producto>();
		
		Object oproductos = sesion.getAttribute("productos");
		
		if (oproductos != null)
			productos = (List<Producto>) oproductos;
		
		for (String sid : productoIds) {
			Integer cantidad = Integer.parseInt(request.getParameter("cantidad" + sid));
			
			if (cantidad == 0) // Si no seleccionó cantidades del producto no se agrega al carrito
				continue;
			
			Integer id = Integer.parseInt(sid);
			boolean encontrado = false;
			
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i).getId() == id) {
					Producto p = productos.get(i); 
					p.setCantidad(cantidad + p.getCantidad());
					
					encontrado = true;
					break;
				}
			}
			
			if (!encontrado) {
				Producto p = ProductoUtil.obtener(id);
				p.setCantidad(cantidad);
				productos.add(p);
			}
				
		}
		
		sesion.setAttribute("productos", productos);
		
		response.sendRedirect("MostrarCarrito");
	}

}



