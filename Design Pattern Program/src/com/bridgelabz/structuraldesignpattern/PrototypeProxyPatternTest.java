package com.bridgelabz.structuraldesignpattern;

public class PrototypeProxyPatternTest {
	public static void main(String[] args){
			PrototypeCommandExecutor executor = new PrototypeCommandProxy("Vishal", "vishal1994");
			try {
				executor.runCommand("ls -ltr");
				executor.runCommand(" rm -rf abc.pdf");
			} catch (Exception e) {
				System.out.println("Exception Message::"+e.getMessage());
			}
	}
}
