package datastructure.queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeAPITest {

	public static void main(String[] args) {
		Deque dequeA = new LinkedList();

		dequeA.add("element 0");
		dequeA.add("element 1");
		dequeA.add("element 2");

		// access via Iterator
		Iterator iterator = dequeA.iterator();
		while (iterator.hasNext()) {
			String element = (String) iterator.next();
		}

		// access via new for-loop
		for (Object object : dequeA) {
			String element = (String) object;
			System.out.println(element);
		}

		
		System.out.println("Dequeue Queue Elements : " + dequeA);
	}
}
