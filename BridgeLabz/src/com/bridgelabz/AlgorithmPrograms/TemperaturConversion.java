package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.utility.Utility;
/**
 * Purpose: Conversion of temperature into *C to Fahrenheit and vice-versa.
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :16-05-2018
 */
public class TemperaturConversion {
	public static void main(String[] args) {
		System.out.println("Enter the temperature");
		double temperature=Utility.scanDouble();
		System.out.println("Choose 1 to convert temp to Fahrenheit and 2 for temp to degree Celsius");
		int choice=Utility.scanInt();
		Utility.tempToCel(temperature,choice);
	}
}
