package datstructure.linkedlist;

class Node {
	
	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}

	//add a Node to the tail
	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	//delete a node with a value d
	Node deleteNode(Node head, int d) {
		Node n = head;
		if (n.data == d) {
			return head.next; /* the value of head is d, just remove the head and return head.next*/
		}
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head; /* head didn’t change */
			}
			n = n.next;
		}
		//value d does not exist
		return null;
	}
}