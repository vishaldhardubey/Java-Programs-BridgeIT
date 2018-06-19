package com.bridgelabz.AlgorithmPrograms;

public class Generics {
	public static int maximum1(int first,int second,int third) {
		int result=(first>second&&first>third)? first:second>first&&second>third? second:third;
		return result;
    }
    
    public static String maximum2(String first,String second,String third) {
    	String result=(first.compareTo(second)>0&&first.compareTo(third)>0? first:second.compareTo(first)>0&&second.compareTo(third)>0? second:third);
		return result;
    }
    
    public static <T extends Comparable<T>> T maximum(T first,T second,T third) {
    	T result=(first.compareTo(second)>0&&first.compareTo(third)>0? first:second.compareTo(first)>0&&second.compareTo(third)>0? second: third);
		return result;
    }
	public static void main(String[] args) {
		int result=maximum1(10,15,5);
		System.out.println(result);
		String result2=maximum2("Vishal","Dhar","Dubey");
		System.out.println(result2);
		int result3=maximum(10,15,5);
		System.out.println(result3);
		String result4=maximum("Vishal","Dhar","Dubey");
		System.out.println(result4);
	}

}
