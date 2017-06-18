package datastructure.string;

import java.util.HashMap;

//Implement an algorithm to determine if a string has all unique characters.
public class UniqueChar {

	public static void main(String[] args) {
		System.out.println(allUniqueChar("apple"));
		System.out.println(allUniqueChar("aple"));

		System.out.println(allUniqueChar_ASCII("apple"));
		System.out.println(allUniqueChar_ASCII("aple"));

	}

	// using hashmap
	public static boolean allUniqueChar(String s) {
		if (s == null || s.length() == 0)
			return true;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i)))
				return false;
			else
				map.put(s.charAt(i), 0);
		}
		return true;

	}

	// What if you can not use additional data structures?

	/*
	 * For simplicity, assume char set is ASCII (if not, we need to increase the
	 * storage size. The rest of the logic would be the same). NOTE: This is a
	 * great thing to point out to your interviewer!
	 */

	public static boolean allUniqueChar_ASCII(String str) {
		boolean[] char_set = new boolean[256];// there are 256 char type
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val])// if var already exists
				return false;
			else
				char_set[val] = true;
		}
		return true;
	}

	/*
	 * Time complexity is O(n), where n is the length of the string, and space
	 * complexity is O(n). We can reduce our space usage a little bit by using a
	 * bit vector. We will assume, in the below code, that the string is only
	 * lower case ‘a’ through ‘z’. This will allow us to use just a single int
	 */

}