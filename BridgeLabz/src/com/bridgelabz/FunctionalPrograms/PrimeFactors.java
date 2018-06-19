/**
 * Purpose: Determines Prime Factors of a given Number.
 *
 *  @author  Vishal Dhar Dubey
 *  @version 1.0
 *  @since   16-05-2018
 */

package com.bridgelabz.FunctionalPrograms;
import com.bridgelabz.utility.Utility;

/**
 * @author administrator
 * Purpose: Determines Prime Factors of a given Number.
 */
public class PrimeFactors {
	public static void main(String[] args){
		System.out.println("Enter the number");
		int num=Utility.scanInt();
		for (int i = 2; i < num; i++) {
		if(Utility.prime1(i)==true) {
			System.out.println(i);
		}	
		}
	}
}

