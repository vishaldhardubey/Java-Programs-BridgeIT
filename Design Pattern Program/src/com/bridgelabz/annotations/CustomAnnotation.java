package com.bridgelabz.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface Capgemini{
	String Employee();
	int numberOfEmployee();
}

@Capgemini(Employee="Vishal",numberOfEmployee=12)
class Employees{
	String city;
	int number;
	public Employees(String city, int number) {
		this.city = city;
		this.number = number;
	}
}

public class CustomAnnotation {
	public static void main(String[] args) {
		Employees emp=new Employees("Mukesh", 4);
		
		Class c=emp.getClass();
		Annotation an=c.getAnnotation(Capgemini.class);
		Capgemini cap=(Capgemini)an;
		System.out.println(cap.Employee());
		System.out.println(cap.numberOfEmployee());
	}
}
