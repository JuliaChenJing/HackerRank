package datastructure.queue;

public class LinkedListQueue {
	Node first, back;
	int count;

	public static void main(String[] args) {
		LinkedListQueue s = new LinkedListQueue();
		Node a = new Node(1);
		s.first = a;
		s.back = a;
		s.enqueue(2);
		s.enqueue(3);
		System.out.println(s.toString() + "      count: " + (s.count + 1));
		s.dequeue();
		System.out.println(s.toString() + "      count: " + (s.count + 1));
		s.enqueue(4);
		s.dequeue();
		s.enqueue(5);
		System.out.println(s.toString() + "      count: " + (s.count + 1));
	}

	void enqueue(int item) {
		if (first == null) {
			back = new Node(item);
			first = back;
		} else {
			back.next = new Node(item);
			back = back.next;
		}
		count++;
	}

	Node dequeue() {
		if (first != null) {
			Node item = first;
			first = first.next;
			count--;
			return item;
		}

		return null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public Object peek() {
		return first.data;
	}

	@Override
	public String toString() {
		String re = "first";
		Node n = first;
		while (n != null) {
			re += "-->" + n.data;
			n = n.next;
		}

		re += "-->last";

		return re;
	}

	public int size() {
		return count;
	}

}

class Node {
	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null)
			n = n.next;
		n.next = end;
	}

}
