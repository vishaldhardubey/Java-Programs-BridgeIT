package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;
/**
 *  Purpose: Checker class to check whether the given number is palindrome or not.
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :26-05-2018
 */
public class Palindrome­Checker {
	/**
	 * Function is to check whether the given string is palindrome or not.
	 */
	public static void palindrome() {
		System.out.println("Enter Word to findout whether the string is palindrome or not");
		String str=Utility.scanString();
		int addCount=0;
		char[]ch=str.toCharArray();
		Deque<String> deque=new Deque<>();
		for (int i = 0; i < ch.length; i++) {
			deque.addFront(ch[i]);
			deque.display();
			addCount++;
		}
		System.out.println("The size of given string is : "+addCount);
		int size1=deque.size()/2;
		for (int i = 0; i <size1; i++) {
			if(!deque.removeFront().equals(deque.removeRear())) {
				System.out.println("Not a Palindrome");
				break;
			}
			else {
				System.out.println("Palindrome");
				break;
			}
		}
	}
	public static void main(String[] args) {
		palindrome();
	}
}
