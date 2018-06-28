package com.bridgelabz.spring;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehical{

	@Override
	public Vehical speed() {
		System.out.println("Car : 120kmph");
		return null;
	}

	@Override
	public Vehical brand() {
		System.out.println("Car Brand : Benz");
		return null;
	}

}
