package datastructure.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueAPI {

	static class PQsort implements Comparator<Integer> {

		public int compare(Integer one, Integer two) {
			return two - one;// descending order
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();

		// use offer() method to add elements to the PriorityQueue pq1
		for (int x : array) {
			pq1.offer(x);
		}

		System.out.println("pq1: " + pq1);

		PQsort pqsort = new PQsort();
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10, pqsort);
		// In this particular case, we can simply use Collections.reverseOrder()
		// instead of self-defined comparator
		for (int x : array) {
			pq2.offer(x);
		}

		System.out.println("pq2: " + pq2);

		// print size
		System.out.println("size: " + pq2.size());
		// return highest priority element in the queue without removing it
		System.out.println("peek: " + pq2.peek());
		// print size
		System.out.println("size: " + pq2.size());
		// return highest priority element and removes it from the queue
		System.out.println("poll: " + pq2.poll());
		// print size
		System.out.println("size: " + pq2.size());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(3);
		pq.add(1);
		pq.add(2);
		System.out.println("Priority Queue Elements : " + pq);

	}
}