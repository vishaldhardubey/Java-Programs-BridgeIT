package com.bridgelabz.FunctionalPrograms;

import java.util.Random;
import com.bridgelabz.utility.Utility;

/***
 * Purpose: Determines distinct value in an array whose sum is equals to zero.
 *
 *  @author  Vishal Dhar Dubey
 *  @version 1.0
 *  @since   16-05-2018
 */
public class TicTacToe {
	/**
	* Function to determine winner.
	* @param 2D array
	*/
	public static final boolean winner(char[][] arr) {
		if(arr[0][0]=='X'&&arr[0][1]=='X'&&arr[0][2]=='X')
		{
			System.out.println("Player 1 is winner");
			return true;
		}
		else if(arr[1][0]=='X'&&arr[1][1]=='X'&&arr[1][2]=='X')
		{
			System.out.println("Player 1 is winner");
			return true;
		}
		else if(arr[2][0]=='X'&&arr[2][1]=='X'&&arr[2][2]=='X')
		{
			System.out.println("Player 1 is winner");
			return true;
		}
		else if(arr[0][0]=='X'&&arr[1][0]=='X'&&arr[2][0]=='X')
		{
			System.out.println("Player 1 is winner");
			return true;
		}
		else if(arr[0][1]=='X'&&arr[1][1]=='X'&&arr[2][1]=='X')
		{
			System.out.println("Player 1 is winner");
			return true;
		}
		else if(arr[0][2]=='X'&&arr[1][2]=='X'&&arr[2][2]=='X')
		{
			System.out.println("Player 1 is winner");
			return true;
		}
		else if(arr[0][0]=='X'&&arr[1][1]=='X'&&arr[2][2]=='X')
		{
			System.out.println("Player 1 is winner");
			return true;
		}
		else if(arr[0][2]=='X'&&arr[1][1]=='X'&&arr[2][0]=='X')
		{
			System.out.println("Player 1 is winner");
			return true;
		}
		return false;
	}
	/**
	* Function to determine winner.
	* @param 2D array
	*/
	public static final boolean winner1(char[][] arr) {
		if(arr[0][0]=='O'&&arr[0][1]=='O'&&arr[0][2]=='O')
		{
			System.out.println("Computer is winner");
			return true;
		}
		else if(arr[1][0]=='O'&&arr[1][1]=='O'&&arr[1][2]=='O')
		{
			System.out.println("Computer is winner");
			return true;
		}
		else if(arr[2][0]=='O'&&arr[2][1]=='O'&&arr[2][2]=='O')
		{
			System.out.println("Computer is winner");
			return true;
		}
		else if(arr[0][0]=='O'&&arr[1][0]=='O'&&arr[2][0]=='O')
		{
			System.out.println("Computer is winner");
			return true;
		}
		else if(arr[0][1]=='O'&&arr[1][1]=='O'&&arr[2][1]=='O')
		{
			System.out.println("Computer is winner");
			return true;
		}
		else if(arr[0][2]=='O'&&arr[1][2]=='O'&&arr[2][2]=='O')
		{
			System.out.println("Computer is winner");
			return true;
		}
		else if(arr[0][0]=='O'&&arr[1][1]=='O'&&arr[2][2]=='O')
		{
			System.out.println("Computer is winner");
			return true;
		}
		else if(arr[0][2]=='O'&&arr[1][1]=='O'&&arr[2][0]=='O')
		{
			System.out.println("Computer is winner");
			return true;
		}
		return false;
	}
    public static void main(String[] args) {
        char [][]arr=new char[3][3];
        int count =0;
        boolean playerWin=false;
        boolean compWin=false;
        while(count<9) {
        //User
        	if(count!=9&& playerWin==false) {
            int flag=0;
            while(flag==0) {
        System.out.println("Enter the row and col to mark your choice");
        int userRow=Utility.scanInt();
        int userCol=Utility.scanInt();
            if(arr[userRow][userCol]!='O'&&arr[userRow][userCol]!='X') {
                    arr[userRow][userCol]='X';
                    System.out.println("arr["+userRow+"]"+"["+userCol+"]"+arr[userRow][userCol]);
                    count++;
                    flag=1;
               playerWin=winner(arr);
                }
            }
        }
        	
        if(count!=9) {
        //computer
        int flag1=0;
        while(flag1==0) {
        Random rand=new Random();
        int compRow=rand.nextInt(3);
        int compCol=rand.nextInt(3);
        if(arr[compRow][compCol]!='X'&&arr[compRow][compCol]!='O') {
            arr[compRow][compCol]='O';
            System.out.println("arr["+compRow+"]"+"["+compCol+"]"+arr[compRow][compCol]);
            count++;
            flag1=1;
            compWin=winner1(arr);
            }    
        }	
        }
    }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}



