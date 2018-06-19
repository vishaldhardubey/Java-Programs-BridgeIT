package com.bridgelabz.datastructure;

public class Deque <T>{
	Node<T> front,rear;
	int size=0;
	/**
	 * Function to add element in the Queue.
	 * @param data
	 */
	
	public void addFront(Comparable data) {
		 Node n1=new Node(data);
		 n1.next=front;
		 front=n1;
		 size++;
	 }
	/**
	 * Function to remove element from front
	 * @return data
	 */
	public Comparable removeFront() {
		if(front==null) {
			return "Empty Queue";
		}
		T data = front.data;
			front=front.next;
			if(front==null) {
				rear=null;
			}
			size--;
		return (Comparable) data;
	}
	
	/**
	 * Function to remove element from rear
	 * @return data
	 */
	public Comparable<T> removeRear() {
		Node temp=front;
		while(temp.next!=rear) {
			temp=temp.next;
		}
		rear=temp;
		rear.next=null;
		size--;
		return (Comparable) rear.data;
	}
	
	/**
	 * Function to check whether list is empty or not. 
	 */
	public void isEmpty() {
		if(front==null&&rear==null) {
			System.out.println("Deque is empty");
		}
	}
	
	/**
	 * Function to return size of deque.
	 * @return size
	 */
	public int size() {
		return size; 
	}
	/**
	 * Function to display elements of deque.
	 */
	public void display() {
			 if(size==0) {
				 System.out.println("Empty");
				 return;
			 }
			 Node temp=front;
			 System.out.println("Data : "+temp.data);
			 temp=temp.next;
	}
	
}
