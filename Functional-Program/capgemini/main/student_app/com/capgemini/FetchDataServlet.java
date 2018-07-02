package com.capgemini;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FetchDataServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		System.out.println("vishal");
		HttpSession session=req.getSession();
		
		String name=session.getAttribute("username").toString();
		String password=session.getAttribute("password").toString();
		System.out.println(name);
		//out.println("<html><body><h1>"+name+"</h1></body></html>");
		System.out.println(password);
		
		String dbUrl="jdbc:mysql://localhost:3306/Student_Info?user=root&password=root";
		//Connection with the database
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet set=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(dbUrl);
			String query1 = "select * from studentInfo where email=? and password=?";
			System.out.println(query1+" *****Second Query");
			pstmt=con.prepareStatement(query1);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			set=pstmt.executeQuery();
			while(set.next()) {
				session.setAttribute("serialNum", set.getInt("serialNumber"));
				session.setAttribute("name", set.getString("Name"));
				session.setAttribute("mobileNum", set.getLong("Mobile_Number"));
				session.setAttribute("emailId", set.getString("email"));
				
				System.out.println(set.getInt("serialNumber"));
				System.out.println(set.getString("Name"));
				RequestDispatcher dispatch=req.getRequestDispatcher("DisplayData.jsp");
				dispatch.forward(req, resp);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	public static boolean validateExistingData(String email) {
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet set=null;
		// connection create
		try {
			Driver dref=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dref);
			
			String dbUrl="jdbc:mysql://localhost:3306/Student_Info?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			
			String query1 = "select * from studentInfo where email=?";
			System.out.println(query1);
			pst = con.prepareStatement(query1);
			
			pst.setString(1, email);
			
			set = pst.executeQuery();
			
			//System.out.println("res1" + set);
		
			if (set.next()) {
				System.out.println("Getting Values");
				return false;
				
			} else {
				return true;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;	
	}
}