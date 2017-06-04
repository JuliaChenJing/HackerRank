package datstructure.linkedlist;

/*
 *  Implement an algorithm to delete a node in the middle of a single linked list, given
    only access to that node.

     EXAMPLE
     Input: the node ‘c’ from the linked list a->b->c->d->e
     Result: nothing is returned, but the new linked list looks like a->b->d->e
 */
public class DeleteNode {
	/*
	 * The solution to this is to simply copy the data from the next node into
	 * this node and then delete the next node. 
	 * 
	 * NOTE: This problem can not be solved if the node to be 
	 * deleted is the last node in the linked list.
	 * That’s ok—your interviewer wants to see you point that out. You could
	 * consider marking it as dummy in that case. This is an issue you should
	 * discuss with your interviewer.
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
}
