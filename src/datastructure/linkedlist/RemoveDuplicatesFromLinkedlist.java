package datastructure.linkedlist;

import java.util.Hashtable;

/*
 *  Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDuplicatesFromLinkedlist {
	
	//Delete duplicate-value nodes from a sorted linked list
	
	Node RemoveDuplicates(Node head) {
    if (head == null) {
        return null;
    }
    Node n = head;
    while (n.next != null) {
        if (n.data == n.next.data) {
            n.next = n.next.next;
        } else {
            n = n.next;
        }
    }
    return head;
}


	// If we can use a buffer, we can keep track of elements in a hashtable and
	// remove any duplicates
	public static void deleteduplicates(Node head) {
		if (head == null)
			return;
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		Node n = head;
		Node previous = null;// ä¿?å­˜å¤„ç?†ä¸­çš„å½“å‰?ä½?ç½®ï¼Œä¸‹ä¸€ä¸ªä½?ç½®å?¯ä»¥æ”¾å…¥ä¸‹ä¸€ä¸ªä¸?é‡?å¤?çš„æ•°å­—
		while (n != null) {

			if (!table.containsKey(n.data))// å¦‚æžœèŠ‚ç‚¹çš„å€¼ä¸?åœ¨è¡¨ä¸­
			{
				table.put(n.data, true);// æ•°å€¼æ”¾å…¥è¡¨ä¸­
				previous = n;
			}

			else // å¦‚æžœèŠ‚ç‚¹çš„å€¼åœ¨è¡¨ä¸­
			{
				previous.next = n.next;//æŠŠå½“å‰?èŠ‚ç‚¹åŽ»æŽ‰
			}

			n = n.next;
		}
		// return head;//ç›´æŽ¥å°±æ”¹å?˜äº†åŽŸæ?¥çš„å€¼ï¼Œæ‰€ä»¥ä¸?è¿”å›žheadä¹Ÿè¡Œ
	}

	/*
	 * Without a buffer, we can iterate with two pointers: â€œcurrentâ€? does a
	 * normal iteration, while â€œrunnerâ€? iterates through all prior nodes to
	 * check for duplicates. Runner will only see one duplicate per node, because if there
	 * were multiple duplicates they would have been removed already
	 */

	public static void deleteduplicates2(Node head) {
		if (head == null)
			return;
		Node previous = head;
		Node current = previous.next;
		while (current != null) {
			Node runner = head;
			while (runner != current) { // Check for earlier duplicates
				if (runner.data == current.data) {
					Node tmp = current.next; // remove current
					previous.next = tmp;
					current = tmp; // update current to next node
					break; // all other duplicates have already been removed
				}
				runner = runner.next;
			}
			if (runner == current) { // current not updated â€? update now
				previous = current;
				current = current.next;
			}
		}
	}

	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(1);
		Node d = new Node(2);
		Node e = new Node(3);
		Node f = new Node(4);
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

		deleteduplicates2(a);

		System.out.println("\nAFTER: ");
		n = a;
		while (n != null) {
			System.out.print(n.data + "--->");
			n = n.next;
		}

	}
}
