package com.bridgelabz.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.model.Doctor;

public class Utility {
    /**
    * Scanner Object to get UserInput.
    */
        static Scanner sc=new Scanner(System.in);
        
        /**
        * Get UserInput as Integer Value and return it to respective function.
        * @return Integer Value
        */
        public final static int scanInt() {
            return sc.nextInt();
        }
        /**
         * Get UserInput as Integer Value and return it to respective function.
         * @return Integer Value
         */
         public final static long scanLong() {
             return sc.nextLong();
         }
        /**
        * @return double value.
        */
        public final static double scanDouble() {
            return sc.nextDouble();
        }
        /**
        * Get UserInput as String Value.
        * @return String Value to respective function.
        */        
        public final static String scanString() {
            return sc.next();
        }
        /**
        * Get UserInput as String sentence Value.
        * @return String Value to respective function.
        */        
        public static String scanSentence() {
            return sc.nextLine();
        }
        /**
        * Get UserInput as Boolean sentence Value.
        * @return String Value to respective function.
        */        
        public final static Boolean scanBoolean() {
            return sc.nextBoolean();
        }
       
    /**********************************************************************************************************
     * Function to findElapsedtime.
     * @param choice
     */
        public static void findElapsedTime(int choice) {
            long startTime = 0;
            long endTime = 0;
            int flag = 0;
            while (flag == 0) {
                switch (choice) {
                case 1:
                    startTime = System.nanoTime(); // Get the current system time in nano second.
                    System.out.println("Press 0 to stop the Stopwatch");
                    choice = Utility.scanInt();
                    break;

                case 0:
                    endTime = System.nanoTime(); // Get the current system time in nano second.
                    flag = 1;
                }
            }
            System.out.println("Start time is : " + startTime);
            System.out.println("End time is : " + endTime);
            System.out.println("Elapsed Time is : " + (endTime - startTime)/1000000000+" s");
        }
    
    /**********************************************************************************************************
     * Function is to find all prime number between 1-1000.
     * @param number
     */
        public static final boolean prime1(int num) {
        	if(num!=0&&num!=1) {
            int count=0;
            for (int i = 2; i <=num/2; i++) {
                if(num%i==0) {
                    count++;
                    break;
                }
            }
            if(count==0) {
                return true;
            }
        	}
			return false;
        }   
        
   /*********************************************************************************************************
    * Function to perform binary search on given string array
    * @param ar
    * @param word
    * @return index
    */
        public static final <T extends Comparable<T>> int binaryStringSearch(T []ar,T word) {
        	//T tempt=(T) "";
        	T[] array=bubbleSort(ar);
        	for (int i = 0; i < array.length; i++) {
				System.out.println(array[i]);
			}
        	int first=0;
			int last=array.length-1;
			int  mid = 0;
		   while( first <= last ){ 
			   mid =(first+last)/2;
			    if(word.compareTo(array[mid])>0)
			    {
			    	first=mid+1;
			    }
			    else if(word.compareTo(array[mid])<0) {
			    	last=mid-1;
			    }
			    else
			    {	 
				System.out.println("<"+word+">"+" is found at location "+(mid+1));
				return mid;
			    }
			    if(first>last)
			    {
			    	System.out.println(word+ "is not found.\n");
			    }
        	}
		return mid;
        }
        
        
        
    /**********************************************************************************************************
     * Function to perform sorting on String values.
     * @param string array to sort
     */
    
    public static final <T extends Comparable<T>> T[] insertionStringSort(T []strArray) {
    	for (int i = 1; i < strArray.length; i++) {
			T currentStr=strArray[i];
			int j=i;
			while(j>0&&strArray[j-1].compareTo(currentStr)>0) {
				strArray[j]=strArray[j-1];
				j--;
			}
			strArray[j]=currentStr;
		}
		return strArray;
    }
    /**********************************************************************************************************
     * Bubble method to sort elements of integer type.
     * @param array which is needed to sort
     */

    public static final <T extends Comparable<T>> T[] bubbleSort(T[] ar) {
    	T temp=(T)"";
    	for (int i = 0; i < ar.length; i++) {
			for (int j = i+1; j < ar.length; j++) {
				if(ar[i].compareTo(ar[j])>0) {
					temp=ar[j];
					ar[j]=ar[i];
					ar[i]=temp;
				}
			}
		}
		return ar;
    }
    
    /***********************************************************************************************************
     * Function is to sort jsonArray
     * @param jsonArr
     * @return sortedJSONArray
     */
    public static final JSONArray jsonSort(JSONArray jsonArr) {
    	
        for (int i = 0; i < jsonArr.size()-1; i++) {
        	for (int j = i+1; j < jsonArr.size()-i-1; j++) {
				JSONObject a=(JSONObject) jsonArr.get(i);
				JSONObject b=(JSONObject) jsonArr.get(j);
		
 			}
		}
        return jsonArr;	
    }
    
	/**
	 * Function is to jsonArray on the basis of long value.
	 * @param jsonArr
	 * @return jsonArray
	 */
    public static final JSONArray jsonSortLong(JSONArray jsonArr) {
        	for (int j = 0; j < jsonArr.size()-1; j++) {
				JSONObject a=(JSONObject) jsonArr.get(j);
				JSONObject b=(JSONObject) jsonArr.get(j+1);
				if(a.get("personName").toString().compareToIgnoreCase(b.get("personName").toString())>0){
					JSONObject temp=a;
					a=b;
					b=temp;
					jsonArr.set(j, a);
					jsonArr.set(j+1,b);	
				}
        	}
        return jsonArr;	
    }
    
    /***********************************************************************************************************
     * Function is to sort jsonArray
     * @param jsonArr
     * @return sortedJSONArray
     */
    public static final JSONArray jsonSortInt(JSONArray jsonArr) {
    	
        JSONArray sortedJsonArray = new JSONArray();
    	List<JSONObject> jsonValues = new ArrayList<JSONObject>();
    	
        for (int i = 0; i < jsonArr.size(); i++) {
            jsonValues.add((JSONObject) jsonArr.get(i));
        }
        
        Collections.sort( jsonValues, new Comparator<JSONObject>() {
            private static final String KEY_NAME = "ZIP";
            @Override
            public int compare(JSONObject a, JSONObject b) {
                	Integer valA=0,valB=0;
                    valA = (int) a.get(KEY_NAME);
                    valB = (int) b.get(KEY_NAME);
                return valA.compareTo(valB);
            }
        });

        for (int i = 0; i < jsonArr.size(); i++) {
            sortedJsonArray.add(jsonValues.get(i));
        }
		return sortedJsonArray;	
    }
    
    /***********************************************************************************************************
     * Function is to sort jsonArray
     * @param jsonArr
     * @return sortedJSONArray
     */
    public static final int jsonBinarySearch(JSONArray jsonArr,String name) {
    	
        int index=0;
    	List<JSONObject> jsonValues = new ArrayList<JSONObject>();
    	
        for (int i = 0; i < jsonArr.size(); i++) {
            jsonValues.add((JSONObject) jsonArr.get(i));
        }
        
        for (int i = 0; i < jsonValues.size(); i++) {
        	
			if(jsonValues.get(i).containsValue(name)) {
				return index;
			}
			index++;
		}
		return -1;
    }
    
	public static final int jsonSearch(JSONArray jsonArr,long id) {
	    	
	        int index=0;
	    	List<JSONObject> jsonValues = new ArrayList<JSONObject>();
	    	
	        for (int i = 0; i < jsonArr.size(); i++) {
	            jsonValues.add((JSONObject) jsonArr.get(i));
	        }
	        
	        for (int i = 0; i < jsonValues.size(); i++) {
	        	
				if(jsonValues.get(i).containsValue(id)) {
					return index;
				}
				index++;
			}
			return -1;
	    }
    
    /**
	 * @param jsonArray
	 * @param fileName
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
    
    static ObjectMapper mapper=new ObjectMapper();
	public static void isSave(JSONArray jsonArray,String fileName) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("You want to Save this File!!!");
		System.out.println("1 - Enter to Save the Data");
		System.out.println("2 - Enter to Exit without saving");
		int key = Utility.scanInt();
		switch (key) {
		case 1:
				mapper.writeValue(new File(fileName), jsonArray);
				System.out.println("Data hasbeen written");
			break;
		case 2:
				doClose(jsonArray, fileName);
		break;
		default:
			System.err.println("Invalid Input");
			break;
		}
		
	}
	/**
	 * Function is to Close the current file
	 * @param fileName1
	 */
	public static void doClose(JSONArray book,String fileName1) {
		if(book.contains(fileName1)) {
			System.exit(0);
		}
		else {
			System.err.println("Record Rejected");
		}
	}
}