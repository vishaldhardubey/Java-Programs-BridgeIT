package com.bridgelabz.oopsconcept;

import com.bridgelabz.utility.Utility;

public class AddressBookFactory {
	public static AddressBookDataStorage getObject() {
		System.out.println("Select the database");
		System.out.println("1 - For MySql Database");
		System.out.println("2 - For JSON File");
		int key = Utility.scanInt();
		if (key < 0) {
			System.err.println("Please Enter 1 or 2");
		} else {
			switch (key) {
			case 1:
				System.out.println("Returning Object of Database");
				AddressBookJDBC jdbc = new AddressBookJDBC();
				return jdbc;
			case 2:
				System.out.println("Returning Object of JSON File");
				AddressBookJSON json = new AddressBookJSON();
				return json;

			default:
				System.out.println("Invalid Input! Please Try Again.");
				getObject();
				break;
			}
		}
		return null;
	}
}
