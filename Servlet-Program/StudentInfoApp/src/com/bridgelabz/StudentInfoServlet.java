package com.bridgelabz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentInfoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		Date dateRef=new Date();
		String currentDate=dateRef.toString();
		response.setContentType("text/html");
		String htmlRes="<html>"
				+ "<body>"
				+ "<h1>"
				+ "Current Date & Time is : "
				+ "<font color=\"red\">"
				+ currentDate
				+"</font>"
				+"</h1>"
				+ "</body>"
				+ "</html>";
		
		PrintWriter out=response.getWriter();
		out.print(htmlRes);
	}
}
