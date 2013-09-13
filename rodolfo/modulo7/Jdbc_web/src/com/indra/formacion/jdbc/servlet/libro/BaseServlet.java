package com.indra.formacion.jdbc.servlet.libro;

import javax.servlet.http.HttpServlet;

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
