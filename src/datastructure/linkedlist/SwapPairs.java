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

	public static Node swapPairs(Node head) {
		if ((head == null) || (head.next == null))
			return head;
		Node n = head.next;
		head.next = swapPairs(head.next.next);
		n.next = head;
		return n;
	}

	// https://leetcode.com/problems/reverse-nodes-in-k-group/description/
	/*
	 * Given a linked list, reverse the nodes of a linked list k at a time and
	 * return its modified list.
	 * 
	 * k is a positive integer and is less than or equal to the length of the
	 * linked list. If the number of nodes is not a multiple of k then left-out
	 * nodes in the end should remain as it is.
	 * 
	 * You may not alter the values in the nodes, only nodes itself may be
	 * changed.
	 * 
	 * Only constant memory is allowed.
	 * 
	 * For example, Given this linked list: 1->2->3->4->5
	 * 
	 * For k = 2, you should return: 2->1->4->3->5
	 * 
	 * For k = 3, you should return: 3->2->1->4->5
	 */
	public Node reverseKGroup(Node head, int k) {
		Node curr = head;
		int count = 0;
		while (curr != null && count != k) { // find the k+1 node
			curr = curr.next;
			count++;
		}
		if (count == k) { // if k+1 node is found
			curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
			// head - head-pointer to direct part,
			// curr - head-pointer to reversed part;
			while (count-- > 0) { // reverse current k-group:
				Node tmp = head.next; // tmp - next head in direct part
				head.next = curr; // preappending "direct" head to the reversed
									// list
				curr = head; // move head of reversed part to a new node
				head = tmp; // move "direct" head to the next node in direct
							// part
			}
			head = curr;
		}
		return head;
	}

}
