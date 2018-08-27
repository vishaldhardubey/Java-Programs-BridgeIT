package myfirstjdbc;

import java.sql.Connection;
import java.sql.Statement;

import com.jdbc.utility.JdbcUtility;



public class JdbcTransactions {
	 JdbcUtility obj= new JdbcUtility();

	 static Connection con=null;
	 static Connection con1=null;
	 public static void main(String[] args) {
		 new JdbcUtility();
		 con=JdbcUtility.loadAndConnect();
		 Statement stmt=null;
		 try {
			 String query="insert into student values(1,'sameer','9876543211')";
			 stmt=con.createStatement();
			 stmt.executeUpdate(query);
			 
			 con.setAutoCommit(false);  
			 
			 query="insert into student values(2,'saurabh','9876543211')";
			 stmt.executeUpdate(query);
			 
			 query="insert into student values(3,'saket','9876543211')";
			 stmt.executeUpdate(query);
			 
				System.out.println();
				System.out.println("commit/rollback");  
				String answer=JdbcUtility.getString();  
				if(answer.equalsIgnoreCase("commit")){  
				con.commit();  
				}  
				if(answer.equalsIgnoreCase("rollback")){  
				con.rollback();  
				}
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 try {
				 if(stmt!=null) {
					 stmt.close();
				 }
				 if(con!=null) {
				 con.close();}
			 }catch(Exception e){
				 
			 }
		 }
	}
}

