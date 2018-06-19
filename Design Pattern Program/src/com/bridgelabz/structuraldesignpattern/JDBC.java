package com.bridgelabz.structuraldesignpattern;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			// Loading the "Driver"
			Driver driverRef=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driverRef);
			// Get the database connection via Driver
			String dbUrl="jdbc:mysql://localhost:3306/JDBC_Bridgelabz?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			
			//Issue the Sql Query via ""Connection"
			String query="select * from student_info";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			//Process the results returned by "SQL Queries"
			while(rs.next()) {
				int regNum=rs.getInt("regNo");
				String fName=rs.getString("firstName");
				String lName=rs.getString("LastName");
				String email=rs.getString("email");
				long mobileNum=rs.getLong("mobileNum");
				
				System.out.println("Registration Number :"+regNum);
				System.out.println("Student First Name  :"+fName);
				System.out.println("Student First Name  :"+lName);
				System.out.println("Student  Email ID   :"+email);
				System.out.println("Student Mobile Num  :"+mobileNum);
				System.out.println("=======================================");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				rs.close();
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
