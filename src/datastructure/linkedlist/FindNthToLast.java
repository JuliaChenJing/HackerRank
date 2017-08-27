package datastructure.linkedlist;

// Implement an algorithm to find the nth to last element of a singly linked list
public class FindNthToLast {
	/*
	 * Note: This problem screams recursion, but we’ll do it a different way
	 * because it’s trickier. In a question like this, expect follow up
	 * questions about the advantages of recursion vs iteration.
	 */

	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
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
		System.out.println("the value of the 2th to last: ");
		// Node re = findNthFromEnd(a, 2);
		Node re = nthToLast(a, 2);

		System.out.println(re.data);

		System.out.println("AFTER remove the 2th to last element: ");
		// re=removeNthFromEnd(a,2);
		re = removeNthToLast(a, 2);
		n = re;
		while (n != null) {
			System.out.print(n.data + "--->");
			n = n.next;
		}

	}

	// 我自己想的
	public static Node findNthFromEnd(Node head, int N) {

		if (head == null)
			return null;
		int length = 0;
		Node n = head;
		Node re = null;
		while (n != null) {
			n = n.next;
			length++;

		}

		// System.out.println("length=" + length);

		if (length < N)
			return null;
		int j = 0;
		Node m = head;
		while (j < length - N) {
			re = m.next;
			j++;
			m = m.next;
		}

		return re;
	}

	public static Node removeNthFromEnd(Node head, int n) {
		if (head == null)
			return null;
		Node node = head;
		Node next = node.next;
		int length = 0;
		while (node != null) {
			length++;
			node = node.next;
		}
		node = head;

		for (int i = 1; i < length - n; i++) {
			node = node.next;
		}
		next = node.next;
		node.next = next.next;
		return head;

	}

	/*
	 * Assumption: The minimum number of nodes in list is n.
	 * 
	 * 
	 * Algorithm: 1.Create two pointers, p1 and p2, then point to the beginning
	 * of the node.
	 * 
	 * 2. Increment p2 by n-1 positions, to make it point to the nth node from
	 * the beginning (to make the distance of n between p1 and p2).
	 * 
	 * 3. Check for p2->next == null if yes return value of p1, otherwise
	 * increment p1 and p2. If next of p2 is null it means p1 points to the nth
	 * node from the last as the distance between the two is n.
	 * 
	 * 4. Repeat Step 3.
	 */

	static Node nthToLast(Node head, int n) {
		if (head == null || n < 1) {
			return null;
		}
		Node p1 = head;
		Node p2 = head;

		for (int j = 0; j < n - 1; ++j) {
			if (p2 == null) {
				return null; // list size < n
			}
			p2 = p2.next;
		}

		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	public static Node removeNthToLast(Node head, int n) {

		Node start = new Node(0);
		Node slow = start, fast = start;
		slow.next = head;

		// Move fast in front so that the gap between slow and fast becomes n
		for (int i = 1; i <= n + 1; i++) {
			fast = fast.next;
		}
		// Move fast to the end, maintaining the gap
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		// Skip the desired node
		slow.next = slow.next.next;
		return start.next;

	}

}
