package com.emarket.servlet.producto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emarket.util.ProductoUtil;

/**
 * Servlet implementation class MostrarServlet
 */
@WebServlet("/producto/Mostrar")
public class MostrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		
		if (sid != null) {
			Integer id = Integer.parseInt(sid);
			request.setAttribute("producto", ProductoUtil.obtener(id));
		}
		
		getServletContext().getRequestDispatcher("/producto/mostrar.jsp").forward(request, response);

	}

}
