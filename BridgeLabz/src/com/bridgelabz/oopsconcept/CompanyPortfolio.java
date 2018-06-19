package com.bridgelabz.oopsconcept;

import java.util.ArrayList;

public class CompanyPortfolio {
	private ArrayList<CustomerInformation> customerArray=new ArrayList();

	public ArrayList<CustomerInformation> getCustomerArray() {
		return customerArray;
	}

	public void setCustomerArray(ArrayList<CustomerInformation> customerArray) {
		this.customerArray = customerArray;
	}
}
