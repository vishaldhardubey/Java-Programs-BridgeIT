package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.utility.Utility;
/**
 * Purpose: Determines the prime number between 1-1000.
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :16-05-2018
 */
public class PrimeNumber {
	public static void main(String[] args) {
		System.out.println("Enter the Largest Num till which you want to get prime number");
		int largestNum=Utility.scanInt();
		for (int i = 2; i < largestNum; i++) {
		boolean res=Utility.prime1(i);
		if(res==true) {
			System.out.println(i);
		}
		}
	}
}
