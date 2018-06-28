package com.bridgelabz.spring;

import org.springframework.stereotype.Component;

@Component
public class Airoplane implements Vehical{

	@Override
	public Vehical speed() {
		System.out.println("Airoplane : 500kmph");
		return null;
	}

	@Override
	public Vehical brand() {
		System.out.println("Aeroplane : SpiceJet");
		return null;
	}

}
