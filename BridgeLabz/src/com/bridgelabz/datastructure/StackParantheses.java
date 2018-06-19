package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class StackParantheses {
    public static void main(String[] args)
        {
            boolean result=false;
            System.out.println("Enter arithmatic expression");
            String str = Utility.scanString();
            if(str.length()==0)
            {
                System.out.println("Plz.. Enter the expression.");
            }
            else
            {   
                result = checkValidExpression(str);
                if(result == true)
                {
                    System.out.println("True!! It is valid expression.");
                }
                else
                {
                    System.out.println("False!! it is not valid expression");
               
                }
            }
        }
    public static boolean checkValidExpression(String str) {
        int count = 0;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                Stack.push(str.charAt(i));
                count++;
            }

            if (str.charAt(i) == ')') {
                if (Stack.isEmpty()) {
                    count--;
                } else {
                    stack.pop();
                    count--;
                }
            }
        }
        if (Stack.isEmpty() && count == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
