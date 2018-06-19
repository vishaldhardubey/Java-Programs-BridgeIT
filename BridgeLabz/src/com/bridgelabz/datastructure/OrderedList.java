package com.bridgelabz.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.bridgelabz.utility.Utility;
/**
 *  Purpose: Created Ordered list by using singlylinkedlist.
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :25-05-2018
 */
public class OrderedList {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list=new SinglyLinkedList<Integer>();
		list.list();
		int count=0;
		File f=new File("/home/administrator/Desktop/Ordered List");
		FileReader fr=null;
		BufferedReader br=null;
		FileWriter fwriter=null;
		BufferedWriter bwriter=null;
		String[] str=new String[100];
		
		// Reading content from File.
		try {
			fr=new FileReader(f);
			br=new BufferedReader(fr);
			String word=br.readLine();
			while(word!=null) {
				str=word.split(",");
				count++;
				break;
			}
		//Converting string array into Integer Array.
			Integer [] array=new Integer[str.length];
			for (int i = 0; i < array.length; i++) {
				array[i]=Integer.parseInt(str[i]);
			}
		//Sorting array
			Integer []sorted=(Integer[]) list.sort(array);
			for (int i = 0; i < sorted.length; i++) {
				list.add(sorted[i]);
			}
			list.display();
			System.out.println("Enter the word to search in the linked list");
			int number=Utility.scanInt();
			int valueAt=list.search(number);
			if (valueAt==-1) {
				System.out.println("Adding name in the list");
				list.add(number);
				System.out.println("Name added Successfully");
				fwriter=new FileWriter("/home/administrator/Desktop/Ordered List");    
		           bwriter=new BufferedWriter(fwriter);
		           bwriter.write(word+","+number);
		           bwriter.flush();
		           list.display();
			}
			else {
				list.removeAt(valueAt);
				System.out.println("Word removed Successfully");
				list.display();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
