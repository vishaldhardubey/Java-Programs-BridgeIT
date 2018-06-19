package com.bridgelabz.AlgorithmPrograms;
import java.util.ArrayList;

import com.bridgelabz.utility.Utility;
/**
 * Purpose: Determines the prime number Palindrome.
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :16-05-2018
 */
public class PrimeAnagramPalindrom {
	public static final void prime2(int num) {
        int count=0;
        ArrayList<Integer> arr=new ArrayList<>();
        for (int i = 2; i <=num/2; i++) {
            if(num%i==0) {
                count++;
                break;
            }
        }
        if(count==0) {
            System.out.print(num+",");
            arr.add(num);
            palindrom(num);
        }
      anagram(arr);
    }  
	public static void anagram(ArrayList<Integer> arr) {
		String []anagramArray=new String[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			anagramArray[i]=""+arr.get(i);
		}
		for (int i = 0; i < anagramArray.length; i++) {
			for (int j =0; j < anagramArray.length; j++) {
				Utility.stringAnagram(anagramArray[i], anagramArray[j]);
			}
		}
	}
	public static void palindrom(int num) {
		int a=num;
		int reversedInt=0;
		while(num!=0) {
			int remainder= num%10;
			reversedInt=reversedInt*10+remainder;
			num/=10;
		}
		if(a==reversedInt) {
			System.out.println("Number "+a+" is palindrom");
		}
	}
	public static void main(String[] args) {
		System.out.println("Enter the Largest Num till which you want to get prime number");
		int largestNum=Utility.scanInt();
		for (int i = 2; i < largestNum; i++) {
		prime2(i);
		}
	}
}
