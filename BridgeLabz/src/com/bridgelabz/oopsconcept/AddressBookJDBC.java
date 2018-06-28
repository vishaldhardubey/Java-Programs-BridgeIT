package com.bridgelabz.oopsconcept;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.utility.Utility;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class AddressBookJDBC implements AddressBookDataStorage {
	
	@SuppressWarnings("rawtypes")
	ArrayList list=new ArrayList<>();
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList read() {
		System.out.println("Enter the Name to Display Address Book");
		String name = Utility.scanString();
		DataSource ds = null;
		ds = getMySQLDataSource();
		Connection con = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			con = ds.getConnection();
			String queryCreateTable = "select * from "+name+"";
			statement = con.createStatement();
			resultSet = statement.executeQuery(queryCreateTable);
			while (resultSet.next()) {
				String fullname = resultSet.getString("Name");
				list.add(fullname);
				
				long mobile = resultSet.getLong("Mobile_Number");
				list.add(mobile);
				
				String city = resultSet.getString("City");
				list.add(city);
				
				String state = resultSet.getString("State");
				list.add(state);
				
				String zip = resultSet.getString("Zip");
				list.add(zip);
				
				System.out.println("===============================================");
				System.out.println("Registration Number :" + fullname);
				System.out.println("Student First Name  :" + mobile);
				System.out.println("Student First Name  :" + city);
				System.out.println("Student Email ID   :" + state);
				System.out.println("Student Mobile Num  :" + zip);
				System.out.println("===============================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

		@Override
		public void doSave(JSONArray jsonArray) {
			List<A_PersonDetails> list=new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
			//add element from jsonarray to list
			list.add((A_PersonDetails) jsonArray.get(i));
			}
				for (int i = 0; i < list.size(); i++) {
				String name=list.get(i).getPersonName();
				long mobile=list.get(i).getMobileNumber();
				String city=list.get(i).getCity();
				String state=list.get(i).getState();
				int zip=list.get(i).getZIP();
				//add data from list to table
				System.out.println("Enter the Address Book where you want to store the Address");
				String tableName=Utility.scanString();
				DataSource ds=null;
				ds=getMySQLDataSource();
				Connection con=null;
				Statement stmt=null;
				try {
					con=ds.getConnection();
					String query="insert into "+tableName+" values('"+name+"','"+mobile+"','"+city+"','"+state+"','"+zip+"')";
					stmt=con.createStatement();
					stmt.executeUpdate(query);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		public boolean createNewAddressBook() {
			System.out.println("Enter the Name to create new Address Book");
			String name = Utility.scanString();
			DataSource ds = null;
			ds = getMySQLDataSource();
			Connection con = null;
			PreparedStatement preStatement = null;
			try {
				con = ds.getConnection();
				System.out.println("Enter the Address Book Name");
				String addressBookName = Utility.scanString();
				System.out.println("Enter the Person Name");
				String name1 = Utility.scanString();
				System.out.println("Enter the Mobile Number");
				int mobile = Utility.scanInt();
				System.out.println("Enter the City");
				String city = Utility.scanString();
				System.out.println("Enter the State");
				String state = Utility.scanString();
				System.out.println("Enter the ZIP Code");
				int zipCode = Utility.scanInt();
	
				String queryCreateTable = "create table " + addressBookName + " (Name varchar(50)"
						+ ", Mobile_Number bigint(10), City varchar(20),State varchar(20),ZipCode bigint(7))";
	
				String query = "insert into "+addressBookName+" values (?,?,?,?,?)";
				preStatement = con.prepareStatement(query);
				preStatement.setString(1, name1);
				preStatement.setInt(2, mobile);
				preStatement.setString(3, city);
				preStatement.setString(4, state);
				preStatement.setInt(5, zipCode);
				preStatement.executeUpdate();	
			return true;
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}

	public static DataSource getMySQLDataSource() {
		Properties props = new Properties();
		FileInputStream fis = null;
		MysqlDataSource mysqlDS = null;
		try {
			fis = new FileInputStream("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/Properties.properties");
			props.load(fis);
			mysqlDS = new MysqlDataSource();
			mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
			mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
			mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mysqlDS;
	}

}
