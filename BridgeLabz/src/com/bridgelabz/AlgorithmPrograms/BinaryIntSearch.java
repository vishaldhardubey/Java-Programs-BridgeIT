/**
 * Purpose: Convert Decimal to Binary vice-versa.
 *
 *  @author  :Vishal Dhar Dubey.
 *  @version :1.0
 *  @since   :19-05-2018
 */

package com.bridgelabz.AlgorithmPrograms;

import com.bridgelabz.utility.Utility;

public class BinaryIntSearch {
	public static void main(String[] args) {
		System.out.println("Enter the size of an array");
		Integer len=Utility.scanInt();
		System.out.println("Enter the element in an array");
		Integer[] ar=new Integer[len];
		for (int i = 0; i < ar.length; i++) {
			System.out.println("Enter the value at : "+i);
			ar[i]=Utility.scanInt();
		}
		System.out.println("Enter the number you want to search");
		Integer value=Utility.scanInt();
		Utility.binaryStringSearch(ar, value);
	}
}
