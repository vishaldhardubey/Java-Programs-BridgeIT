package com.bridgelabz.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
	public static void main(String[] args) {
		//Object construction
		/*Employee eref=new Employee();
			eref.setAddress("kjshadja");
			eref.setEid(1);
			eref.setEname("Vishal");
			eref.setGender('M');
			System.out.println("Employee Details : "+eref);*/
			
		//Using Spring
			Resource resource=new ClassPathResource("NewFile.xml");
			BeanFactory factory=new XmlBeanFactory(resource);
			Employee e1=factory.getBean("emp", Employee.class);
			Employee e2=(Employee) factory.getBean("emp1");
			System.out.println(e1);
			System.out.println(e2);
			

			ApplicationContext applicationContext=new ClassPathXmlApplicationContext("NewFile.xml");
			Employee employee=applicationContext.getBean("emp1", Employee.class);
			System.out.println(employee);
	}
}
