package datastructure.linkedlist;

public class Reverse {
	
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);

		a.next = b;
		b.next = c;
		c.next = d;
		Node.print(a);
		Node.print(d);
		reverse(a);
		Node.print(a);
		Node.print(d);
	}

	
	static Node reverse(Node head) {
	    if (head == null) {
	        return null;
	    }
	    
	    if (head.next == null) {
	        return head;
	    }
	            
	    Node preNode = null;
	    Node currNode = head;
	    Node nextNode = null;
	     
	    while (currNode != null) {
	        nextNode = currNode.next;//for the next round
	        currNode.next = preNode;//reverse
	        
	        preNode = currNode;//for the next round
	        currNode = nextNode;//for the next round
	    }
	    
	    head = preNode;
	    
	    return head;
	}
}
