package datastructure.linkedlist;

/*
 *   You have two numbers represented by a linked list, where each node contains a single digit. 
 *   The digits are stored in reverse order, such that the 1’s digit is at the head of
the list. Write a function that adds the two numbers and returns the sum as a linked
list.
EXAMPLE
Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
Output: 8 -> 0 -> 8
 */

//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {

	public static Node addTwoNumbers(Node head1, Node head2) {

		Node a = head1;
		Node b = head2;

		Node head = null;

		int carry = 0;
		int sum = 0;

		if (head1 != null && head2 != null) {

			sum = a.data + b.data;
			carry = sum / 10;
			head = new Node(sum % 10);
			Node n = head;
			sum = 0;

			while (a.next != null && b.next != null) {
				a = a.next;
				b = b.next;
				sum = a.data + b.data + carry;
				carry = sum / 10;
				n.next = new Node(sum % 10);
				n = n.next;
			}

			while (a.next != null) {
				a = a.next;
				sum = a.data + carry;
				carry = sum / 10;
				n.next = new Node(sum % 10);
				n = n.next;
			}

			while (b.next != null) {
				b = b.next;
				sum = b.data + carry;
				carry = sum / 10;
				n.next = new Node(sum % 10);
				n = n.next;
			}

			if (carry != 0)
				n.next = new Node(carry);
		}
		return head;

	}

	public static void main(String[] args) {
		Node a = new Node(3);
		Node b = new Node(1);
		Node c = new Node(3);
		Node g = new Node(2);
		Node h=new Node(1);

		Node d = new Node(7);
		Node e = new Node(9);
		Node f = new Node(6);

		a.next = b;
		b.next = c;
		c.next = g;
		g.next=h;

		d.next = e;
		e.next = f;

		Node n = a;

		System.out.println("\nTHE FIRST LINKED LIST: ");
		while (n != null) {
			System.out.print(n.data + "--->");
			n = n.next;
		}
		System.out.println("\nTHE SECEND LINKED LIST: ");
		n = d;
		while (n != null) {
			System.out.print(n.data + "--->");
			n = n.next;
		}

		System.out.println("\nTHE RESULT LINKED LIST: ");
		n = addTwoNumbers(a, d);
		while (n != null) {
			System.out.print(n.data + "--->");
			n = n.next;
		}
	}
}
