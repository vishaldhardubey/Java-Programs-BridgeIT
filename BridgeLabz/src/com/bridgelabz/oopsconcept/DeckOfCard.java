package com.bridgelabz.oopsconcept;

import java.util.Random;

import com.bridgelabz.datastructure.SinglyLinkedList;
/**
 * Purpose: Shuffle the card and distribute the cards among 4 players and display cards of each.
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :19-05-2018
 */
public class DeckOfCard {
	
	static String [] CARDRANK= {"2-Club","3-Club","4-Club","5-Club","6-Club","7-Club","8-Club","9-Club","10-Club","Jack-Club","Queen-Club","King-Club","Ace-Club"
							,"2-Diamond","3-Diamond","4-Diamond","5-Diamond","6-Diamond","7-Diamond","8-Diamond","9-Diamond","10-Diamond","Jack-Diamond","Queen-Diamond","King-Diamond","Ace-Diamond"
							,"2-Heart","3-Heart","4-Heart","5-Heart","6-Heart","7-Heart","8-Heart","9-Heart","10-Heart","Jack-Heart","Queen-Heart","King-Heart","Ace-Heart"
							,"2-Spade","3-Spade","4-Spade","5-Spade","6-Spade","7-Spade","8-Spade","9-Spade","10-Spade","Jack-Spade","Queen-Spade","King-Spade","Ace-Spade"};
	static String [] SUIT= {"Club","Diamond","Heart","Spade"};
	
	/**
	 * Function to Shuffle the cards and store them in 2D array of linked list.
	 * @return SinglyLinkedList 2D array.
	 */
	public static SinglyLinkedList[][] cards() {
		
		Random rand=new Random();
		//SinglyLinkedList Array Creation and making it linked list.
		SinglyLinkedList [][] shuffledList=new SinglyLinkedList[4][];
		for (int i = 0; i < 4; i++) {
			shuffledList[i]=new SinglyLinkedList[9];
			for (int j = 0; j < 9; j++) {
				shuffledList[i][j]=new SinglyLinkedList();
			}
		}
		for(int i=0;i<52;i++) {
			int shuffleValue=rand.nextInt(52);
			for (int i1 = 0; i1 < CARDRANK.length; i1++) {
				String temp= CARDRANK[shuffleValue];
				CARDRANK[shuffleValue]=CARDRANK[i1];
				CARDRANK[i1]=temp;
			}
		}
		
		int pos=0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 9; j++) {
				shuffledList[i][j].addFirst(CARDRANK[pos]);
				pos++;
			}
		}
		return shuffledList;
	}
	public static void main(String[] args) {
		SinglyLinkedList [][] shuffledList=cards();
		for (int i = 0; i < shuffledList.length; i++) {
			for (int j = 0; j < 9; j++) {
				shuffledList[i][j].display1();
			}
			System.out.println();
		}
	}

}
