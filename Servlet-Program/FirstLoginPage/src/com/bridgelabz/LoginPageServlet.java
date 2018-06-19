package com.bridgelabz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPageServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();

		String userName=req.getParameter("user");
		String password=req.getParameter("passKey");
		
		out.println("User Name : "+userName);
		out.println("Password : "+password);
		/*if(LoginValidate.validate(userName,password)) {
			RequestDispatcher rd=req.getRequestDispatcher("loginPage.html");
			rd.forward(req, resp);
		}*/
	}
}
