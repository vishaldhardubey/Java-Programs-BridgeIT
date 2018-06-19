package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.utility.Utility;
/**
 * 	Purpose: Findout the square root of given number..
 *
 *  @author  :Vishal Dhar Dubey.
 *  @version :1.0
 *  @since   :21-05-2018
 */
public class SquareRoot {
	public static void main(String[] args) {
		System.out.println("Enter the Number to find sqrt");
		double res=Utility.sqrt(Utility.scanInt());
		System.out.println("The Square root of given number is = "+res);
	}
}
