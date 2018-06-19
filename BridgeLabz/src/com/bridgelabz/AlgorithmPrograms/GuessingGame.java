package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.utility.Utility;
/**
 * Purpose: Guessing a Number Game.
 *
 *  @author  :Vishal Dhar Dubey.
 *  @version :1.0
 *  @since   :21-05-2018
 */
public class GuessingGame {
	public static int search(int lowestValue,int highestValue) {
		if((highestValue-lowestValue)==1) {
			return lowestValue;
		}
		int mid=lowestValue+(highestValue-lowestValue)/2;
		System.out.println("Is it less than "+mid);
		if(Utility.scanBoolean()) {
			return search(lowestValue,mid);
		}
		else {
			return search(mid, highestValue);
		}
	}
	public static void main(String[] args) {
		int N=Integer.parseInt(args[0]);
		int n=(int)Math.pow(2,N);
		int res=search(0, n);
		System.out.println(res);
	}
}