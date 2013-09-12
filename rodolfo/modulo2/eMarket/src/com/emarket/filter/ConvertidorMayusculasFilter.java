package com.emarket.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ConvertidorMayusculasFilter
 */
@WebFilter("/producto/*")
public class ConvertidorMayusculasFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ConvertidorMayusculasFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Enumeration<String> nombres = request.getParameterNames();

		while(nombres.hasMoreElements()) {
			String nombreParam = nombres.nextElement();
			String param = request.getParameter(nombreParam);
			
			request.setAttribute(nombreParam, param.toUpperCase());
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
