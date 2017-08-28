package datastructure.linkedlist;

import java.util.ArrayList;

//https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
public class MergeTwoSortedLinkedList {

	/*
	 * Merge two linked lists head pointer input could be NULL as well for empty
	 * list Node is defined as class Node { int data; Node next; }
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

		d.next = e;
		e.next = f;
		Node n = a;
		System.out.println("BEFORE: ");
		while (n != null) {
			System.out.print(n.data + "--->");
			n = n.next;
		}
		System.out.println();
		n = d;
		while (n != null) {
			System.out.print(n.data + "--->");
			n = n.next;
		}

		// n = mergeLists(a, d);
		// n = merge(a, d);

		Node[] list = new Node[2];
		list[0] = a;
		list[1] = d;
		n = mergeKLists(list);
		
		System.out.println("\nAFTER: ");
		while (n != null) {
			System.out.print(n.data + "--->");
			n = n.next;
		}

	}

	// good
	public static Node merge(Node l1, Node l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.data < l2.data) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}

	static Node mergeLists(Node currA, Node currB) {

		if (currA == null) {
			return currB;
		} else if (currB == null) {
			return currA;
		}

		/* Find new head pointer */
		Node head = null;
		if (currA.data < currB.data) {
			head = currA;
			currA = currA.next;
		} else {
			head = currB;
			currB = currB.next;
		}

		/* Build rest of list */
		Node n = head;
		while (currA != null && currB != null) {
			if (currA.data < currB.data) {
				n.next = currA;
				currA = currA.next;
			} else {
				n.next = currB;
				currB = currB.next;
			}
			n = n.next;
		}

		/* Attach the remaining elements */
		if (currA == null) {
			n.next = currB;
		} else {
			n.next = currA;
		}

		return head;
	}

	public static Node mergeKLists(Node[] lists) {
		return partion(lists, 0, lists.length - 1);
	}

	public static Node partion(Node[] lists, int s, int e) {
		if (s == e)
			return lists[s];
		if (s < e) {
			int q = (s + e) / 2;
			Node l1 = partion(lists, s, q);
			Node l2 = partion(lists, q + 1, e);
			return merge(l1, l2);
		} else
			return null;
	}

}
