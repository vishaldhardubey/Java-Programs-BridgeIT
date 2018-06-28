package com.bridglebaz.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EngineerTestBean {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("NewFile.xml");
		Engineer engineer=context.getBean("engineer", Engineer.class);
		System.out.println(engineer);
	}
}