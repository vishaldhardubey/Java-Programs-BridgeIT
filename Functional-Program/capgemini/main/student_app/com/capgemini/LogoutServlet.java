package com.capgemini;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside Logout");
		HttpSession session=req.getSession(false);  
		if(req.getParameter("logout")!=null) {
			session.invalidate();
			RequestDispatcher dispatch=req.getRequestDispatcher("HomePage.jsp");
			dispatch.forward(req, resp);
		}
    }
}