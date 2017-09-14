package datastructure.stack;

import java.util.LinkedList;

public class StackUsingLinkedListAPI<T> {
	private LinkedList<T> list = new LinkedList<>();
	
	public T pop() {
		if(!list.isEmpty()) {
			return list.removeFirst();
		}
		else {
			return null;
		}
	}
	
	public void push(T a) {
		list.addFirst(a);
	}
}
