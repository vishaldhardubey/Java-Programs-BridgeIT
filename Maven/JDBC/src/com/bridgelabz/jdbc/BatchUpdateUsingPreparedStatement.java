package com.bridgelabz.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchUpdateUsingPreparedStatement {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst1 = null;
		
		String insert1 = "insert into student_info values(?,?,?,?,?)";
		String update = "update student_info set lastName = ? where regNo=?";
		String delete = "delete from student_info where regNo=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_Bridgelabz?user=root&password=root");
			pst = con.prepareStatement(insert1);
			pst.setInt(1, 8);
			pst.setString(2, "Saurav");
			pst.setString(3, "Manchanda");
			pst.setInt(4, "saurav@gmail.com");
			pst.setInt(5,987238991);
			pst.addBatch();
			pst.executeBatch();
			System.out.println("data inserted successfully");
			pst1 = con.prepareStatement(insert1);
			pst1.setInt(1, 9);
			pst1.setString(2, "Mamta");
			pst1.setString(3, "Banarji");
			pst1.setInt(4, "mamta19@gmail.com");
			pst1.setInt(5,7398491029);
			pst1.addBatch();
			pst1.executeBatch();
			System.out.println("data inserted successfully");
			
			pst1 = con.prepareStatement(update);
			pst1.setString(1, "Kukreja");
			pst1.setInt(2, 9);
			pst1.addBatch();
			pst1.executeBatch();
			System.out.println("updated successfully");
			
			pst = con.prepareStatement(delete);
			pst.setInt(1, 9);
			pst1.addBatch();
			pst1.executeBatch();
			System.out.println("Deleted successfully");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Data allready exist");
		} finally {
			if (pst != null || pst1 != null || con != null) {
				try {
					pst.close();
					pst1.close();
					con.close();
				} catch (SQLException e) {
					System.out.println("Costluy resourses not closed properly");
				}
			}
		}
	}
}
