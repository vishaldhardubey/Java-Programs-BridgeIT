/**
 * Purpose: Determines whether the given year is a Lear Year or Not.
 *
 *  @author  Vishal Dhar Dubey
 *  @version 1.0
 *  @since   16-05-2018
 */
package com.bridgelabz.FunctionalPrograms;
import java.util.Scanner;

import com.bridgelabz.utility.Utility;

/**
 * @author administrator
 * Purpose: Determines whether the given year is a Lear Year or Not.
 */
public class LeapYear {
	public static void main(String[] args) {
		System.out.println("Enter the year you want to check!!");
		int year=Utility.scanInt();
		System.out.println(Utility.isLeapYear(year));
	}

}
