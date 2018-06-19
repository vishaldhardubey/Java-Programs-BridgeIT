/***
 * Purpose: Determines distinct value in an array whose sum is equals to zero.
 *
 *  @author  Vishal Dhar Dubey
 *  @version 1.0
 *  @since   16-05-2018
 */

package com.bridgelabz.FunctionalPrograms;
import com.bridgelabz.utility.*;

/**
 * @author administrator
 * Purpose: Determines distinct value in an array whose sum is equals to zero.
 */
public class SumEqualsToZero {
	
	public static void main(String[] args) {
		/*
		 * Declaring and initializing Array for getting 
		 */
		int size=Utility.scanInt();
		int []arr=new int[size];
		for (int i = 0; i < size; i++) {
			arr[i]=Utility.scanInt();
		}
		Utility.sumEqualsZero(arr);
	}
}
