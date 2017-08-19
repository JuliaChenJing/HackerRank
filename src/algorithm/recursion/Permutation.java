package algorithm.recursion;

import java.util.ArrayList;

// Write a method to compute all permutations  [数] 排列；[数] 置换 of a string
public class Permutation {

	/*
	 * Let’s assume a given string S represented by the letters A1, A2, A3, ...,
	 * An To permute set S, we can select the !rst character, A1, permute the
	 * remainder of the string to get a new list. Then, with that new list, we
	 * can “push” A1 into each possible position. For example, if our string is
	 * “abc”, we would do the following:
	 * 
	 * 1. Let first = “a” and let remainder =“bc” 
	 * 
	 * 2. Let list = permute(bc) =
	 * {“bc”, “cd”} 
	 * 
	 * 3. Push “a” into each location of “bc” (--> “abc”, “bac”,
	 * “bca”) and “cb” (--> “acb”, “cab”, “cba”) 
	 * 
	 * 4. Return our new list Now, the
	 * code to do this:
	 * 
	 * This solution takes O(n!) time, since there are n! permutations.
	 */

	public static void main(String[] args) {
		String a = "AbC";
		System.out.print(a.length() + "!=");

		ArrayList<String> re = getPermutations("AbC");
		System.out.println(re.size());
		System.out.println(re);
	}

	// This solution takes O(n!) time, since there are n! permutations.
	public static ArrayList<String> getPermutations(String s) {

		ArrayList<String> permutations = new ArrayList<String>();

		if (s == null) { // null case
			return null;
		} else if (s.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}

		char first = s.charAt(0);// get the first char
		String remainder = s.substring(1);// remove the first letter

		ArrayList<String> words = getPermutations(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				permutations.add(insertCharAt(word, first, j));
			}
		}
		return permutations;
	}

	public static String insertCharAt(String word, char c, int location) {

		// public String substring(int beginIndex, int endIndex)
		String start = word.substring(0, location);

		// public String substring(int beginIndex)
		String end = word.substring(location);

		return start + c + end;
	}

}
