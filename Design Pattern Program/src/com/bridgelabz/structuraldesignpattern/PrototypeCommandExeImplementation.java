package com.bridgelabz.structuraldesignpattern;
import java.io.IOException;

public class PrototypeCommandExeImplementation implements PrototypeCommandExecutor{
	
	@Override
	public void runCommand(String cmd) throws IOException {
		Runtime.getRuntime().exec(cmd);
		System.out.println("'" + cmd + "' command executed.");
	}
}
