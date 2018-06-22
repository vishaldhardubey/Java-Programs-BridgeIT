package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdateUsingStatement {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String insert1 = "insert into student_info values(11,'Yuga','Paranjape','yuga1995@gmail.com',9837482221)";
		String insert2 = "insert into student_info values(12,'Sweta','Nayakaa','sweta1996@gmail.com',8734891827)";
		String insert3 = "insert into student_info values(13,'Vishal','Dubey','vishal1994@gmail.com',8738912015)";
		String insert4 = "insert into student_info values(14,'Bijaya','EXTC','Bijya2018@gmail.com',9873472017)";
		String update = "update student_info set lastName = 'Pandit' where regNo=13";
		String delete = "delete from student_info where regNo=13";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_Info?user=root&password=root");
			stmt = con.createStatement();
			stmt.addBatch(insert1);
			stmt.addBatch(insert2);
			stmt.addBatch(insert3);
			stmt.addBatch(insert4);
			stmt.addBatch(update);
			stmt.addBatch(delete);
			int[] array = stmt.executeBatch();
			System.out.println(" Operations are done : " + array.length);

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Data allready exist");
		} finally {
			if (stmt != null || con != null) {
				try {
					stmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}