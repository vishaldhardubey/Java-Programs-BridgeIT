package com.bridgelabz.structuraldesignpattern;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacadeDesignMysql{
	public static Connection mySqlDBConnection() {
		Connection con=null;
		try {
			//load the driver.
			Driver dref=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dref);
			//get the DB connection via driver.
			String dbUrl="jdbc:mysql://localhost:3306/JDBC_Bridgelabz?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			FacadeDesignMysql helperSql=new FacadeDesignMysql();
			helperSql.generateMySqlPDFReport("student_info", con);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public void generateMySqlPDFReport(String tableName, Connection con) {
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		try {
			//Issue the Sql Query
			String query="select * from "+tableName+";";
			pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int regNum=rs.getInt("regNo");
				String fName=rs.getString("FirstName");
				String lName=rs.getString("LastName");
				String email=rs.getString("email");
				String mobNo=rs.getString("mobileNum");
				
				System.out.println("===============================================");
				System.out.println("Registration Number :"+regNum);
				System.out.println("Student First Name  :"+fName);
				System.out.println("Student First Name  :"+lName);
				System.out.println("Student  Email ID   :"+email);
				System.out.println("Student Mobile Num  :"+mobNo);
				System.out.println("===============================================");
			}
		}
		catch(SQLException e) {
			
		}
	}
}