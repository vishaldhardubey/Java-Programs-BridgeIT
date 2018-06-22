package com.bridgelabz.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

interface Upload{
	public void data();
	public void name();
}

class Retrieve implements Upload{
	
	private int VALUE;
	private String NAME;
	
	public Retrieve(int a) {
		System.out.println("Inside Constructor");
	}
	@Override
	public void data() {
		System.out.println("Retrieving Data");	
	}

	@Override
	public void name() {
		System.out.println("Retrieving Name");
	}
}
public class ReflectionCheck {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
	//	Retrieve ret=new Retrieve(10);
		Class ref=Retrieve.class;
		System.out.println(ref.isInterface());
		System.out.println(ref.getModifiers());
		System.out.println(ref.getSimpleName());
		Method[] methods=ref.getMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i].getName());
			System.out.println(methods[i].getReturnType());
		}
		System.out.println(ref.getConstructors());
		
		Field value=ref.getDeclaredField("NAME");
		value.setAccessible(true);
		

		int mod=ref.getModifiers();
		System.out.println(mod);
		
		System.out.println(Modifier.isFinal(mod));
	}
}
