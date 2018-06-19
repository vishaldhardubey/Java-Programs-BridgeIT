package com.bridgelabz.datastructure;

import java.util.ArrayList;

import com.bridgelabz.utility.Utility;
/**
 *  Purpose: Checker class to check whether the given number is palindrome or not.
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :27-05-2018
 */
public class PrimeNumberAnagramTwoDArray {
	public static void prime() {
		        SinglyLinkedList[][] array = new SinglyLinkedList[100][];
		        for (int i = 0; i < 10; i++) {
		            array[i] = new SinglyLinkedList[100];
		            for (int j = 0; j < 100; j++) {
		                array[i][j] = new SinglyLinkedList();
		            }
		        }
		        for (int i = 0; i < 10; i++) {
		            for (int j = 100 * i; j < 100 * (i + 1) - 1; j++) {
		                int k = 0;
		                if (Utility.prime1(j) == true) {
		                    for (int m = j + 1; m < 100 * (i + 1); m++) {
		                        if (Utility.stringAnagram(("" + j), ("" + m)) == true) {
		                            array[i][k].add(j);
		                            k++;
		                            System.out.print( j + "," + m );
		                        }
		                    }
		                }
		            }

		            System.out.println();
		        }
	}
	public static void main(String []args) {
		prime();
	}
}
