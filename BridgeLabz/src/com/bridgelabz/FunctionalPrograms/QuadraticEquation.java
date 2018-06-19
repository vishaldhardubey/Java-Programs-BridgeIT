/**
 * Purpose: Find out the Roots of given Quadratic Equations.
 *
 *  @author  Vishal Dhar Dubey
 *  @version 1.0
 *  @since   16-05-2018
 */

package com.bridgelabz.FunctionalPrograms;
import com.bridgelabz.utility.Utility;

/**
 * @author administrator
 * Purpose: Find out the Roots of given Quadratic Equations.
 */
public class QuadraticEquation {

	public static void main(String[] args) {
		System.out.println("Enter the value of A ");
		int num1=Utility.scanInt();
		System.out.println("Enter the value of B ");
		int num2=Utility.scanInt();
		System.out.println("Enter the value of C ");
		int num3=Utility.scanInt();
		Utility.findRoots(num1, num2, num3);
	}
}