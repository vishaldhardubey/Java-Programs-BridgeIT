package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.utility.Utility;
/**
 * Purpose: Find out the day of a week.
 *
 *  @author  :Vishal Dhar Dubey.
 *  @version :1.0
 *  @since   :21-05-2018
 */
public class DayOfWeek {

	public static void main(String[] args) {
		System.out.println("Give Command Line Argument for month, date and year");
		Utility.dayOfWeek(Integer.parseInt(args[0]), Integer.parseInt(args[0]), Integer.parseInt(args[0]));
	}

}
