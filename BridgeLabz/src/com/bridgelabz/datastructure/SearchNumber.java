package com.bridgelabz.datastructure;
/**
 *  Purpose: Nesting of numbers to avoid collision.
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :23-05-2018
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.bridgelabz.utility.Utility;

public class SearchNumber {
	/**
	 * Function is to nesting the data to avoid collision.
	 */
	public static void hashingFunction() {
		SinglyLinkedList list=new SinglyLinkedList<>();
		int size1=list.size();
		String number="";
		SinglyLinkedList []arrayList=new SinglyLinkedList[11];
		for (int i = 0; i < arrayList.length; i++) {
			arrayList[i]=new SinglyLinkedList<Integer>();
		}
		File f=new File("/home/administrator/Desktop/Search Number");
		FileReader fs=null;
		FileWriter fWriter=null;
		BufferedWriter bWriter=null;
		int count=0;
		ArrayList<String> a=new ArrayList<String>();
		BufferedReader fo=null;
		try {
			fs=new FileReader(f);
			fo=new BufferedReader(fs);
			number=fo.readLine();
			while (number!=null) {
				String []str=number.split(",");
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
		int array[]=new int[a.size()];
		for (int i = 0; i < a.size(); i++) {
			array[i]=Integer.parseInt(a.get(i));
		}
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		for (int i = 0; i < array.length; i++) {
			Integer value=(Integer) list.removeFirst();
			int rem=value%11;
			arrayList[rem].add(value);
		}
		for (int i = 0; i < arrayList.length; i++) {
			arrayList[i].display2();
		}
	}
	public static void main(String[] args) throws IOException {
		hashingFunction();
	}
}
