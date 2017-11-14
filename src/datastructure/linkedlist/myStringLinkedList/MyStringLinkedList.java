package datastructure.linkedlist.myStringLinkedList;
public class MyStringLinkedList {
	Node header;

	MyStringLinkedList() {
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
	
	public class Node {
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
}
