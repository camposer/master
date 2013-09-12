package com.emarket.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImprimirContextoServlet
 */
@WebServlet(
		value="/ImprimirContexto", 
		initParams={ @WebInitParam(name="texto", description="Tetxo de configuración para esta clase de prueba", value="Configuración")}
		)
public class ImprimirContextoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImprimirContextoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		pw.write("<html>");
		pw.write("<head/>");
		pw.write("<body>");
		pw.write("Variable de servletConfig: " + getServletConfig().getInitParameter("texto") + "<br/>");
		pw.write("Variable de servletContext: " + getServletContext().getAttribute("texto") + "<br/>");
		pw.write("Variable de session: " + request.getSession().getAttribute("texto") + "<br/>");
		pw.write("Variable de request: " + request.getAttribute("texto") + "<br/>");
		pw.write("<a href='BorrarContextos'>Borrar contextos</a>");
		pw.write("</body>");
		pw.write("</html>");
		pw.flush();
	}

}
