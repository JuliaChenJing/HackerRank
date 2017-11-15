package datastructure.queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeAPITest {

	public static void main(String[] args) {
		
		Deque<String> dq = new LinkedList<String>();
		dq.add ("Java"); //add element at tail
		dq.addFirst("C#"); //add element at head
		dq.addLast ("Software Engineering"); //add element at tail
		System.out.println("DQueue Elements : " + dq);
		
		Deque<String> dequeA = new LinkedList<String>();

		dequeA.add("element 0");
		dequeA.add("element 1");
		dequeA.add("element 2");

		// access via Iterator
		Iterator<String> iterator = dequeA.iterator();
		while (iterator.hasNext()) {
			String element = (String) iterator.next();
			System.out.println(element);
		}

		// access via new for-loop
		for (Object object : dequeA) {
			String element = (String) object;
			System.out.println(element);
		}

		System.out.println("Dequeue Queue Elements : " + dequeA);
	}
}
