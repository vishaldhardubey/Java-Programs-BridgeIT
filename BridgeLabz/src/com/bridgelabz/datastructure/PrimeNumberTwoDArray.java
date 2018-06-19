package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;
/**
 *  Purpose: PrimeNumber in two Dimensional array.
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :26-05-2018
 */
public class PrimeNumberTwoDArray {
	/**
	 * Function is to find prime number and perfrom some operation and store in singlylinkedlist
	 * @return arrayList
	 */
	public static SinglyLinkedList[][] primeTwoD() {
		SinglyLinkedList [][] arrayList=new SinglyLinkedList[10][];
		SinglyLinkedList [][] res=new SinglyLinkedList [10][];
		for (int i = 0; i < 10; i++) {
			res[i]=new SinglyLinkedList[1000];
			for (int j = 0; j < 1000; j++) {
			res[i][j]=new SinglyLinkedList<Integer>();
			}
		}
		int a=0,b=100;
		for (int i = 0; i < 10; i++) {
			arrayList[i]=new SinglyLinkedList[1000];
			for (int j = 0; j < 1000; j++) {
			arrayList[i][j]=new SinglyLinkedList<Integer>();
			}
		}
		for (int i = 0; i <10 ; i++) {
			for (int j = a; j <b; j++) {
				if(Utility.prime1(j)==true) {
					arrayList[i][j].add(j);
				}
			}
			a=a+100;
			b=b+100;
		}
		return arrayList;
	}
	public static void main(String[] args) {
		System.out.println("Below is the prime number stored in linked list 2D array");
		System.out.println();
		SinglyLinkedList [][]arrayList =primeTwoD();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 1000; j++) {
				if(!arrayList[i][j].isEmpty())
					arrayList[i][j].display1();
			}
			System.out.println();
		}
		
	}
}
