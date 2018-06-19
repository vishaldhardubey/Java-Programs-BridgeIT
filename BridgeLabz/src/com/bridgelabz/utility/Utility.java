package com.bridgelabz.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
        /**
         * @Param function to find sum of distinct number which will be equal to zero.
         */
         public final static void sumEqualsZero(int []arr) {
             int count=0;
             //for loop to initialize the values in integer array
             for (int i = 0; i < arr.length-2; i++) {
                 for (int j = i+1; j < arr.length-1; j++) {
                 	if(i!=j) {
                     for (int k = j+1; k < arr.length; k++) {
                     	if(j!=k) {
                             // Condition to check the sum equals to zero
                             if(arr[i]+arr[j]+arr[k]==0) {
                                 count++;
                                 System.out.println(arr[i]+" , "+arr[j]+" , "+arr[k]);
                             	}
                     		}
                     	}//end of inner for loop
                 	}
                 }//end of mid for loop
             }//end of outer for loop
             System.out.println("Number of distinct triplets are : "+count);
         }
         
        
        /**
        * @Param Axis x,y function to give distance from origin.
        */
        public final static void distanceFromOrigin(int x,int y) {
           double distance= Math.sqrt(((Math.pow(x, 2)+Math.pow(y, 2))));
           System.out.println("The Euclidean Distance = "+distance);
        }
        
        public static double powerfunction(int base, int power) {
        	double res=1;
        	for (int i = 0; i < power; i++) {
				res=res*base;
			}
        	return res;

        }
        public static double sqrt(double number) {
    		double t;
    		double squareRoot = number / 2;
    		do {
    			t = squareRoot;
    			squareRoot = (t + (number / t)) / 2;
    		} while ((t - squareRoot) != 0);
    	 
    		return squareRoot;
    	}
    /**
    * Function to replace String Value.
    * @param username which is to be placed.
    * @return String after replacing.
    */
    public final static String replaceString(String username) {
        String template = "Hello <<username>>, How are you?";
        String output = "";
        if (username.length() < 3) {
            System.out.println("username should contain minimum three character atleast !");
        } else {
            output = template.replaceAll("<<username>>", username);
        }
        return output;
    }
    /**************************************************************************************************************
     *  @Param couponNum find the number of times it takes to 
     *  find all distinct Coupon number.
     */
         public final static void randomNumberCoupon(int couponNum){
             int[] couponNumbers= {0,1,2,3,4,5,6,7,8,9};
         	int count=0;
             Random rand=new Random();
             for(int i=0;i<couponNumbers.length;i++) {
                 //Generating Random number varying from 0 to 9.
                 int code=couponNumbers[i];
                     while(code!=rand.nextInt(10)) {
                         count++;
                     }
                 }//End of outer for loop
                 
             System.out.println("It will take "+count+" random number to find distinct coupon number.");
         }
    /**************************************************************************************************************
    * Function to find out the prime factors of given number.
    */
        public final static void prime(int num) {
            /*
            * loop to calculate factor as 2
            */
            
            while(num%2==0) {
                System.out.println(2+" ");
                num=num/2;
            }
            
            /**
            * prime factor other than 2
            */
            
            for (int i = 3; i < Math.sqrt(num); i=i+2) {
                while(num%i==0) {
                    System.out.println(i+" ");
                    num=num/i;
                }
            }
        }
    
    /************************************************************************************************************
    * Function to check user input year leap year or not.
    * @param year
    * @return the boolean decision for leap year or not
    */
        /*
         * Static Variable is declared to print whether the year is leap year or not. 
         */
        static String LEAP_YEAR=" is a Leap Year";
    	static String NOT_LEAP_YEAR=" is not a Leap Year";	
    	
        public final static String isLeapYear(int year) {
            if (year >= 1000 && year <= 9999) {
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                    return year+LEAP_YEAR;
                } else {
                    return year+NOT_LEAP_YEAR;
                }
            } 
            else {
                return year+NOT_LEAP_YEAR;
            }
        }
        
        public final static boolean isLeapYearB(int year) {
            if (year >= 1000 && year <= 9999) {
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                    return true;
                } else {
                    return false;
                }
            } 
            else {
                return false;
            }
        }
    
    /************************************************************************************************************
     * This function for gambling or betting which to find user will loose or win.
     * @param number-to takes numbers from user for set goal,amount and timeOfNumber
     * Print the result for win or loss percentage and number of time win out of
     * total chances
     */
         /*
          * Static Variable is declared to Store the values of win and loss. 
          */
         static int win = 0;
         static int loss = 0;
         public final static void gambler() {
         	System.out.println("Enter the Stack Money");
         	double stack=Utility.scanDouble();
         	System.out.println("Enter the Goal Money.");
         	double goal=Utility.scanDouble();
         	System.out.println("Enter the Number of Bets");
         	int noOfTimes=Utility.scanInt();
             for (int i = 0; i <= noOfTimes; i++) {
                 double random=Math.random();
                     if (random > 0.5) {
                         stack++;    
                         win++;
                         /*
                          * Condition to check whether game over or not.
                          */
                         if (stack == goal) {
                             System.out.println("you are reach the goal");
                             break;
                         }
                     } else {
                         stack--;
                         loss++;
                         /*
                          * Condition to check whether game over or not.
                          */
                         if (stack == 0) {
                             System.out.println("you are reach the goal");
                             break;
                         }
                     }
                 }
             // Display number of games won.
             double winPercentage= (win * 100) / (win + loss);
             System.out.println("Number of Games Won : "+win);
             System.out.println("Number of Games Loose :"+loss);
             System.out.println("percentage of win : " +winPercentage+ " %");
             System.out.println("percentage of loose : " + (100-winPercentage) + " %");
         }
             
     /**********************************************************************************************************
      * Function to flip the coin and check the number of occurrence of head and tail.
      * @param chance
      */
         /*
          * Static Variable is declared to store head and tails.  
          */
         static int head=0;
     	static int tails=0;
         public static void flipcoin(int chance) {
         	double percentage1=0;
         	double percentage=0;
 			for (int i = 0; i < chance; i++) {
 				double value=Math.random();
                 if (value > 0.5) {
                    head++;
                 }
                 else {
                     tails++;
                 }  
             }
 			System.out.println("The percentage of head is : ");
 			  percentage1 = (head*100 / (head+tails));
 			  System.out.println(percentage1);
 			  System.out.println("The percentage of tail is : ");
 			  percentage = (100-percentage1);
               System.out.println(percentage);
         }

    /************************************************************************************************************
    * function of 2D arrays of integers, doubles and boolean from standard
    * input and printing them out to standard output.
    * @param number take input number to choose the options
    */
        public final static void twoDimensionArray(int choice) {

            switch (choice) {
            case 1:

                System.out.println("Enter Number of rows");
                int rows = Utility.scanInt();
                System.out.println("Enter Number of columns");
                int colmn = Utility.scanInt();
                int[][] arrayInt = new int[rows][colmn];
                System.out.println("Enter the elements for rows and colms: ");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < colmn; j++) {
                        arrayInt[i][j] = Utility.scanInt();
                    }
                }
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < colmn; j++) {
                        System.out.print(arrayInt[i][j] + " ");
                    }
                    System.out.println();
                }
                break;

            case 2:
                System.out.println("Enter Number of rows");
                int rowsD = Utility.scanInt();
                System.out.println("Enter Number of colmn");
                int colmnD = Utility.scanInt();
                double[][] arrayDouble = new double[rowsD][colmnD];
                System.out.println("Enter the elements for rows and colms: ");
                for (int i = 0; i < rowsD; i++) {
                    for (int j = 0; j < colmnD; j++) {
                        arrayDouble[i][j] = Utility.scanDouble();
                    }
                }
                for (int i = 0; i < rowsD; i++) {
                    for (int j = 0; j < colmnD; j++) {
                        System.out.println(arrayDouble[i][j] + " ");
                    }
                    System.out.println();
                }
                break;

            case 3:
                System.out.println("Enter Number of rows");
                int rowsB = Utility.scanInt();
                System.out.println("Enter Number of colmn");
                int colmnB = Utility.scanInt();
                boolean[][] arrayBoolean = new boolean[rowsB][colmnB];
                System.out.println("Enter the elements for rows and colms: ");
                for (int i = 0; i < rowsB; i++) {
                    for (int j = 0; j < colmnB; j++) {
                        arrayBoolean[i][j] = Utility.scanBoolean();
                    }
                }
                for (int i = 0; i < rowsB; i++) {
                    for (int j = 0; j < colmnB; j++) {
                        System.out.print(arrayBoolean[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            default:
                System.out.println("wrong input !");
            }
        }
        
    /******************************************************************************************************
    * Function to findOut Sum of Harmonic number series.
    * @param N
    */
        /*
         * Static variable is declared to print sum of N harmonic number.
         */
        static String SUM="The sum of given harmonic Number is : ";
        public static final String harmonic(int N)
        {
            float out=0.0f;
            String res="";
            if (N==0) {
					throw new ArithmeticException();
				}
            else {
        	//loop to find out the sum of harmonic series.
            for(float i=1;i<=N;i++)
            {
            	if(i==1) {
            		res=res+1+"/"+i;
            	}
            	else {
                out= out + (1/i);
                res=res+" + "+1+"/"+i;
            	}
            }
            System.out.println(SUM);
            return res+" = "+out;
            }
        }
    /*******************************************************************************************************
    * Function to print table of power of 2.
    * @param powerNum
    */
        public static final void power(int powerNum) {
            
            int out=1;
            System.out.println("2 ^ 0 = 1");
            if(powerNum>=1&&powerNum<=31)
            {
            for(int i=1;i<=powerNum;i++)
            {
                out = out*2;
                System.out.println("2 ^ "+i+" = "+out);
            }
            }
            else
            {
                System.out.println("-777");
            }
        }
        
        
   /**********************************************************************************************************
    * function- Determine the windChill temperature.
    * @param temparature below 55F
    * @param speed between 3 to 120
    */
        public static void calculateWindChill(double temparature, double windSpeed) {
        	if(temparature<50&&windSpeed>3&&windSpeed<120 ) {
        		//formula to calculate temperature
        		double weather= 35.74 + (0.6215 * temparature) + ((0.4275*temparature - 35.75)*Math.pow(windSpeed, 0.16));
                System.out.println("Effective temperature of wind chill would be: "+weather);
        	}
        	else {
        		System.out.println("invalid data");
        	}
        }
   
    /*********************************************************************************************************
     * Function is to find Square Root of a given Expression.
     * @param numFirst
     * @param numSecond
     * @param numThird
     */
         /*
          *	Static Variable is declared to print roots.
          */
         static String ROOT1="root-1 of 'x' = ";
         static String ROOT2="root-2 of 'x' = ";
         public static void findRoots(int A, int B, int C) {
         	if(A > 0||C > 0) {
             double delta=(B*B)-(4*A*C);
             double root1=0;
             double root2=0;
             if(delta>0) {
                 root1=(-B + Math.sqrt(delta))/(2*A);
                 root2=(-B - Math.sqrt(delta))/(2*A);
                 System.out.println(ROOT1+root1);
                 System.out.println(ROOT2+root2);
             }
             else if(delta<0)
             {
                 System.out.println("root 1 of x:is the real part = "+(-B)/(2*A));
                 System.out.println("root 1 of x:is the imaginary part = "+Math.sqrt((-delta)/(2*A)));
             }
             else
             {
                 System.out.println("root-1 of 'x' and root-2 of 'x' = "+(-B)/(2*A));
             }
         	}
         	else {
         		System.out.println("Invalid input");
         	}
         }
  /************************************************************************************************************
   * Function to find out permutation of a given String.
   * @param inputString
   */

        public static void permutation(String inputString) {
            String permute="";
            permutationString(permute,inputString);
           
        }
        public static void permutationString(String permute, String inputString) {
            if (inputString.length() == 0) {
                System.out.println(permute);
            } else {
                for (int i = 0; i < inputString.length(); i++) {
                    permutationString(permute + inputString.charAt(i),inputString.substring(0, i) + inputString.substring(i + 1, inputString.length()));
                }
            }
        }
        
   /************************************************************************************************************
    * Function to find whether given strings are anagram or not.
    * @param stringOne
    * @param stringTwo
    */
        public static final boolean stringAnagram(String stringOne,String stringTwo) {
            String strOne=stringOne.replaceAll("\\s","");
            String strTwo=stringTwo.replaceAll("\\s", "");
            if(compareLength(strOne,strTwo)==true) {
	            return true;
	        }
            return false;
        }
    /***********************************************************************************************************
     * Function will compare the length of two string.
     * @param str1
     * @param str2
     */
        public static final boolean compareLength(String str1,String str2) {
            int strOneLength=str1.length();
            int strTwoLength=str2.length();
            if(strOneLength!=strTwoLength) {
                return false;
            }
            else if(strOneLength==strTwoLength){
                str1= str1.toUpperCase();
                str2= str2.toUpperCase();
                if(stringCompare(str1, str2)==true) {
                	return true;
                }
            }
           return false;
        }
    /**********************************************************************************************************
     * Function to compare the given two string
     * @param strOne 
     * @param strTwo 
     */
        public static final boolean stringCompare(String strOne,String strTwo) {
            char []strArrayOne=strOne.toCharArray();
            char []strArrayTwo=strTwo.toCharArray();
            Arrays.sort(strArrayOne);
            Arrays.sort(strArrayTwo);
            if(Arrays.equals(strArrayOne, strArrayTwo)) {
            	return true;
            }
			return false;
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
    	
        JSONArray sortedJsonArray = new JSONArray();
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
    /*******************************************************************************************
     * Function to perform Merge Sort.
     * @param first index and highest index of an array.
     */
        public static final Integer[] mergeSort(Integer[] ar,Integer low,Integer high) {
        	if(low<high) {
        		Integer mid=low+(high-low)/2;
        		mergeSort(ar,low,mid);
        		mergeSort(ar,mid+1, high);
        		merge(ar,low,mid,high);
        	}
			return ar;
        }
        public static final Integer[] merge(Integer[] ar,Integer low,Integer mid,Integer high)  
    	{  
        	Integer i, mid1, k=0, low1;  
    	    Integer[] temp= new Integer[500];
    	    low1 = (Integer) low;  
    	    i = (Integer) low;  
    	    mid1 = mid + 1;  
    	    while ((low1 <= mid) && (mid1 <= high))  
    	    {  
    	        if (ar[low1]<=ar[mid1])  
    	        {  
    	            temp[i] = ar[low1];  
    	            low1++;  
    	        }  
    	        else  
    	        {  
    	            temp[i] = ar[mid1];  
    	            mid1++;  
    	        }  
    	        i++;  
    	    }  
    	    if (low1 > mid)  
    	    {  
    	        for (k = mid1; k <= high; k++)  
    	        {  
    	            temp[i] = ar[k];  
    	            i++;  
    	        }  
    	    }  
    	    else  
    	    {  
    	        for (k = low1; k <= mid; k++)  
    	        {  
    	             temp[i] = ar[k];  
    	             i++;  
    	        }  
    	    }  
    	   
    	    for (k = low; k <= high; k++)  
    	    {  
    	        ar[k] = temp[k];  
    	    }
			return ar; 
    	}
        

    /**
     * Function is to find out temperature into Degree Celsius.
     * @param temperature
     * @param choice
     */
        public static final void tempToCel(double temperature,int choice) {
        	switch (choice) {
			case 1:
				double fahrenheit=0;
	        	fahrenheit=(temperature*(9/5)+32);
	        	System.out.println("The temperature in farenheit is "+fahrenheit);
				break;
			case 2:
				double celsius=0;
	        	celsius=((temperature-32)*(5/9));
	        	System.out.println("The temperature in Celsius is "+celsius);
	        	break;
			default:
				System.out.println("Invalid input");
				break;
			}
        }
	    
	/*******************************************************************************************
	 * Function to return day falls on given date.
	 * @param month
	 * @param date
	 * @param year
	 */
        public static final String dayOfWeek(int month,int date ,int year) {
        	String []DAY= {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        	if(month>=1&&month<=12) {
        		if(date>=1&&date<=31) {
        			int yearOut=year-(14-month)/12;
        			int yOut=yearOut+(yearOut/4)-(yearOut/100)+(yearOut/400);
        			int monthOut=month+12*((14-month)/12)-2;
        			int dateOut =(date+yOut+(31*monthOut)/12)%7;
        			//loop to check for the day and print corresponding day.
        			for (int i = 0; i < DAY.length; i++) {
						if(dateOut==i) {
							return DAY[i];
						}
					}
        		}
        	}
        	return null;
        }
	/*******************************************************************************************
	 * Function is to calculate monthly payment
	 * @param principal amount year and rate
	 */
        public static double payment(double principal, double year, double rate) {
    		//checks valid input
        	double actualPayment=0;
        	if(principal>0&&year>=1&&year<=12) {
    		double totalMonth=12*year;
    		double actualRate=rate/(1200);
    		actualPayment=(principal*actualRate)/(1-1/(Math.pow((1+actualRate),totalMonth)));
    		}
    		else {
    			System.out.println("Invalid Data");
    		}
			return actualPayment;
    	}
    
	/********************************************************************************************************
	 * Function to find out sqrt of given number
	 * @param Number
	 */
        public static double sqrt(int cNum) {
    		double epsilon=Math.pow(Math.E, -15);
    		double t=0;
    		if(cNum>0) {
    			t=cNum;
    			while(Math.abs(t-(cNum/t))>epsilon*t) {
    				t=(t+(cNum/t))/2.0;
    			}
    		}
    		return t;
    	}
	/********************************************************************************************************
	 * Function to convert decimal into binary.
	 * @param Number
	 */     
        public static String toBinary(int number) {
    		String str="";
    		int count=0;
    		String out="";
    		if(number>0) {
    			while(number!=0) {
    				int rem=number%2;
    				str=rem+str;
    				number=number/2;
    				count++;
    			}
    		}
    		for(int i=0;i<8-count;i++) {
				out+='0';
			}
    		str=out+str;
    		return str;
    	}
        
    /********************************************************************************************************
	 * Function to convert decimal into binary.
	 * @param Number
 */      
        static String nibble1="";
    	static String nibble2="";
		public static final int toDecimal(int Decimal) {
		String binary=toBinary(Decimal);
		
		for (int i = 0; i < 4; i++) {
			nibble1=nibble1+binary.charAt(i);
		}
		for (int i = 4; i < 8; i++) {
			nibble2=nibble2+binary.charAt(i);
		}	
		return (int)convert(nibble2+nibble1);
    }
    	public static final double convert(String nibble) {
    		int value=Integer.parseInt(nibble);
    		double sum=0;
    		for (int i = 0; i < nibble.length(); i++) {
				int rem=value%10;
				sum=sum+rem*Math.pow(2, i);
				value=value/10;
			}
		return sum;
   }     
}