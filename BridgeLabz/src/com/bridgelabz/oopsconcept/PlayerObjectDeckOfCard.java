package com.bridgelabz.oopsconcept;

import java.util.Arrays;
import java.util.Random;

import com.bridgelabz.datastructure.QueueLinkedList;
import com.bridgelabz.datastructure.SinglyLinkedList;
/**
 * Purpose: Shuffle the card and distribute the cards among 4 players,
 * store the cards in queue and display cards of each.
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :19-05-2018
 */
public class PlayerObjectDeckOfCard {
	
	/**
	 * Function to create player object and sort them according to rank.
	 * @return ShuffledList
	 */
	public static SinglyLinkedList[][] playerObject(){
		
		SinglyLinkedList[][] shuffledlist=DeckOfCard.cards();
		String [] player1=new String[9];
		String [] player2=new String[9];
		String [] player3=new String[9];
		String [] player4=new String[9];
		QueueLinkedList[][] sortedCards=new QueueLinkedList[4][];
		
		for (int i = 0; i < 4; i++) {
			sortedCards[i]=new QueueLinkedList[9];
			for (int k = 0; k < 9; k++) {
				sortedCards[i][k]=new QueueLinkedList();
			}
		}
			
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 9; j++) {
				if (i==0) {
					player1[j]=(String) shuffledlist[i][j].removeFirst();
				}
				else if(i==1) {
					player2[j]=(String) shuffledlist[i][j].removeFirst();
				}
				else if(i==2) {
					player3[j]=(String) shuffledlist[i][j].removeFirst();
				}
				else {
					player4[j]=(String) shuffledlist[i][j].removeFirst();;
				}
			}
		}
		//Sorting done of all player's card.
		System.out.println();
		Arrays.sort(player1);
		Arrays.sort(player2);
		Arrays.sort(player3);
		Arrays.sort(player4);
		
		//loop to store sorted cards inside queue.
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 9; j++) {
					if (i==0) {
						sortedCards[i][j].enqueue(player1[j]);
					}
					else if(i==1) {
						sortedCards[i][j].enqueue(player2[j]);
					}
					else if(i==2) {
						sortedCards[i][j].enqueue(player3[j]);
					}
					else {
						sortedCards[i][j].enqueue(player4[j]);
					}
				}
			}
		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < 9; k++) {
				sortedCards[i][k].display3();
			}
			System.out.println();
		}
		return shuffledlist;
		
	}
	public static void main(String []args) {
		playerObject();
	}
}
