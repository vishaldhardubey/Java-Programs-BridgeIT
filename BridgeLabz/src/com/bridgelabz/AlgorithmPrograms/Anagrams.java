package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.utility.Utility;
/**
 * Purpose: Determines whether the given string is anagram of other or not!!!.
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :19-05-2018
 */
public class Anagrams {
	public static void main(String[] args) {
		System.out.println("Enter the 1st Name");
		String name1=Utility.scanSentence();
		System.out.println("Enter the 2nd Name");
		String name2=Utility.scanSentence();
		if(Utility.stringAnagram(name1,name2)==true) {
			System.out.println("The given string is palindrome");
		}
		else {
			System.out.println("The given string is not a palindrome");
		}
	}
}
