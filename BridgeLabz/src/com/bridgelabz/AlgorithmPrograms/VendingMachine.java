package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.utility.Utility;
/**
 * Purpose: Use of Vending Machine to get change.
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :16-05-2018
 */
public class VendingMachine {
	public static void vending(int rupees) {
		int restAmount=0;
		int count=0;
		if(rupees>=1000) {
			count=rupees/1000;
			System.out.println("Number of 1000 Notes :"+count);
			restAmount=rupees-(count*1000);
			vending(restAmount);
		}
		else if(rupees>=500&&rupees<=1000) {
			count=rupees/500;
			System.out.println("Number of 500 Notes : "+count);
			restAmount=rupees-(count*500);
			vending(restAmount);
		}
		else if(rupees>=100&&rupees<=500) {
			count=rupees/100;
			System.out.println("Number of 100 Notes : "+count);
			restAmount=rupees-(count*100);
			vending(restAmount);
		}
		else if(rupees>=50&&rupees<=100) {
			count=rupees/50;
			System.out.println("Number of 50 Notes : "+count);
			restAmount=rupees-(count*50);
			vending(restAmount);
		}
		else if(rupees>=10&&rupees<=50) {
			count=rupees/10;
			System.out.println("Number of 10 Notes : "+count);
			restAmount=rupees-(count*10);
			vending(restAmount);
		}
		else if(rupees>=5&&rupees<=10) {
			count=rupees/5;
			System.out.println("Number of 5 Notes : "+count);
			restAmount=rupees-(count*5);
			vending(restAmount);
		}
		else if(rupees>=2&&rupees<=5) {
			count=rupees/2;
			System.out.println("Number of 2 Notes : "+count);
			restAmount=rupees-(count*2);
			vending(restAmount);
		}
		else if(rupees>=1) {
			count=rupees/1;
			System.out.println("Number of 1 Notes : "+count);
		}
	}
	public static void main(String[] args) {
		System.out.println("Enter the rupees you want change");
		int rupees=Utility.scanInt();
		vending(rupees);
	}
}
