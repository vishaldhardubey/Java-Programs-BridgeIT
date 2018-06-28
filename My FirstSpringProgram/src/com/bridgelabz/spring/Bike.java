package com.bridgelabz.spring;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehical {

	@Override
	public Vehical speed() {
		System.out.println("Bike : 90kmph");
		return null;
	}

	@Override
	public Vehical brand() {
		System.out.println("Bike : Apache");
		return null;
	}

}
