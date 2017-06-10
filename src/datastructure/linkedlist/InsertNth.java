package datastructure.linkedlist;

/*
 * https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list
 */
public class InsertNth {

	/*
	 * Sample Input
	 * 
	 * NULL, data = 3, position = 0 3 --> NULL, data = 4, position = 0
	 * 
	 * Sample Output
	 * 
	 * 3 --> NULL 4 --> 3 --> NULL
	 */

	Node insertNth(Node head, int data, int position) {
		// Will Need to Return Head Node
		Node trackedHeadNode = head;

		Node nodeToInsert = new Node(data);

		// Empty List - Returned newly created node or null
		if (head == null) {
			return nodeToInsert;
		}

		// Inserting a Node ahead of the List
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
		Node nodeAtPosition = head.next;
		head.next = nodeToInsert;
		head = head.next;
		head.next = nodeAtPosition;

		return trackedHeadNode;
	}
}
