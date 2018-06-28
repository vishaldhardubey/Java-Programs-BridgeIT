package com.bridgelabz.factory;


import com.bridgelabz.serviceImplementation.AddressBookJDBC;
import com.bridgelabz.serviceImplementation.AddressBookJSON;
import com.bridgelabz.services.AddressBookMediator;

public class AddressBookFactory {

	public static AddressBookMediator getInstance(int option) {
		if(option==1)return new AddressBookJDBC();
		else if(option==2)return new AddressBookJSON();
		else return null;
	}
}

