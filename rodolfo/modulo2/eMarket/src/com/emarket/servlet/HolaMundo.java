package com.emarket.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaMundo
 */
@WebServlet({"/HolaMundo", "/holaMundo" } )
public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaMundo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.write("<html>\n");
		pw.write("<head/>\n");
		pw.write("<body onload='kfdsjkj'>\n");
		pw.write("Hola mundo!\n");
		pw.write("<form action='ProcesarFormulario' method='GET'>\n");
		pw.write("<input type='text' name='texto'/>\n");
		pw.write("<input type='submit' name='clic' value='clic'/>\n");
		pw.write("</form>\n");
		pw.write("</body>\n");
		pw.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
