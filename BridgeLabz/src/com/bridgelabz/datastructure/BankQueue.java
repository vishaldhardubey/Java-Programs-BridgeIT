package com.bridgelabz.datastructure;
import java.util.Random;
/**
 * Purpose: Simulate the bank counter .
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :23-05-2018
 */
import javax.swing.SwingConstants;

import com.bridgelabz.utility.Utility;

public class BankQueue {
	static double amount=10000;
	/**
	 * Function is to withdraw and maintain amount at the cash counter.
	 * @param que
	 * @param money
	 */
	public static void withdraw(Queue que, double money) {
		if(amount>0) {
		amount=amount-money;
		System.out.println("Total amount in bank"+amount);
		que.dequeue();
		}
	}
	/**
	 * Function is to deposit and maintain amount at the cash counter.
	 * @param que
	 * @param money
	 */
	public static void deposit(Queue que, double money) {
		amount=amount+money;
		System.out.println("Total amount in bank"+amount);
		que.dequeue();
	}
	/**
	 * Function to collect choice from user and perform respective task.
	 */
	public static void cashCounter() {
		Random rand=new Random();
		Integer size=rand.nextInt(5);
		if(size>0) {
			Queue que=new Queue(size);
			for (int i = 1; i <=size ; i++) {
				que.enqueue(i);
			}
			for (int i = 0; i < que.size(); i++) {
			System.out.println("Press 1 to deposit money.");
			System.out.println("Press 2 to withdraw money.");
			int choice =Utility.scanInt();
			
			switch (choice) {
			case 1:
					System.out.println("Enter the amount to deposit");
					double money=Utility.scanDouble();
					System.out.println("Adding your money to your account.");
					if(money>0) {
					deposit(que, money);
					}
				break;
			case 2:
				System.out.println("Enter the amount to deposit");
				double money1=Utility.scanDouble();
				System.out.println("Adding your money to your account.");
				withdraw(que, money1);
				break;

			default:
				break;
			}
		}
		}
	}
	
	public static void main(String[] args) {
		cashCounter();
	}

}
