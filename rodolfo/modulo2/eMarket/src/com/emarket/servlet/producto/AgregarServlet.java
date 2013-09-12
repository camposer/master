package com.emarket.servlet.producto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emarket.to.Producto;
import com.emarket.util.ProductoUtil;

/**
 * Servlet implementation class AgregarServlet
 */
@WebServlet("/producto/Agregar")
public class AgregarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = (String) request.getAttribute("nombre"); 
		Float precio = Float.parseFloat((String) request.getAttribute("precio"));
		
		Producto p = new Producto(nombre, precio);
		ProductoUtil.agregar(p);
		
		response.sendRedirect("Principal");
	}

}
