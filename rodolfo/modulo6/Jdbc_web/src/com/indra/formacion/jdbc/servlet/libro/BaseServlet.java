package com.indra.formacion.jdbc.servlet.libro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class BaseServlet
 */
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	protected ApplicationContext getApplicationContext() {
		return context;
	}
	
	
}
