package datastructure.linkedlist;


public class DeleteNode {
	
	/*
	 *  Implement an algorithm to delete a node in the middle of a single linked list, given
	    only access to that node.

	     EXAMPLE
	     Input: the node  from the linked list a->b->c->d->e
	     Result: nothing is returned, but the new linked list looks like a->b->d->e
	
	 * The solution to this is to simply copy the data from the next node into
	 * this node and then delete the next node.
	 * 
	 * NOTE: This problem can not be solved if the node to be deleted is the
	 * last node in the linked list. Your interviewer wants to see
	 * you point that out. You could consider marking it as dummy in that case.
	 * This is an issue you should discuss with your interviewer.
	 */

	public static boolean deleteNode(Node n) {
		if (n == null || n.next == null) {
			return false; // Failure
		}
		Node nextNode = n.next;
		n.data = nextNode.data;
		n.next = nextNode.next;
		return true;
	}

	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);

		a.next = b;
		b.next = c;
		c.next = d;

		Node n = a;
		System.out.println("BEFORE: ");
		while (n != null) {
			System.out.print(n.data + "--->");
			n = n.next;
		}

		deleteNode(c);

		System.out.println("\nAFTER: ");
		n = a;
		while (n != null) {
			System.out.print(n.data + "--->");
			n = n.next;
		}

	}

	/*
	 * Delete Node at a given position in a linked list head pointer input could
	 * be NULL as well for empty list Node is defined as class Node { int data;
	 * Node next; }
	 */


	Node Delete(Node head, int position) {
		// Complete this method
		Node trackedHeadNode = head;

		if (head == null)
			return head;
		if (head.next == null && position == 0) {
			head = null;
			return head;
		}
		if (position == 0) {
			head = head.next;
			return head;
		}

		for (int i = 0; i < position - 1; i++) {
			head = head.next;
		}

		head.next = head.next.next;

		return trackedHeadNode;

	}

}
