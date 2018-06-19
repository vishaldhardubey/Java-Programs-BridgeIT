/**
 * Purpose: Find out the elapsed time using stop watch.
 *
 *  @author  Vishal Dhar Dubey
 *  @version 1.0
 *  @since   16-05-2018
 */
package com.bridgelabz.FunctionalPrograms;

import com.bridgelabz.utility.Utility;

/**
 * @author administrator
 * Purpose: Find out the elapsed time using stop watch.
 */
public class StopWatch {
	public static void main(String[] args) {
		System.out.println("Enter 1 to start stopwatch and 0 to stop");
		int choice=Utility.scanInt();
		Utility.findElapsedTime(choice);
	}
}
