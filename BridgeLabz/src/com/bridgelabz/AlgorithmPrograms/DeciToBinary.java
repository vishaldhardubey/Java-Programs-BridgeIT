package com.bridgelabz.AlgorithmPrograms;

import com.bridgelabz.utility.Utility;

public class DeciToBinary {
	
	public static void main(String[] args) {
		System.out.println("Enter Integer value to convert in binary");
		int valueDec=Utility.scanInt();
		String res=Utility.toBinary(valueDec);
		System.out.println(res);
	}
}
