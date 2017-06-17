package datastructure.linkedlist;

//https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem
public class PrintInReverse {
	/*
	  Insert Node at the end of a linked list 
	  head pointer input could be NULL as well for empty list
	  Node is defined as 
	  class Node {
	     int data;
	     Node next;
	  }
	*/
	  
	static void ReversePrint(Node head)
	{
	    if (head != null)
	    {
	        ReversePrint(head.next);
	        System.out.println(head.data);
	    }
	}
	
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);

		a.next = b;
		b.next = c;
		c.next = d;
		ReversePrint(a);
	}

}
