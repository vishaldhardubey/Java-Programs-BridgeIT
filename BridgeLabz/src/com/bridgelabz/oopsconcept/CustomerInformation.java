package com.bridgelabz.oopsconcept;

import java.util.ArrayList;

public class CustomerInformation {
	
	private String name;
	private long mobNum;
	private long accountNum;
	private customerShareDetails companyshare;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobNum() {
		return mobNum;
	}
	public void setMobNum(long mobNum) {
		this.mobNum = mobNum;
	}
	public long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(long accountNum) {
		this.accountNum = accountNum;
	}
	public customerShareDetails getCompanyshare() {
		return companyshare;
	}
	public void setCompanyshare(customerShareDetails custumshare) {
		this.companyshare = custumshare;
	}
}
