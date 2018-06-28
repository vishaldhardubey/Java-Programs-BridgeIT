package com.bridgelabz.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Vehicalfeatures.xml");
		Vehical obj=context.getBean("car", Car.class);
		obj.speed();
		obj.brand();
	}

}
