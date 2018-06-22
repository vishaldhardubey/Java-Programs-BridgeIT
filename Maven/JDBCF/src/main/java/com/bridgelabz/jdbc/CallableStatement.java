package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
	 * @author Saurav:
	 * Class CallableStatementExample
	 */
	public class CallableStatement {
		public static void main(String[] args) {
			DataSource ds=null;
			ds= DataSourceFactory.getMySQLDataSource();
			Connection con=null;
			java.sql.CallableStatement cst=null;
			ResultSet resultSet=null;
			try {
				con=ds.getConnection();
				cst=con.prepareCall("call callstudent_info()");
				resultSet=cst.executeQuery();
				while(resultSet.next())
				{
					int id= resultSet.getInt(1);
					String fname=resultSet.getString("firstName");
					String lName=resultSet.getString("lastName");
					String email=resultSet.getString("email");
					long mobile=resultSet.getLong("mobileNum");
					System.out.println(id+" "+fname+" "+lName+" "+email+" "+mobile);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("SQL Exception has occurred");
			}
			finally {
				if(cst!=null)
				{
					try {
						cst.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con!=null)
				{
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
}
