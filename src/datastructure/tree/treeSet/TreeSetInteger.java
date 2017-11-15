package datastructure.tree.treeSet;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetInteger {

	public static void main(String[] args) {

		TreeSet<Integer> set = new TreeSet<Integer>();

		set.add(20);
		set.add(10);
		set.add(30);
		set.add(25);
		set.add(20);
		System.out.println(set);
		int[] a = { 15, 12, 9, 56, 1, 16, 19, 22, 3, 100, 2, 25 };

		TreeSet<Integer> ts = new TreeSet<Integer>();

		for (int j = 0; j < a.length; j++) {
			ts.add(a[j]);
			System.out.println("\nAfter inserting " + j + "th item " + a[j]);
			Iterator<Integer> it = ts.iterator();
			while (it.hasNext()) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
/*
 * 
 * After inserting 0th item 15 15
 * 
 * After inserting 1th item 12 12 15
 * 
 * After inserting 2th item 9 9 12 15
 * 
 * After inserting 3th item 56 9 12 15 56
 * 
 * After inserting 4th item 1 1 9 12 15 56
 * 
 * After inserting 5th item 16 1 9 12 15 16 56
 * 
 * After inserting 6th item 19 1 9 12 15 16 19 56
 * 
 * After inserting 7th item 22 1 9 12 15 16 19 22 56
 * 
 * After inserting 8th item 3 1 3 9 12 15 16 19 22 56
 * 
 * After inserting 9th item 100 1 3 9 12 15 16 19 22 56 100
 * 
 * After inserting 10th item 2 1 2 3 9 12 15 16 19 22 56 100
 * 
 * After inserting 11th item 25 1 2 3 9 12 15 16 19 22 25 56 100
 * 
 */
