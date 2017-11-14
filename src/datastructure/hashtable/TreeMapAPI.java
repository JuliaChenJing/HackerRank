package datastructure.hashtable;
import java.util.TreeMap;

// Pre- defined user implementation for TreeMap
public class TreeMapAPI{

	public static void main(String[] args) {

		TreeMap<Integer, Integer> Marks = new TreeMap<Integer, Integer>();
		Marks.put(1, 99);
		Marks.put(7, 98);
		Marks.put(6, 96);
		Marks.put(3, 91);
		Marks.put(5, 95);

		System.out.println("Size: " + Marks.size());

		for (int key : Marks.keySet())
			System.out.println(key + " - " + Marks.get(key));
		System.out.println();

		System.out.println("Highest key: " + Marks.lastKey());
		System.out.println("Lowest key: " + Marks.firstKey());

		System.out.println("\nPrinting all values:");
		for (Integer val : Marks.values())
			System.out.println(val);
		System.out.println();

		// Clear all values.
		Marks.clear();
		// Equals to zero.
		System.out.println("After clear operation, size: " + Marks.size());

		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		map.put(8, "Hello");
		map.put(10, "World!");
		map.put(11, "Welcome");
		map.remove(8);
		String str = map.get(11) + ", " + map.get(10);
		System.out.println(str);
	}

}
/*
 Size: 5
1 - 91
3 - 93
5 - 95
6 - 96
7 - 97

Highest key: 7
Lowest key: 1

Printing all values:
91
93
95
96
97

After clear operation, size: 0
Welcome, World!


 */