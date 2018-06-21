package com.bridgelabz.structuraldesignpattern;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class JDBCPreparedStatementA {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//load the driver
			Driver ref=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(ref);
			//Get DB connection via driver
			String dbUrl="jdbc:mysql://localhost:3306/JDBC_Bridgelabz?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			//Issue SQL Query
			Scanner sc=new Scanner(System.in);
			String query="insert into student_info values"
					+ "(?,?,?,?,?)";
			System.out.println("Enter the Values");
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,sc.nextInt());
			pstmt.setString(2,sc.next());
			pstmt.setString(3,sc.next());
			pstmt.setString(4,sc.next());
			pstmt.setLong(5,sc.nextLong());
			pstmt.executeUpdate();
			String query1="select * from student_info";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query1);
			while(rs.next()) {
				int regNum=rs.getInt("regNo");
				String fName=rs.getString("FirstName");
				String lName=rs.getString("LastName");
				String email=rs.getString("email");
				String mobNo=rs.getString("mobileNum");
				
				System.out.println("=======================================");
				System.out.println("Registration Number :"+regNum);
				System.out.println("Student First Name  :"+fName);
				System.out.println("Student First Name  :"+lName);
				System.out.println("Student  Email ID   :"+email);
				System.out.println("Student Mobile Num  :"+mobNo);
				System.out.println("=======================================");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
