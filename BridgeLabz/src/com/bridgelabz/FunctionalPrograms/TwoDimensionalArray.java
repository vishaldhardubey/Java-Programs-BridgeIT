package com.bridgelabz.FunctionalPrograms;
import com.bridgelabz.utility.Utility;
/**
 * Purpose: Print the 2 Dimensional Array.
 *
 *  @author  Vishal Dhar Dubey
 *  @version 1.0
 *  @since   16-05-2018
 */

public class TwoDimensionalArray {

	public static void main(String[] args) {
		//Giving the UserInput for rows and columns.
		System.out.println("Enter the number 1 for integer, 2 for double and 3 for boolean");
		int choice=Utility.scanInt();
		Utility.twoDimensionArray(choice);
	}

}
