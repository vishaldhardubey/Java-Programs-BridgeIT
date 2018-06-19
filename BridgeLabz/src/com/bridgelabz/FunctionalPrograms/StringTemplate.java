package com.bridgelabz.FunctionalPrograms;
import com.bridgelabz.utility.Utility;
/**
 * Purpose: Replace the String Templates by given string value.
 *
 *  @author  Vishal Dhar Dubey
 *  @version 1.0
 *  @since   16-05-2018
 */
public class StringTemplate {
	
	public static void main(String[] args) 
	{
		System.out.println("Enter the name  you wanted to replace");
		String toReplace=Utility.scanString();
		String res=Utility.replaceString(toReplace);
		System.out.println(res);
	}
}
