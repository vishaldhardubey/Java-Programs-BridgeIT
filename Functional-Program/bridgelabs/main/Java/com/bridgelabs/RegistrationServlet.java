package com.bridgelabs;
import java.io.IOException;
import java.sql.Connection;
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
		String phn=req.getParameter("mobile");
		String email=req.getParameter("email");
		String password=req.getParameter("passkey");
		Long phnNum=Long.parseLong(phn);
		
		Connection con=null;
		PreparedStatement pstmt=null;
		String query="insert into studentInfo() values (?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, name);
			pstmt.setLong(2, phnNum);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.executeUpdate();
			System.out.println("Data Updated Successfully");
		}
		catch(Exception e) {
			System.out.println("Invalid Credentials");
		}
	}
}
