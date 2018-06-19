package com.bridgelabz.AlgorithmPrograms;
import java.io.*;
import java.util.ArrayList;

import com.bridgelabz.utility.Utility;
/**
 * Purpose: Search String using Binary Search.
 *
 *  @author  :Vishal Dhar Dubey.
 *  @version :1.0
 *  @since   :21-05-2018
 */
public class BinaryStringSearch {
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
		System.out.println("Enter the word you want to search");
		String word=Utility.scanString();
		Utility.binaryStringSearch(str1,word);
	}
}
