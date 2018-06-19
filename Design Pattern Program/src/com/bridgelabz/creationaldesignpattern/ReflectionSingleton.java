package com.bridgelabz.creationaldesignpattern;

import java.lang.reflect.Constructor;

public class ReflectionSingleton {
	public static void main(String []args) {
		EagerInitialization instanceOne=EagerInitialization.getInstance();
		System.out.println(instanceOne.hashCode());
		EagerInitialization instanceTwo=null;
		try {
			Constructor []constructor = EagerInitialization.class.getDeclaredConstructors();
			for (Constructor constructors:constructor) {
				constructors.setAccessible(true);
				instanceTwo=(EagerInitialization)constructors.newInstance();
				System.out.println(instanceTwo.hashCode());
				break;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}