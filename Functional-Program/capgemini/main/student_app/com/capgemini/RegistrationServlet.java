package com.capgemini;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("IN database");
		String name=req.getParameter("name");
		System.out.println(name);
		String phn=req.getParameter("contact");
		System.out.println(phn);
		String email=req.getParameter("email");
		System.out.println(email);
		String password=req.getParameter("password");
		System.out.println(password);
		Connection con=null;
		PreparedStatement pstmt=null;
		String query="insert into studentInfo(Name,Mobile_Number,email,password) values (?,?,?,?)";
		System.out.println(query);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:3306/Student_Info?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, phn);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.executeUpdate();
			System.out.println("Data Updated Successfully");
			resp.sendRedirect("Successfull.jsp");
		}
		catch(Exception e) {
			System.out.println("Invalid Credentials");
		}
	}
}
