package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.utility.Utility;
/**
 * Purpose: Sort a given string array using Bubble Sort.
 *
 *  @author  :Vishal Dhar Dubey.
 *  @version :1.0
 *  @since   :21-05-2018
 */
public class BubbleSortString {
	public static void main(String[] args) {
		System.out.println("Enter the size");
		int len=Utility.scanInt();
		String []array=new String[len];
		System.out.println("Enter the value according to the number of size");
		for (int i = 0; i < array.length; i++) {
			array[i]=Utility.scanString();
		}
		String [] arr=Utility.bubbleSort(array);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
