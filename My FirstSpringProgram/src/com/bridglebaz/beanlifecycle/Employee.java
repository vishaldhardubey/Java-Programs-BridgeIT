package com.bridglebaz.beanlifecycle;

public class Employee {
	private String ename;
	private int eid;
	private double esal;
	private String edesignation;
	private Address address;
	
	public Employee() {}
	public Employee(String ename, int eid, double esal, String edesignation, Address address) {
		this.ename = ename;
		this.eid = eid;
		this.esal = esal;
		this.edesignation = edesignation;
		this.address = address;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public double getEsal() {
		return esal;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setEsal(double esal) {
		this.esal = esal;
	}
	public String getEdesignation() {
		return edesignation;
	}
	public void setEdesignation(String edesignation) {
		this.edesignation = edesignation;
	}
	@Override
	public String toString() {
		return "Employee [ename=" + ename + ", eid=" + eid + ", esal=" + esal + ", edesignation=" + edesignation
				+ ", eaddress=" + address + "]";
	}
	public void inIt() {
		System.out.println("Class has been initialized");
	}
	public void destroy() {
		System.out.println("Class has destroyed");
	}
}
