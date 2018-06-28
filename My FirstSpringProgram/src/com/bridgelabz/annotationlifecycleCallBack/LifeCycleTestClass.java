package com.bridgelabz.annotationlifecycleCallBack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleTestClass {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(LifeCycleConfig.class);
		System.out.println(context.getBean(LifeCycle.class));
	}
}
