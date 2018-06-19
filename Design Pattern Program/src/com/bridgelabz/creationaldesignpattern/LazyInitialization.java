package com.bridgelabz.creationaldesignpattern;

class LazyInitializationObject {
	static LazyInitializationObject instance=null;
	private LazyInitializationObject() {
		System.out.println("Single Object has been created");
	}
	public static LazyInitializationObject getInstance() {
		if(instance==null) {
			instance=new LazyInitializationObject();
		}
		return instance;
	}
}

public class LazyInitialization {
	public static void main(String[] args) {
		LazyInitializationObject ref1=LazyInitializationObject.getInstance();
		LazyInitializationObject ref2=LazyInitializationObject.getInstance();
		System.out.println(ref1.hashCode());
		System.out.println(ref2.hashCode());
	}
}