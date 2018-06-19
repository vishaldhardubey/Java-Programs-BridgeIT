package com.bridgelabz.datastructure;
/**
 *  Purpose: Implementation of Queue using linked list.
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :26-05-2018
 */
public class QueueLinkedList<T> {
	Node<T> front,rear;
	int size;
	
	/**
	 * Function is to enqueue data inside queue linked list.
	 * @param data
	 */
	public void enqueue(T data)
	{
		Node n1 = new Node(data);
		if(front==null && rear ==null)
		{
			front = n1;
			rear = n1;
			size++;
			return;
		}
		Node t = rear;
		while(t.next!=null)
		{
			t = t.next;
		}
			t.next = n1;
			rear = t;
			size++;
		}
		/**
		 * Function is to dequeue element from queue.
		 * @return data
		 */
		public Object dequeue(){
			if(front == null)
			{
				return "queue empty";
			}
			Object data = front.data;
			front = front.next;
				if(front == null)
				{
					rear = null;
				}
			size--;
			return data;
		}
		public void display() {
			 if(size==0) {
				 System.out.println("Empty");
				 return;
			 }
			 Node temp=front;
			 while(temp!=null) {
				 System.out.println("Data : "+temp.data);
				 temp=(Node) temp.next;
			 }
		 }
		
		public void display1(int data) {
			 Node temp=front;
			 for (int i = 0; i <data; i++) {
			 System.out.print(temp.data+" ");
				 temp=(Node) temp.next;
			 }
		 }
		
	/**
	 * Function used in deck of cards using QueueLinkedList
	 */
		public void display3() {
			 
			 Node temp=front;
			 while(temp!=null) {
				 System.out.print(" "+temp.data);
				 temp=(Node) temp.next;
			 }
		 }
		
	/**
	 * Function is to sort given array.
	 * @param array
	 * @return sorted array
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
		public QueueLinkedList[] sort1(QueueLinkedList[] player1) {
			if(size>1) {
				for (int i = 0; i < size; i++) {
					Node currentNode=front;
					Node forward=front.next;
					for (int j = 0; j < size-1; j++) {
						Comparable temp= (Comparable) currentNode.data;
						currentNode.data=forward.data;
						forward.data=temp;
					}
					currentNode=forward;
					forward=forward.next;
				}
			}
			return player1;
		}
		@Override
		public String toString() {
			Node t = front;
			String st="";
			while(t!=null){
				st = st+t.data+", ";
				t = t.next;
			}
			return "["+st+"]";
			}
		}
