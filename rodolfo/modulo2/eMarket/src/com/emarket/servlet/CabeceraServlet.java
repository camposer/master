package com.emarket.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CabeceraServlet
 */
@WebServlet("/Cabecera")
public class CabeceraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CabeceraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		pw.write("<html>\n");
		pw.write("      <head>\n");
		pw.write("              <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
		pw.write("              <link rel=\"stylesheet\" type=\"text/css\" href=\"css/common.css\">\n");
		pw.write("              <title>Tienda de artículos electrónicos</title>\n");
		pw.write("      </head>\n");
		pw.write("      <body>\n");
		pw.write("              <h1>Tienda de artículos electrónicos</h1>\n");
		pw.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
