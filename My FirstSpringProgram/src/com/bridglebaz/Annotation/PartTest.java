package com.bridglebaz.Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PartTest {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(PartBConfig.class);
		context.getBean(PartA.class);
		context.getBean(PartB.class);
	}
}
