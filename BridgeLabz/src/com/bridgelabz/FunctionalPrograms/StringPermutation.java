/**
 * Purpose: Find out the total number of permutation of a given string.
 *
 *  @author  Vishal Dhar Dubey
 *  @version 1.0
 *  @since   16-05-2018
 */
package com.bridgelabz.FunctionalPrograms;

import com.bridgelabz.utility.Utility;

/**
 * @author administrator
 *  Purpose: Find out the total number of permutation of a given string
 */
public class StringPermutation {
	public static void main(String[] args) {
	        System.out.println("Enter the string: ");
	        String inputString = Utility.scanString();
	        Utility.permutation(inputString);
	}
}
