package com.bridgelabz.oopsconcept;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.DateFormatter;

import com.bridgelabz.utility.Utility;

public class Regex {
	
	static String CONTENT="Hello <<name>>, We have your full name as <<full name>> in our system. your contact number is 91­-xxxxxxxxxx."
			+ "Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016.";
	/**
	 * Function to find out regex of a given string.
	 * @param name
	 * @param fulName
	 * @param mobNum
	 */
	public static String regex(String name,String fulName,String mobNum) {
		String fName="<<name>>";
		String fullName="<<full name>>";
		String mobNo="-xxxxxxxxxx";
		String date="01/01/2016";
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 =new Date();
		String date2=dateFormat.format(date1);
		CONTENT=replace(CONTENT,fName,name);
		CONTENT=replace(CONTENT,fullName,fulName);
		CONTENT=replace(CONTENT,mobNo,mobNum);
		CONTENT=replace(CONTENT,date,date2);
		return CONTENT;
	}
	/**
	 * Function to return replaced string value
	 * @param CONTENT
	 * @param regex
	 * @param value
	 * @return CONTENT
	 */
	public static String replace(String CONTENT,String regex,String value) {
		Pattern p = Pattern.compile(regex);//. represents single character  
		Matcher m = p.matcher(CONTENT);  
		boolean b = m.matches();
		String res=m.replaceAll(value);
		return res;  
	}
	public static void main(String[] args) {
		System.out.println("Enter your first name");
		String name=Utility.scanString();
		System.out.println("Enter your full name");
		String fullName=Utility.scanString();
		System.out.println("Enter your mobile number");
		String mobNum=Utility.scanString();
		String CONTENT =regex(name,fullName,mobNum);
		System.out.println(CONTENT);
	}

}
