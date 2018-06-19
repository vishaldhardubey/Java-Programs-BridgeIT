package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.utility.Utility;
/**
 * Purpose: Sort the given numbers using Merge Sort.
 *
 *  @author  :Vishal Dhar Dubey.
 *  @version :1.0
 *  @since   :21-05-2018
 */
public class MergeSort {
	public static void main(String[] args) {
		System.out.println("Enter the size of array");
		Integer len=Utility.scanInt();
		Integer []ar=new Integer[len];
		for (int i = 0; i < ar.length; i++) {
			System.out.println("Enter the values : "+i);
			ar[i]=Utility.scanInt();
		}
		Integer firstIndex=0;
		Integer lastINdex=ar.length-1;
		Integer []arr=Utility.mergeSort(ar,firstIndex,lastINdex);
		System.out.println("The Sorted Array is Given Below");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
