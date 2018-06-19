package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

/**
 *  Purpose: Display the calendar of a month based on given year.
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :26-05-2018
 */
public class Calendar {
	/**
	 * Function to findout leap year and change the number of dates accordingly.
	 * @param year
	 * @param dayOfMonth
	 * @return dayOfMonth
	 */
	public static int leapYearCondition(int year,int dayOfMonth) {
		if(Utility.isLeapYearB(year)==true) {
			dayOfMonth=29;
		}
		else {
			dayOfMonth=28;
		}
		return dayOfMonth;
	}
	/**
	 * Function to calculate first day of Month and also print the calendar of the month.
	 * @param month
	 * @param year
	 */
	public static void firstDayOfMonth(int month,int year) {
		int []date1= {0,31,28,31,30,31,30,31,31,30,31,30,31};
			date1[2]=leapYearCondition(year, month);
			int date=1;
			String dayOfMonth=Utility.dayOfWeek(month, date, year);
	    	
			
			String []day= {"SUN","MON","TUE","WED","THU","FRI","SAT"};
	    	int position=0;
	    	for (int i = 0; i < day.length; i++) {
				if(dayOfMonth.equals(day[i])) {
					position=position+i;
				}
			}
	     //Taking String array to store months and date.
	        String [][] array=new String[7][7];
			String[] months= {"","JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE",
						"JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
			for (int i = 0; i < months.length; i++) {
				if(month==i) {
					System.out.println("  "+months[i]+"   "+year);
				}
			}
			for (int i = 0; i < day.length; i++) {
				System.out.print(day[i]+" ");
			}
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					array[i][j]=" ";
				}
			}
		
		//loop to store calendar dates based on month and year.
			for (int k = 0; k < date1.length; k++) {
				if(month==k) {
					int dateValue=date1[k];
					int datePrint=1;
					int datePosition=position;
					System.out.println();
					int j=0;
					for (int i = 0; i < 7; i++) {
						if(i==0) {
							for(int c=0;c<position;c++) {
								System.out.print("   ");
							}
						}
						for ( j = position; j < 7; j++) {
							if(datePrint<=dateValue) {
								if(datePrint<=9) {
									array[i][j]=datePrint+"   ";
									datePrint++;
								}
								else {
									array[i][j]=datePrint+"  ";
									datePrint++;
								}
							}
							
						}
						position=0;
					}
				}
			}
		//loop to print calendar.
			for(int i=0;i<7;i++) {
				for(int j=0;j<7;j++) {
					System.out.print(array[i][j]);
				}
				System.out.println();
			}
	}
	
	/**
	 * Main function to call calendar functions.
	 * @param args
	 */
	public static void main(String[] args) {
		int month=Integer.parseInt(args[0]);
		int year = Integer.parseInt(args[1]);
		firstDayOfMonth(month,year);
	}

}
