/**
 * Purpose: Implementation class for linked list and Nodes.
 *
 *  @author  :Vishal Dhar Dubey.
 *  @version :1.0
 *  @since   :23-05-2018
 */
package com.bridgelabz.datastructure;

public class SinglyLinkedList<T>{
		
		 public Node head=null;
		 public int size=0;
		 
		 /**
		  * Function to return new empty list.
		  */
		 public SinglyLinkedList<T> list() {
			 SinglyLinkedList<T> list=new SinglyLinkedList<T>();
			 return list;
		 }
		 
		 /**
		  * Function to add data in the linked list.
		  * @param data which id to be added.
		  */
		 public Comparable add(T data) {
			 Node n1=new Node(data);
			 if(head==null) {
				 head=n1;
				 size++;
				 return (Comparable) head.data;
			 }
			 Node temp=head;
			 while(temp.next!=null) {
				 temp=(Node) temp.next;
			 }
			 temp.next=n1;
			 size++;
			return (Comparable) data;
		 }
		 
		 /**
		  * Function to add data in the linked list at First position.
		  * @param data which id to be added.
		  */
		 public void addFirst(Comparable data) {
			 Node n1=new Node(data);
			 n1.next=head;
			 head=n1;
			 size++;
		 }
		 
		 /**
		  * Function to display data.
		  * @param data which id to be added.
		  */
		 public void display() {
			 if(size==0) {
				 System.out.println("Empty");
				 return;
			 }
			 Node temp=head;
			 while(temp!=null) {
				 System.out.println("Data : "+temp.data);
				 temp=(Node) temp.next;
			 }
		 }
		 public void addAt(Comparable data, int index) {
			 if(index==0) {
				 addFirst(data);
				 return;
			 }
			 Node n1=new Node(data);
			 int count=0;
			 Node temp=head;
			 while(count<index-1) {
				 temp=(Node)temp.next;
				 count++;
			 }
			 n1.next=temp.next;
			 temp.next=n1;
			 size++;
		 }
		 public int size() {
			 return size;
		 }
		 public boolean isEmpty() {
			 return size==0;
		 }
		 public Object removeAt(int index) {
			 if(index==0) {
				 Object temp=head.data;
				 head=(Node)head.next;
				 size--;
				 return temp;
			 }
			 Node t=head;
			 int count=0;
			 while(count<index-1) {
				 t=(Node)t.next;
				 count++;
			 }
			 Object temp=t.next.data;
			 t.next=t.next.next;
			 size--;
			 return temp;
		 }
		 public T removeFirst() {
			 T temp=(T) head.data;
			 head=(Node)head.next;
			 size--;
			 return temp;
		 }
		
		 public void reverse(Node start) {
			 if(start.next!=null) {
				 reverse(start.next);
			 }
		 }
		 /**
		  * Function to display reverse of linked list.
		  */
		 
		 public void reverse() {
			 reverse(head);
		 }
		 /**
		  * Function to display mid element.
		  */
		 public void displayMid() {
			 Node mid=head;
			 int count=0;
			 while(count!=size/2) {
				 mid=mid.next;
				 count++;
			 }
			 System.out.println(mid.data);
		 }
		 /**
		  * Function to search data in the linked list.
		  * @param data
		  * @return index
		  */
		 public int search(T data) {
			 if(head.data.equals(data)) {
				 return 0;
			 }
			 Node temp=head;
			 int count=0;
			 while(temp.next!=null) {
				 temp=temp.next;
				 count++;
				 if(temp.data.equals(data)) {
					 System.out.println("word is present at : "+count);
					 return count;
				 }
			 }
			return -1; 
		 }
		 
	 /**
	  * Function to sort the element of linked list.
	  * @param linked list.
	 * @return 
	  */
		 
		 public Comparable<T>[] sort(Comparable<T>[] array){
			 for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if(array[i].compareTo((T)array[j])>0) {
						Comparable<T> temp = array[j];
						array[j]=array[i];
						array[i]=temp;
					}
				}
			}
			return array;
		 }
		 
		 public void display1() {
			 /*if(size==0) {
				 System.out.println("Empty");
				 return;
			 }*/
			 Node temp=head;
			 while(temp!=null) {
				 System.out.print(temp.data+" ");
				 temp=(Node) temp.next;
			 }
		 }
		 public void display2() {
			 if(size==0) {
				 System.out.println(" Null");
				 return;
			 }
			 Node temp=head;
			 while(temp!=null) { 
				 System.out.print(" "+temp.data+" ");
				 temp=(Node) temp.next;
			 }
			 System.out.println();
		 }
		 
		 
	 
		 
}	
