package datastructure.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueAPI {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer("Java");
		queue.offer("DotNet");
		queue.offer("PHP");
		queue.offer("HTML");
		Iterator i = queue.iterator();
		System.out.println(i.next());
		System.out.println(i.next());
		System.out.println("Top Element: " + queue.element());
		System.out.println(i.next());

		System.out.println("remove: " + queue.remove());

		System.out.println("Top Element: " + queue.element());
		System.out.println("poll: " + queue.poll());
		System.out.println("Remove : " + queue.remove());
		System.out.println("Top Element: " + queue.peek());
		queue.removeAll(queue);
		System.out.println(queue.size());
		System.out.println("Top Element: " + queue.peek());// return null
		System.out.println("Top Element: " + queue.element());// Throw
																// NoSuchElement
																// Exception

	}

}