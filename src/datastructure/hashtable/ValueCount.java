package datastructure.hashtable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ValueCount {
	public static HashMap<String, Integer> map;
	public static Queue<String> q;

	public static void main(String[] args) {
		map = new HashMap<String, Integer>();
		q = new LinkedList<String>();

		Scanner scan = new Scanner(System.in);
		System.out.println("please enter the number of key-value pairs :");
		int n = scan.nextInt();
		scan.nextLine();
		int i = 0;
		while (i < n && scan.hasNext()) {

			String str = scan.nextLine();
			String[] pair = str.split(",");
			// for (int i = 0; i < pair.length; i++)
			// System.out.println(pair[i]);

			map = add(pair[0], Integer.parseInt(pair[1]));

			i++;

		}

		while (q.peek() != null) {
			String s = q.poll();
			System.out.println(s + "," + map.get(s));
		}

	}

	public static HashMap<String, Integer> add(String key, int value) {
		if (!map.containsKey(key)) {
			map.put(key, value);
			q.add(key);
		} else {
			value = map.get(key) + value;
			map.put(key, value);
		}
		return map;
	}

}
