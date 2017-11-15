package datastructure.hashtable;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashtableAPI {
	public static void main(String[] args) {
		// Demo code for Predefined HashTable class

		Hashtable<String, String> hm = new Hashtable<String, String>();
		// add key-value pair to Hashtable
		hm.put("1", "FIRST INSERTED");
		hm.put("2", "SECOND INSERTED");
		hm.put("3", "THIRD INSERTED");
		// hm.put(null,null); Throw run time error - NullPointer Exception

		System.out.println("0all the values:");
		Iterator<Integer> it = (Iterator) hm.keys();
		while (it.hasNext()) {
			System.out.println(hm.get(it.next()));
		}

		System.out.println("\n1 My Hashtable content:");
		System.out.println(hm); // Display the contents by key wise reverse
								// order

		// Checking Keys
		if (hm.containsKey("1")) {
			System.out.println("\n2  The Hashtable contains key 1");
		} else {
			System.out.println("\n3 The Hashtable does not contains key 1");
		}
		// Checking Value
		if (hm.containsValue("SECOND INSERTED")) {
			System.out.println("\n5 The Hashtable contains value SECOND INSERTED");
		} else {
			System.out.println("\n6 The Hashtable does not contains value SECOND INSERTED");
		}
		// Clearing Items

		System.out.println("\n7 Clearing Hashtable:");
		hm.clear();
		System.out.println("\n8 Content After clear:");
		System.out.println(hm);

		Hashtable<Integer, Empl> tm = new Hashtable<Integer, Empl>();
		tm.put(1, new Empl(134, "Ramu", 3000));
		tm.put(15, new Empl(235, "Jony", 6000));
		tm.put(23, new Empl(876, "Crish", 2000));
		tm.put(4, new Empl(512, "Tom", 2400));
		System.out.println("Hashtable entries:\n");

		Set<Integer> keys = tm.keySet();
		for (Integer i : keys) {
			System.out.println(i + " ==> " + tm.get(i));
		}

	}
}

class Empl {

	private String name;
	private int salary;
	private int id;

	public Empl(int id, String n, int s) {
		this.id = id;
		this.name = n;
		this.salary = s;
	}

	public String toString() {
		return id + "\n" + name + "\n" + salary + "\n";
	}
}

/*
 * 0all the values: THIRD INSERTED SECOND INSERTED FIRST INSERTED
 * 
 * 1 My Hashtable content: {3=THIRD INSERTED, 2=SECOND INSERTED, 1=FIRST
 * INSERTED}
 * 
 * 2 The Hashtable contains key 1
 * 
 * 5 The Hashtable contains value SECOND INSERTED
 * 
 * 7 Clearing Hashtable:
 * 
 * 8 Content After clear: {}
 * 
 */
