package com.bridgelabz.annotationrequired;

import org.springframework.beans.factory.annotation.Required;

public class Student {
	private String name;
	private int sId;
	public String getName() {
		return name;
	}
	@Required
	public void setName(String name) {
		this.name = name;
	}
	public int getsId() {
		return sId;
	}
	@Required
	public void setsId(int sId) {
		this.sId = sId;
	}
	
}
