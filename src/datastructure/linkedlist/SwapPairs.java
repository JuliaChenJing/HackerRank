package datastructure.linkedlist;

//https://leetcode.com/problems/swap-nodes-in-pairs/description/
public class SwapPairs {
	/*
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * 
	 * Your algorithm should use only constant space. You may not modify the
	 * values in the list, only nodes itself can be changed.
	 */
	public static Node swapPairs(Node head) {
		if ((head == null) || (head.next == null))
			return head;
		Node n = head.next;
		head.next = swapPairs(head.next.next);
		n.next = head;
		return n;
	}

	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(5);
		Node d = new Node(0);
		Node e = new Node(3);
		Node f = new Node(8);
		a.next = b;
		b.next = c;

		c.next = d;
		d.next = e;
		e.next = f;
		Node n = a;
		System.out.println("BEFORE: ");
		while (n != null) {
			System.out.print(n.data + "--->");
			n = n.next;
		}
		System.out.println();

		n = swapPairs(a);

		System.out.println("\nAFTER: ");
		while (n != null) {
			System.out.print(n.data + "--->");
			n = n.next;
		}

	}
}
