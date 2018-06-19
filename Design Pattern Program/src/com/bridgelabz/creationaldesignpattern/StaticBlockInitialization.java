package com.bridgelabz.creationaldesignpattern;

public class StaticBlockInitialization {
	private static final StaticBlockInitialization instance;
	private StaticBlockInitialization() {
		System.out.println("Single Object has been created");
	}
	static {
		try {
			instance=new StaticBlockInitialization();
		}
		catch(Exception e) {
			throw new RuntimeException("Runtime exception occured during instantiation");
		}
	}
	public static StaticBlockInitialization getInstance() {
		return instance;
	}
}

