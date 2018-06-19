package com.bridgelabz.structuraldesignpattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class JDBCPreparedStatement {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//load the driver
			Driver ref=new Driver();
			DriverManager.registerDriver(ref);
			// get the connection via driver
			String dbUrl="jdbc:mysql://localhost:3306/JDBC_Bridgelabz?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			//Issue the Sql Query
			String query="select * from student_info"
					+ " where regNo=?";
			pstmt=con.prepareStatement(query);
			Scanner sc=new Scanner(System.in);
			int regNo=sc.nextInt();
			pstmt.setInt(1, regNo);
			rs=pstmt.executeQuery();
			//Process the resultset returned by the Sql Queries
			if(rs.next()) {
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
			else {
				System.err.println("Registration Number not found");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
			if(rs!=null) {
				rs.close();
			}
			if(con!=null) {
				con.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
