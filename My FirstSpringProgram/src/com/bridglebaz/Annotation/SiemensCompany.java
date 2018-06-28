package com.bridglebaz.Annotation;

public class SiemensCompany {
	private Company company;
	public SiemensCompany(Company company) {
		this.company = company;
	}
	public void reception() {
		company.functional();
		System.out.println("At reception");
	}
}
