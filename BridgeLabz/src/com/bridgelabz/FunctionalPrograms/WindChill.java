package com.bridgelabz.FunctionalPrograms;
import com.bridgelabz.utility.Utility;
/**
 * Purpose: Print the effective windchill temperature based on temperature and wind speed.
 *
 *  @author  Vishal Dhar Dubey
 *  @version 1.0
 *  @since   16-05-2018
 */
public class WindChill {

	public static void main(String[] args) {
		System.out.println("Enter the temperature below 50");
		double temperature=Utility.scanDouble();
		System.out.println("Enter the wind speed between 3 to 120");
		double windSpeed = Utility.scanDouble();
		Utility.calculateWindChill(temperature,windSpeed);
	}

}
