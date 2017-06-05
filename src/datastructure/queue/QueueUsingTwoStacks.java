package datastructure.queue;

import java.util.Stack;

// Implement a class which implements a queue using two stacks
public class QueueUsingTwoStacks {
	/*
	 * Since the major difference between a queue and a stack is the order
	 * (!rst-in-!rst-out vs. lastin-!rst-out), we know that we need to modify
	 * peek() and pop() to go in reverse order. We can use our second stack to
	 * reverse the order of the elements (by popping s1 and pushing the elements
	 * on to s2). In such an implementation, on each peek() and pop() operation,
	 * we would pop everything from s1 onto s2, perform the peek / pop
	 * operation, and then push everything back.
	 * 
	 * This will work, but if two pop / peeks are performed back-to-back, we’re
	 * needlessly moving elements. We can implement a “lazy” approach where we
	 * let the elements sit in s2. s1 will thus be ordered with the newest
	 * elements on the top, while s2 will have the oldest elements on the top.
	 * We push the new elements onto s1, and peek and pop from s2. When s2 is
	 * empty, we’ll transfer all the elements from s1 onto s2, in reverse order.
	 */
	private Stack<Integer> s1, s2;

	QueueUsingTwoStacks() {
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}

	public void enqueue(Integer a) {
		s1.push(a);

	}

	public int dequeue() {
		if (!s2.isEmpty())
			return s2.pop();
		// if s2 is empty
		else {
			// save all the data from s1 to s2
			while (!s1.isEmpty())
				s2.push(s1.pop());

			if (!s2.isEmpty())
				return s2.pop();
			else
				return -1000;
		}

	}

	public int size() {
		return s1.size() + s2.size();
	}



	

	public static void main(String[] args) {
		QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
		queue.enqueue(1);
		queue.enqueue(2);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue(3);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

	}

}
