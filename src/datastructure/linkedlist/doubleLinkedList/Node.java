package datastructure.linkedlist.doubleLinkedList;
public class Node {

	Object  value;
	Node next;
	Node previous;
	Node(Node previous,Object value, Node next)
	{
		this.next=next;
		this.previous=previous;
		this.value=value;
	}
	
	@Override
	public String toString()
	{
		return value +" ";
	}
}
