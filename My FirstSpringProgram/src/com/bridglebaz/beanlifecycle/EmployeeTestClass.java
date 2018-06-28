package com.bridglebaz.beanlifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeTestClass {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("NewFile.xml");
		System.out.println(context.getBean("emp2", Employee.class));
		ClassPathXmlApplicationContext ctx=(ClassPathXmlApplicationContext) context;
		ctx.close();
	}
}
