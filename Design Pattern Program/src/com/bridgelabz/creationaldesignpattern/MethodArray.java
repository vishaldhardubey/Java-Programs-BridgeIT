package com.bridgelabz.creationaldesignpattern;

import java.lang.reflect.Method;

public class MethodArray {
	public static Method methodA() {
		System.out.println("A");
		return methodA();
	}
	public static Method method2() {
		System.out.println("2");
		return method2();
	}
	public static Method methodB() {
		System.out.println("B");
		return methodB();
	}
	public static Method method3() {
		System.out.println("3");
		return method3();
	}
	public static Method methodC() {
		System.out.println("C");
		return methodC();
	}
	public static Method method4() {
		System.out.println("4");
		return method4();
	}
	public static void main(String[] args) {
		
		
	}
}	
