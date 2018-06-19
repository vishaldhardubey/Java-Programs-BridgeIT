/**
 * Purpose: Implementation class for linked list and Nodes.
 *
 *  @author  :Vishal Dhar Dubey.
 *  @version :1.0
 *  @since   :23-05-2018
 */

package com.bridgelabz.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.bridgelabz.utility.Utility;

public class UnorderedList {
	public static void main(String[] args) {
		SinglyLinkedList<String> list=new SinglyLinkedList<String>();
		int count=0;
		File f=new File("/home/administrator/Desktop/Insertion Order");
		FileReader fr=null;
		BufferedReader br=null;
		FileWriter fwriter=null;
		BufferedWriter bwriter=null;
		try {
			fr=new FileReader(f);
			br=new BufferedReader(fr);
			String word=br.readLine();
			while(word!=null) {
				String [] str=word.split(",");
				count++;
				for (int i = 0; i < str.length; i++) {
					list.add(str[i]);
				}
				break;
			}
			System.out.println("It is going to search all the element");
			list.display();
			System.out.println(list.size());
			System.out.println("Enter the word to search in the linked list");
			String word1=Utility.scanString();
			int valueAt=list.search(word1);
			if (valueAt==-1) {
				System.out.println("Adding name in the list");
				list.add(word1);
				System.out.println("Name added Successfully");
				fwriter=new FileWriter("/home/administrator/Desktop/Insertion Order");    
		           bwriter=new BufferedWriter(fwriter);
		           bwriter.write(word+","+word1);
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
				fwriter.close();
				fr.close();
				br.close();
				bwriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		} 
}
