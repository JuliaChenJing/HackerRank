package datastructure.linkedlist;

public class SwapKthNodesInLinkedList {

	/*
	 * Given a linked list, swap the kth node counted from the beginning with
	 * the kth node counted from the end of the linked list.
	 * 
	 * Note: You may assume 1 <= k <= length of list.
	 * 
	 * 
	 */

	/*
	 * Example 1: Input:
	 * 
	 * 1->2->3->4->5->NULL, k = 2 Output:
	 * 
	 * 1->4->3->2->5->NULL
	 * 
	 * 
	 * Example 2: Input:
	 * 
	 * 1->2->3->4->5->6->NULL, k = 4 Output:
	 * 
	 * 1->2->4->3->5->6->NULL
	 */
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;

		ListNode newHead = swapNodes_II(a, 2);
		while (newHead != null) {
			System.out.print(newHead.val + "---->");
			newHead = newHead.next;
		}
	}

	public static ListNode swapNodes_I(ListNode head, int k) {
		ListNode headtrack = head;

		int length = 0;
		while (head.next != null) {
			head = head.next;
			length++;
		}

		head = headtrack;
		for (int i = 0; i < k - 1; i++) {
			head = head.next;

		}

		ListNode targetA = head;

		for (int i = 0; i < length - 2 * k + 2; i++) {
			head = head.next;

		}

		ListNode targetB = head;
		/*
		 * * Notice: You are only allowed to modify the linked list node's
		 * reference. DO NOT modify the node's value, otherwise your solution
		 * will be disqualified.
		 */

		int temp = targetA.val;
		targetA.val = targetB.val;

		targetB.val = temp;

		return headtrack;

	}

	public static ListNode swapNodes_II(ListNode head, int k) {
		ListNode headtrack = head;

		int length = 0;
		while (head.next != null) {
			head = head.next;
			length++;
		}

		head = headtrack;
		for (int i = 0; i < k - 2; i++) {
			head = head.next;

		}

		ListNode targetAPre = head;
		ListNode targetA = head.next;
		head = head.next;

		for (int i = 0; i < length - 2 * k + 1; i++) {
			head = head.next;

		}

		ListNode targetBPre = head;
		ListNode targetB = head.next;

		ListNode temp = targetA.next;
		targetAPre.next = targetB;
		targetBPre.next = targetA;
		targetA.next = targetB.next;
		targetB.next = temp;

		return headtrack;

	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
