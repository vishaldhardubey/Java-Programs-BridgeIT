package com.bridgelabz.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@interface Y{
	String name() default "Yuga";
	int size();
}

@Y(size=12)
class ABC{
	String value;
	int sizxe;
	public void value() {
		int value=13;
		System.out.println("XYZ");
	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface H{
	String city1();
}

class ABF{
	@H(city1="Lucknow")
	public void value1() {
		System.out.println("FFF");
	}
}

public class AnnotationExp {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		ABF abf=new ABF();	
		ABC a=new ABC();
		Annotation an=a.getClass().getAnnotation(Y.class);
		
		Y y=(Y)an;
		System.out.println(y.name());
		System.out.println(y.size());
		
		Method m=abf.getClass().getMethod("value1");
		Annotation a1=m.getAnnotation(H.class);
		H as=(H)a1;
		System.out.println(as.city1());
	}
}
