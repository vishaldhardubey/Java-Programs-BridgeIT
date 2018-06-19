package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.utility.Utility;
/**
 * Purpose: Sort Integer element using Bubble Sort.
 *
 *  @author  :Vishal Dhar Dubey.
 *  @version :1.0
 *  @since   :21-05-2018
 */
public class BubbleIntSort {
	public static void main(String[] args) {
		System.out.println("Enter the size");
		Integer len=Utility.scanInt();
		Integer []array=new Integer[len];
		System.out.println("Enter the value according to the number of size");
		for (int i = 0; i < array.length; i++) {
			array[i]=Utility.scanInt();
		}
		Integer [] arr=Utility.bubbleSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
