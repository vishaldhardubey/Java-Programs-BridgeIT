/**
 * Purpose: Print the sum of N harmonic number series.
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
 * Purpose: Print the sum of N harmonic number series.
 */
public class HarmonicNo {
	public static void main(String[] args) {
		System.out.println("Enter Number");
		int N=Utility.scanInt();
		if(N>0){
			System.out.println(Utility.harmonic(N));
		}
		else {
			System.out.println("Invalid Number");
		}
		
	}

}
