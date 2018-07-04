package com.studentapp;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RegisterFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String name=request.getParameter("email");
		if(FetchDataServlet.validateExistingData(name)==true) {
			System.out.println("Always true");
			chain.doFilter(request, response);	
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("Unsuccessfull.jsp");
			rd.forward(request,response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
