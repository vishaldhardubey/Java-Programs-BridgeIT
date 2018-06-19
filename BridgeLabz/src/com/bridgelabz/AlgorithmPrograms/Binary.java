package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.utility.Utility;
/**
 * Purpose: Convert Decimal to Binary vice-versa.
 *
 *  @author  :Vishal Dhar Dubey.
 *  @version :1.0
 *  @since   :21-05-2018
 */
public class Binary {
	
	public static void main(String[] args) {
		System.out.println("Enter the number to convert in decimal");
		int number=Utility.scanInt();
		if(number >= 0) {
		int res=Utility.toDecimal(number);
		System.out.println("Decimal value of given number : "+res);
		}
		else {
			System.out.println("Please enter the positive integer");
		}
	}

}
