package datastructure.linkedlist;
public class DoubleLinkedList {
	
	//https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem


/*
  Node is defined as 
  class Node {
     int data;
     Node next;
     Node prev;
  }
*/

//  Time Complexity: O(n)
// Space Complexity: O(1)
Node SortedInsert(Node head, int data) {
    /* Create Node to insert */
    Node newNode = new Node();
    newNode.data = data;
    
    if (head == null) { // insert in empty list
        return newNode;
    } else if (data < head.data) { // insert in front of list
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    } else {        
        /* Walk list with 2 pointers (code is cleaner than using just 1 pointer) */
        Node n1 = null;
        Node n2 = head;
        while (n2 != null && n2.data < data) {
            n1 = n2;
            n2 = n2.next;
        }
        
        if (n2 == null) { // insert at end of list
            n1.next = newNode;
            newNode.prev = n1;
        } else { // insert somewhere within the list
            n1.next = newNode;
            n2.prev = newNode;
            newNode.prev = n1;
            newNode.next = n2;
        }
        return head;
    }
	
	// Iterative Solution using 3 pointers
//          Runtime: O(n)
// Space Complexity: O(1)
Node Reverse(Node head) {
    if (head == null && head.next == null) {
        return head;
    }
    Node prev = null;
    Node curr = head;
    Node next = null;
    while (curr != null) {
        next = curr.next;
        curr.next = prev; // changes arrow direction
        prev = curr;
        curr = next;
    }
    return prev;
}
Node header;

	
	public static void main(String[] args) {
		System.out.println("1 test toString()");
		DoubleLinkedList mySL = new DoubleLinkedList();
		System.out.println(mySL);
		System.out.println();
		
		
		
		System.out.println("2.1 test addFront()");
		mySL.addFront("Carrot Cake");
		mySL.addFront("Blueberry Muffin");
		mySL.addFront("Apple Pie");
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
		
		
		System.out.println("2.2 test addLast()");
		mySL.addLast("Orange Juice");
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
		System.out.println("3.1 test deleteNode()");
		mySL.deleteNode(mySL.findItem("Apple Pie"));
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
		
		System.out.println("3.2 test deleteNode()");
		mySL.deleteNode(mySL.findItem("Peach Sauce"));
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
		
		System.out.println("3.3 test deleteNode()");
		mySL.deleteNode(mySL.findItem("Carrot Cake"));
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
	
		
		
		System.out.println("4.1 test postAddNode()");
		mySL.postAddNode(mySL.findItem("Blueberry Muffin"), "Carrot Cake");
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
		System.out.println("4.2 test preAddNode()");
		mySL.preAddNode(mySL.findItem("Blueberry Muffin"), "Apple Pie" );
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println("Is the linked list empty? " + mySL.isEmpty());
		System.out.println();
		
		System.out.println("5 test the recursive print method to display the elements in the list.");
		mySL.print(mySL.header);
		System.out.println();
		
		System.out.println("6 test size()");
		System.out.println("the size of the linked list is : " + mySL.Size());
		System.out.println();
		
		System.out.println("7.1 test getLast()");
		System.out.println(mySL.getLast());
		System.out.println();
		
		System.out.println("7.2 test getFirst()");
		System.out.println(mySL.getFirst());
		System.out.println();
		
		System.out.println("8.1 test removeFirst()");
		mySL.removeFirst();
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
		System.out.println("8.2 test removeLast()");
		mySL.removeLast();
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
		
		
		System.out.println("9 test deleteList()");
		mySL.deleteList();
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
		System.out.println("10 test isEmpty()");
		System.out.println("Is the linked list empty? " + mySL.isEmpty());
		System.out.println("the size of the linked list is : " + mySL.Size());
		System.out.println();		
		
	}

	DoubleLinkedList() {
		header = null;
	}

	public void addFront(String item) {
		if (header == null)
			header = new Node(null, item, null);
		else {
			Node n = new Node(null, item, header);
		    	header.previous = n;
		    	header = n;
		}
	}

// Implement the code

	public void addLast(String item) {
		if (header == null)
			header = new Node(null, item, null);
		else {
			Node n = new Node(findLast(), item, null);
			findLast().next=n;
		}
	}


	// implement the code
	public void postAddNode(Node n, String value){
		Node newNode;
		if (n == null){
			//List is empty
			newNode = new Node(null, value, null);
		}
		else if (n.next == null) {
			//n is the first node
			addLast(value);
		}
		else {
			newNode = new Node(n, value, n.next);
			n.next.previous = newNode;
			n.next = newNode;
		}	
					
					
	}
// implement the code
	public int Size(){	   
		if (header == null)
    	    	
       		return 0;
       	else
       		{
       		int num=0;
       		Node temp = header;
			while (temp != null)
			{
				num++;
				temp=temp.next;
			}
			return  num;
       		}
       }

// implement code
    public boolean isEmpty()
{
    	if (header == null)
    	
    		return true;
    	else
    		return false;
}  

  
	
	public void preAddNode(Node n, String value){
		Node newNode;
		if (n == null){
			//List is empty
			newNode = new Node(null, value, null);
		}
		else if (n.previous == null) {
			//n is the first node
			addFront(value);
		}
		else {
			newNode = new Node(n.previous, value, n);
			n.previous.next = newNode;
			n.previous = newNode;
		}	
					
	}
	
	public Node findLast() {
		if (header == null)
			return null;
		else {
			Node temp = header;
			while (temp.next != null)
				temp = temp.next;
			return temp;
		}
	}

	public Node findItem(String str) {
		if (header == null)
			return null;
		else {
			Node temp = header;
			while (temp != null)
				if (str.equals(temp.value))
					return temp;
				else
					temp = temp.next;
			return null;
		}
	}

	public void deleteNode(Node n) {
		if (header != null && n != null) {
			if (n.next == null && n.previous == null) {
				// only one node
				header = null;
				n = null;
				System.out.println("I am here 1");

			} else if (n.previous == null) {
				// remove first node
				n.next.previous = null;
				header = n.next;
				n = null;
				System.out.println("I am here 2");
			} else if (n.next == null) {
				// remove last node
				n.previous.next = null;
				n = null;
				System.out.println("I am here 3");
			} else {
				// general case
				n.next.previous = n.previous;
				n.previous.next = n.next;
				n = null;
				System.out.println("I am here 4");
			}

		}

	}
	
	public void deleteList(){
		Node tempOne = header;
		Node tempTwo = header;
		while (tempOne != null) {
			tempOne = tempOne.next;
			tempTwo = null;
			tempTwo = tempOne;
		}
		header = null;
	}

	public String toString() {
		String str =""; 
		Node temp = header;
		while (temp != null) {
			str = str + "-->[" + temp.value.toString() + "]";
			temp = temp.next;
		}
		str = str + "-->[" + "NULL" + "]";
		return str;
	}

	public void printReverse() {
		String str =""; 
		Node temp = findLast();
		while (temp != null) {
			str = str + "==>[" + temp.value.toString() + "]";
			temp = temp.previous;
		}
		str = str + "==>[" + "NULL" + "]";
		System.out.println(str);
	}
	
	
	public Object getLast() {
		if (header == null)
			return null;
		else {
			Node temp = header;
			while (temp.next != null)
				temp = temp.next;
			return temp;
		}
	}

	public Object getFirst() {
		if (header == null)
			return null;
		else
			return header;
		
	}
	
	public void removeFirst() {
		if (header != null ) {
			if (header.next == null ) {
				// only one node
				header = null;

			} else 

			{
				// remove first node
				header = header.next;
				header.previous=null;
			}

		}

	}
	
	public void removeLast() {
		if (header != null ) {
			if (header.next == null ) {
				// only one node
				header = null;

			} else 

			{
				// remove last node
				findLast().previous.next= null;
			}

		}

	}

	//Write a recursive print method to display the elements in the list. 
	//Start with the First Node(Head)
	public void print(Node n)
	{
		if(n!=null){
			if(n.next==null)
				System.out.println(n);
			else
				System.out.println(n);
				print(n.next);
		}
	}
	
	class Node 
	{
		String value;
		Node next;
		Node previous;

		Node(Node previous, String value, Node next) {
			this.previous = previous;
			this.value = value;
			this.next = next;
		}

		public String toString() {
			return value;
		}
	}
}
