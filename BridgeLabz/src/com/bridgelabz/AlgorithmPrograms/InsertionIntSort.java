package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.utility.Utility;
/**
 * Purpose: Sort a given string array using Insertion Sort.
 *
 *  @author  :Vishal Dhar Dubey.
 *  @version :1.0
 *  @since   :21-05-2018
 */
public class InsertionIntSort {
		public static void main(String[] args) {
			System.out.println("Enter the length of an array.");
			Integer len=Utility.scanInt();
			Integer a[]=new Integer[len];
	    	for (int i = 0; i < a.length; i++) {
	    		System.out.println("Enter the element at position : "+i);
				a[i]=Utility.scanInt();
			}
	    	Integer [] res=Utility.insertionStringSort(a);
	    	for (int i = 0; i < res.length; i++) {
				System.out.println(res[i]);
			}
		}
}
