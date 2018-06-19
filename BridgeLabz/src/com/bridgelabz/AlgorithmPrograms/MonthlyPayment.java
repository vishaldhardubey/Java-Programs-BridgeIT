package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.utility.Utility;
/**
 * Purpose: Findout the monthly payment of an employee.
 *  @author  :Vishal Dhar Dubey.
 *  @version :1.0
 *  @since   :21-05-2018
 */
public class MonthlyPayment {
	
	public static void main(String[] args) {
		System.out.println("Enter the Principal amount, Year and rate");
		double res= Utility.payment(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
		System.out.println(res);
	}

}
