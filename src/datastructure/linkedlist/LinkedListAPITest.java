package datastructure.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class LinkedListAPITest {
	public static void main(String[] args) {
		LinkedList<String> linkedlist = new LinkedList<String>();
		linkedlist.add("First");
		linkedlist.add("Second");
		linkedlist.add("Third");
		linkedlist.add("Fourth");

		List<String> list = new LinkedList<String>();
		list.add("Second");
		list.add("Fourth");

		System.out.println("Does LinkedList contains all list elements?: " + linkedlist.containsAll(list));
		list.add("one");
		System.out.println("Does LinkedList contains all list elements?: " + linkedlist.containsAll(list));

	}
}
