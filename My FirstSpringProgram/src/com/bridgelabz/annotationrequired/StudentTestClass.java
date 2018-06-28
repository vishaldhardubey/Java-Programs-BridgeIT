package com.bridgelabz.annotationrequired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTestClass {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Vehicalfeatures.xml");
		Student std=(Student)context.getBean("student");
		System.out.println(std.getsId());
		System.out.println(std.getName());
	}
}
