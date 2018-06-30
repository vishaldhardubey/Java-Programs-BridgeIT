package com.capgemini;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FetchDataServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("vishal");
		HttpSession session=req.getSession();
		
		String name=session.getAttribute("username").toString();
		String password=session.getAttribute("password").toString();
		System.out.println(name);
		System.out.println(password);
		
		String dbUrl="jdbc:mysql://localhost:3306/Student_Info?user=root&password=root";
		//Connection with the database
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet set=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(dbUrl);
			String query1 = "select * from studentInfo where email=? ";
			pstmt=con.prepareStatement(query1);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			set=pstmt.executeQuery();
			while(set.next()) {
				req.setAttribute("serialNum", set.getInt("serialNumber"));
				req.setAttribute("name", set.getInt("Name"));
				req.setAttribute("mobileNum", set.getInt("Mobile_Number"));
				req.setAttribute("emailId", set.getInt("email"));
				
				System.out.println(set.getInt("serialNumber"));
				System.out.println(set.getInt("Name"));
				RequestDispatcher dispatch=req.getRequestDispatcher("DisplayData.jsp");
				dispatch.forward(req, resp);
			}
		}
		catch(Exception e) {
			
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}