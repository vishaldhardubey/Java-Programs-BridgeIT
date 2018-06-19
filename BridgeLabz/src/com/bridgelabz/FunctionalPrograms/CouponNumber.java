/**
 * Purpose: Determines the distinct coupon number.
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :16-05-2018
 */
package com.bridgelabz.FunctionalPrograms;
import com.bridgelabz.utility.Utility;

/**
 * @author administrator
 * Purpose: Determines the distinct coupon number.
 */
public class CouponNumber {
	 // Main Function to call Coupon function.
	public static void main(String[] args) {
		System.out.println("Enter coupon number you want to find.");
		int aCouponNumber=Utility.scanInt();
		// Calling function randomNumberCoupon.
		Utility.randomNumberCoupon(aCouponNumber);
	}
}
