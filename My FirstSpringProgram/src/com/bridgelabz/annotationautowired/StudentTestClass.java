package com.bridgelabz.annotationautowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTestClass {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("autowired.xml");
		Student std=(Student)context.getBean("student");
		std.join();
	}
}
