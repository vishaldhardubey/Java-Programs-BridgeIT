package com.bridgelabs;

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

/**
 * @author Vishal
 *
 */
public class LoginServlet extends HttpServlet {
	
	//String FilePath="/home/administrator/Funtional-Program/Functional-Program/bridgelabz/src/main/java/com/bridgelabz/servlet/DBProperties.properties";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet set=null;
		String email = req.getParameter("username");
		String password = req.getParameter("passkey");
		PrintWriter out=resp.getWriter();
		// connection create
		try {
			Driver dref=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dref);
			
			String dbUrl="jdbc:mysql://localhost:3306/Student_Info?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			
			String query1 = "select * from students_otherInfo where email=? and password =?";
			System.out.println(query1);
			pst = con.prepareStatement(query1);
			
			pst.setString(1, email);
			pst.setString(2, password);
			
			set = pst.executeQuery();
			
			System.out.println("res1" + set);
			
			if (set.next()) {
				System.out.println("getting value");
				
				HttpSession session=req.getSession();
				session.setAttribute("username", email);
				session.setAttribute("password", password);
				
				resp.sendRedirect("");
			} else {
				System.out.println("Invalid Credentials");
				resp.sendRedirect("Login.jsp");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
}
