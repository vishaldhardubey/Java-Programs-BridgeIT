/**
 * Purpose: Determines table of Power of 2.
 *
 *  @author  Vishal Dhar Dubey
 *  @version 1.0
 *  @since   16-05-2018
 */


package com.bridgelabz.FunctionalPrograms;

/**
 * @author administrator
 * Purpose: Determines table of Power of 2
 */
public class Power
{
public static void main(String []args){
	System.out.println("Enter Number between 1 to 31 inclusively");
	int N=Integer.parseInt(args[0]);
	int out=1;
	System.out.println("2 ^ 0 = 1");
	if(N>=1&&N<=31)
	{
	for(int i=1;i<=N;i++)
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
}
