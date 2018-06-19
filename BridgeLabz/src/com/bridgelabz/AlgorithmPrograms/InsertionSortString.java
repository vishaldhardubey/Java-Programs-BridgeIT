package com.bridgelabz.AlgorithmPrograms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import com.bridgelabz.utility.Utility;

public class InsertionSortString {
	public static void main(String[] args) {
		File f=new File("/home/administrator/Desktop/Insertion Order");
		FileReader fs=null;
		int count=0;
		ArrayList<String> a=new ArrayList<String>();
		BufferedReader fo=null;
		try {
			fs=new FileReader(f);
			fo=new BufferedReader(fs);
			String word=fo.readLine();
			System.out.println(word);
			while (word!=null) {
				String []str=word.split(",");
				for (int i=0;i<str.length;i++) {
					count++;
					a.add(str[i]);
				}
				break;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		String []str1=new String[count];
		for (int i = 0; i < a.size(); i++) {
				str1[i]=a.get(i);
			}
		String [] res=Utility.insertionStringSort(str1);
		for (int j = 0; j < res.length; j++) {
			System.out.println(res[j]);			
		}
	}
}