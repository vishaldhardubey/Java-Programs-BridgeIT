package com.bridgelabz.datastructure;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import com.bridgelabz.utility.Utility;
/**
 *  Purpose: Checker class to check whether the given number is palindrome or not.
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :26-05-2018
 */
public class PrimeAnagramInQueue {
	/**
	 * Function is to find out the anagram using queue.
	 */
	public static void primeAnagram() {
		System.out.println("Enter the Largest Num till which you want to get prime number");
		int count=0;
		ArrayList<Integer> list=new ArrayList<Integer>();
		ArrayList<Integer> distinct=new ArrayList<Integer>();
		int largestNum=Utility.scanInt();
		for (int i = 2; i < largestNum; i++) {
			if(Utility.prime1(i)==true) {
				list.add(i);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			for (int j = i+1; j < list.size(); j++) {
				String stringOne=list.get(i)+"";
				String stringTwo=list.get(j)+"";
				if(Utility.stringAnagram(stringOne, stringTwo)==true) {
					if(distinct.contains(stringOne)==false||distinct.contains(stringTwo)==false)
					distinct.add(Integer.parseInt(stringOne));
					distinct.add(Integer.parseInt(stringTwo));
					count++;
				}
			}
		}
		QueueLinkedList<Integer> que=new QueueLinkedList<>();
		for (int i = 0; i < distinct.size(); i++) {
			que.enqueue(distinct.get(i));
		}
		que.display();
		System.out.println("Total number of Anagrams are : "+count);
	}
	public static void main(String[] args) {
		primeAnagram();
	}
}
