package com.bridgelabz.creationaldesignpattern;

public class EagerInitialization {
	private static final EagerInitialization instance=new EagerInitialization();
	private EagerInitialization() {
		System.out.println("Single Object has been created");
	}
	public static EagerInitialization getInstance() {
		return instance;
	}
	public static void main(String[] args) {
		EagerInitialization ref1=EagerInitialization.getInstance();
		EagerInitialization ref2=EagerInitialization.getInstance();
		System.out.println(ref1.hashCode());
		System.out.println(ref2.hashCode());
	}
}
