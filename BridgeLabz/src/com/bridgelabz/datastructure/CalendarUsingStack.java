package com.bridgelabz.datastructure;
import com.bridgelabz.utility.Utility;
/**
 *  Purpose: Display the calendar of a month based on given year.
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :28-05-2018
 */
public class CalendarUsingStack {
	/**
	 * Function to findout leap year and change the number of dates accordingly.
	 * @param year
	 * @param dayOfMonth
	 * @return dayOfMonth
	 */
	public static int leapYearCondition(Integer year,Integer dayOfMonth) {
		if(Utility.isLeapYearB(year)==true) {
			dayOfMonth=29;
		}
		else {
			dayOfMonth=28;
		}
		return dayOfMonth;
	}
	/**
	 * Function is to Find First Day of Month
	 * @param month
	 * @param year
	 */
	public static void firstDayOfMonth(Integer month,Integer year) {
			StackLinkedList weekDay=new StackLinkedList();
			StackLinkedList weekDay1=new StackLinkedList();
			Integer []date1= {0,31,28,31,30,31,30,31,31,30,31,30,31};
			date1[2]=leapYearCondition(year, month);
			
			Integer date=1;
			String dayOfMonth=Utility.dayOfWeek(month, date, year);
	    	String []day= {"SUN","MON","TUE","WED","THU","FRI","SAT"};
	    	for (int i = 0; i < day.length; i++) {
				weekDay.push(day[i]);
			}
	    	
	    	for (int i = 0; i < day.length; i++) {
				weekDay1.push(weekDay.pop());
			}
	    	
	    	Integer position=0;
	    	
	    	for (int i = 0; i < day.length; i++) {
				if(dayOfMonth.equals(day[i])) {
					position=position+i;
				}
			}
	    	
	      // Array to store months of the year.
			String[] months= {"","JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE",
						"JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
			for (int i = 0; i < months.length; i++) {
				if(month==i) {
					System.out.println("  "+months[i]+"   "+year);
				}
			}
			weekDay1.display1();
			 
			StackLinkedList array=new StackLinkedList();
			int dateValue=0;
			for (int k = 0; k < date1.length; k++) {
				if(month==k) {
				dateValue=dateValue+date1[k];
				int datePrint=1;
				for (int i = 0; i < dateValue; i++) {
					if(datePrint<=dateValue) {
						array.push(datePrint);
					}
					datePrint++;
				}
			}
		}
		for (int i = 0; i < position; i++) {
			System.out.println();
            System.out.print("                    ");
        }
        for (int i = 1; i <= dateValue; i++) {
            if (i < 10)
                System.out.print("  0" + i);
            else
                System.out.print("  " + i);
            if (((i + position) % 7 == 0) || (i == dateValue))
                System.out.println();

        }
	}
	
	public static void main(String[] args) {
		System.out.println("Enter the month");
		int month=Utility.scanInt();
		System.out.println("Enter the year");
		int year=Utility.scanInt();
		firstDayOfMonth(month, year);
	}
}
