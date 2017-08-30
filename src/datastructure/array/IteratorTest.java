package datastructure.array;

import java.util.*;

public class IteratorTest {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("apple");
		arr.add("banana");
		arr.add("orange");
		
		Iterator<String> it = arr.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(new Integer(3));
		l.add(new Integer(4));
		Iterator<Integer> iter = l.iterator();
		while (iter.hasNext()) {
			int i = iter.next();
			int j = iter.next();
			System.out.println("~~~~:" + i);
			System.out.println("~~~~:" + j);
		}

	}
}