package com.capgemini;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String name=request.getParameter("email");
		//String passkey=request.getParameter("passkey");
		System.out.println(name);
		System.out.println("Hi");
		if(FetchDataServlet.validateExistingData(name)==false) {
			System.out.println("Always true");
			chain.doFilter(request, response);	
		}
		else {
			RequestDispatcher dispatch = request.getRequestDispatcher("PreLoginServlet");
			dispatch.forward(request, response);
			//((HttpServletResponse) response).sendRedirect("PreLoginServlet");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
