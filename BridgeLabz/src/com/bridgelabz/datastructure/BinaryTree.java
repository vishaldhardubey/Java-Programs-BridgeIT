package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;
/**
 * Purpose: Determine how many binary tree can be formed .
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :19-05-2018
 */
public class BinaryTree {

	public static void main(String[] args) {
				int N = 0;
		        System.out.println("Enter number of test cases");
		        N = Utility.scanInt();
		        System.out.println("no of binary trees possible" + " " + treeCount(N));
		    }

		    /**
		     * Function is to count the number of tree.
		     * @param number
		     * @return intsum
		     */
		    public static int treeCount(int number) {
		        int intsum = 0;
		        if (number == 0 || number == 1) {
		            return 1;
		        } else if (number == 2) {
		            return 2;
		        } else {
		            for (int i = 0; i < number; i++) {
		                intsum = intsum + treeCount(i) * treeCount(number - i - 1);
		            }
		            return intsum;
		        }
		    }
}
