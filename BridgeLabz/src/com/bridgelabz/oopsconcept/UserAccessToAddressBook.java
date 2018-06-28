package com.bridgelabz.oopsconcept;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class UserAccessToAddressBook {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		System.out.println("Enter your choice");
		System.out.println("1. To add the details of a person");
		System.out.println("2. To edit the details of a person");
		System.out.println("3. To delete the details of a person");
		System.out.println("4. To sort the details of a person by Name");
		System.out.println("5. To sort the details of a person by ZIP");
		System.out.println("6. To create new address book");
		System.out.println("7. To Open Existing Address Book");
		System.out.println("8. To Delete Existing Address Book");
		System.out.println("9- To open file from JDBC");
		int choice=Utility.scanInt();
		AddressBookManager addManager=new AddressBookManager();
		AddressBook add=new AddressBook();
		switch (choice) {
			case 1:
				add.doAdd();
				break;
			case 2:
				add.doEdit();
				break;
			case 3:
				add.doDelete();
				break;
			case 4:
				add.doSort();
				break;
			case 5:
				add.doSortByZIP();
				break;
			case 6:
				System.out.println("Enter the database");
				System.out.println("1- For JSON File");
				System.out.println("2- For MYsql Database");
				int key=Utility.scanInt();
				switch(key) {
				case 1:	AddressBookManager manage=new AddressBookManager();
					if(manage.createNewAddressBook()) {
						System.out.println("New Address Book Created");
					}
					else {
						System.out.println("Name Already Exists");
					}
					
					System.out.println("Enter your choice");
					System.out.println("1. To add the details of a person");
					System.out.println("2. To edit the details of a person");
					System.out.println("3. To delete the details of a person");
					System.out.println("4. To sort the details of a person by Name");
					System.out.println("5. To sort the details of a person by ZIP");
					int key1=Utility.scanInt();
					switch (key1) {
					case 1:
						add.doAdd();
						break;
					case 2:
						add.doEdit();
						break;
					case 3:
						add.doDelete();
						break;
					case 4:
						add.doSort();
						break;
					case 5:
						add.doSortByZIP();
						break;
					}
				case 2:
					AddressBookJDBC jdbc=new AddressBookJDBC();
					if(jdbc.createNewAddressBook()) {
						System.out.println("New Address Book Created");
					}
					else {
						System.out.println("Name Already Exists");
					}
					
					System.out.println("Enter your choice");
					System.out.println("1. To add the details of a person");
					System.out.println("2. To edit the details of a person");
					System.out.println("3. To delete the details of a person");
					System.out.println("4. To sort the details of a person by Name");
					System.out.println("5. To sort the details of a person by ZIP");
					int key11=Utility.scanInt();
					switch (key11) {
					case 1:
						add.doAdd();
						break;
					case 2:
						add.doEdit();
						break;
					case 3:
						add.doDelete();
						break;
					case 4:
						add.doSort();
						break;
					case 5:
						add.doSortByZIP();
						break;
					}
				}
					
			break;
			case 7:
				addManager.doOpen();
				break;
			case 8:
				addManager.doDelete();
				break;
			case 9:
				AddressBookJDBC addressBookJDBC=new AddressBookJDBC();
				addressBookJDBC.read();
				break;
			default:
				System.err.println("Invalid Input");
				break;
		}
	}
}
