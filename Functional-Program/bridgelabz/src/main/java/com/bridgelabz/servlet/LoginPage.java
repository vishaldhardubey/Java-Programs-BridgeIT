package com.bridgelabz.servlet;


import java.io.IOException;
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

/**
 * @author Vishal
 *
 */
public class LoginPage extends HttpServlet {
	
	String FilePath="/home/administrator/Funtional-Program/Functional-Program/bridgelabz/src/main/java/com/bridgelabz/servlet/DBProperties.properties";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet set=null;
		String regNum = req.getParameter("username");
		String password = req.getParameter("password");
		int regNo = Integer.parseInt(regNum);
		String query = "select * from student_otherInfo where regNo="+regNo+"+ and password = +'"+password+"'";
		System.out.println("second table" + query);
		// connection create
		try {
			Driver dref=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dref);
			
			String dbUrl="jdbc:mysql://localhost:3306/Student_Info?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			
			pst = con.prepareStatement(query);
			set = pst.executeQuery();
			System.out.println("res1" + set);
			if (set.next()) {
				System.out.println("getting value");
				RequestDispatcher dispature = req.getRequestDispatcher("Result.html");
				dispature.forward(req, resp);
			} else {
				System.out.println("Not Valid user");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
}
