package com.bridgelabz.AlgorithmPrograms;

import com.bridgelabz.utility.Utility;

public class Exp <T>{
	public static <T> void experiment(Comparable<T>[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	public static void main(String[] args) {
		Integer size=Utility.scanInt();
		String []array=new String[size];
		for (int i = 0; i < array.length; i++) {
			array[i]=Utility.scanString();
		}
		experiment(array);
	}

}
