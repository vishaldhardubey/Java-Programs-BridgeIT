package com.bridgelabz;

public class LoginValidate{

	public static boolean validate(String userName, String password) {
		String userName1="Vishal";
		String password1="vishal@1994";
		if(userName.equals(userName1)&&password.equals(password1)) {
			return true;
		}
		return false;
	}
	public static boolean validateDB() {
		Connection con=null;
		Statement stmt=null;
		
		try {
			//register the driver.
			Driver driver=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			//get the connection via driver.
			String dbUrl="jdbc:mysql://localhost:3306/JDBC_Bridgelabz?user=root&password=root";
			DriverManager.getConnection(dbUrl);
			//Sql Query 
			String query="";
			stmt = con.createStatement();
			stmt.executeQuery(query);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
