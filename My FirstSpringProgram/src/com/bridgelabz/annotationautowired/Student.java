package com.bridgelabz.annotationautowired;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
	private String name;
	private int sId;
	private String college;
	private StudentAutoWired studentauto;
	
	public String getName() {
		return name;
	}
	@Autowired
	public void setName(String name) {
		this.name = name;
	}
	public StudentAutoWired getStudentauto() {
		return studentauto;
	}
	@Autowired
	public void setStudentauto(StudentAutoWired studentauto) {
		this.studentauto = studentauto;
	}
	public int getsId() {
		return sId;
	}
	@Autowired
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}
	public void join() {
		studentauto.student();
	}
}
