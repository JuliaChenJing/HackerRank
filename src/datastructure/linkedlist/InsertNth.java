package datastructure.linkedlist;

/*
 * https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list
 */
public class InsertNth {

	Node insertNth(Node head, int data, int position) {
		
		// Will Need to Return Head Node
		Node trackedHeadNode = head;

		Node nodeToInsert = new Node(data);

		// 1 Empty List - just return newly created node 
		if (head == null) {
			return nodeToInsert;
		}

		// 2 Inserting a Node ahead of the List
		if (position == 0) {
			nodeToInsert.next = head;
			return nodeToInsert;
		}

		// Traverse the Singly Linked List to 1 Position Prior
		// Stop traversing if you reached the end of the List
		int currPosition = 0;

		while (currPosition < position - 1 && head.next != null) {
			head = head.next;
			currPosition++;
		}

		// Inserting a Node in-between a List or at the end of of a List
		 nodeToInsert.next =  head.next;
	         head.next = nodeToInsert;
	  
		return trackedHeadNode;
	}
}
