/**
 * Purpose: Determines Percentage of Head and Tails.
 *
 *  @author  Vishal Dhar Dubey
 *  @version 1.0
 *  @since   16-05-2018
 */

package com.bridgelabz.FunctionalPrograms;
import com.bridgelabz.utility.Utility;

/**
 * @author administrator
 * Purpose: Determines Percentage of Head and Tails.
 */
public class FlipCoin{
    public static void main(String[] args) {
    	System.out.println("Enter the number for how many times you want to flip the coin: ");
        int chances = Utility.scanInt();
		Utility.flipcoin(chances);
      }
}

