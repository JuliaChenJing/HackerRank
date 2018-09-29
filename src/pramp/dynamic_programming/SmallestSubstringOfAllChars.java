package pramp.dynamic_programming;

import java.util.HashMap;

public class SmallestSubstringOfAllChars {

	/*
	 * Given an array of unique characters arr and a string str, Implement a
	 * function getShortestUniqueSubstring that finds the smallest substring of
	 * str containing all the characters in arr. Return "" (empty string) if
	 * such a substring doesn’t exist.
	 * 
	 * Come up with an asymptotically optimal solution and analyze the time and
	 * space complexities.
	 * 
	 * Example:
	 * 
	 * Input : string = "geeksforgeeks" pattern = "ork" Output : Minimum window
	 * is "ksfor"
	 * 
	 * 1- First check if length of string is less than the length of given
	 * pattern, if yes then "no such window can exist ". 
	 * 
	 * 2- Store the occurrence * of characters of given pattern in a hash_pat[]. 
	 * 
	 * 3- Start matching the * characters of pattern with the characters of string i.e. increment count
	 * if a character matches
	 * 
	 * 4- Check if (count == length of pattern ) this * means a window is found 
	 * 
	 * 5- If such window found, try to minimize it by * removing extra characters from beginning of current window. 
	 * 
	 * 6- Update * min_length. 7- Print the minimum length window.
	 */

	public static void main(String[] args) {
		char[] arr = { 'o', 'r', 'k' };
		System.out.println(getShortestUniqueSubstring(arr, "geeksforgeeks"));

		String pat = "ork";

		System.out.print(findSubString("geeksforgeeks", pat));
	}

	static String getShortestUniqueSubstring(char[] arr, String str) {
		int headIndex = 0;
		String result = "";
		int uniqueCounter = 0;
		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

		// initialize countMap
		for (int i = 0; i < arr.length; i++)
			hashmap.put(arr[i], 0);

		// scan str
		for (int tailIndex = 0; tailIndex < str.length(); tailIndex++) {
			// handle the new tail
			char tailChar = str.charAt(tailIndex);

			// skip all the characters not in arr
			if (!hashmap.containsKey(tailChar))
				continue;

			int tailCount = hashmap.get(tailChar);
			if (tailCount == 0)
				uniqueCounter = uniqueCounter + 1;

			hashmap.put(tailChar, tailCount + 1);

			// push head forward
			while (uniqueCounter == arr.length) {
				int tempLength = tailIndex - headIndex + 1;
				if (tempLength == arr.length)
					// return a substring of str from
					// headIndex to tailIndex (inclusive)
					return str.substring(headIndex, tailIndex + 1);

				if (result == "" || tempLength < result.length())
					// return a substring of str from
					// headIndex to tailIndex (inclusive)
					result = str.substring(headIndex, tailIndex + 1);

				char headChar = str.charAt(headIndex);

				if (hashmap.containsKey(headChar)) {
					int headCount = hashmap.get(headChar) - 1;
					if (headCount == 0) {
						uniqueCounter = uniqueCounter - 1;
						hashmap.put(headChar, headCount);
					}
				}
				headIndex = headIndex + 1;
			}

		}
		return result;
	}

	static final int no_of_chars = 256;

	// Function to find smallest window containing
	// all characters of 'pat'
	static String findSubString(String str, String pat) {
		int len1 = str.length();
		int len2 = pat.length();

		// check if string's length is less than pattern's
		// length. If yes then no such window can exist
		if (len1 < len2) {
			System.out.println("No such window exists");
			return "";
		}

		int hash_pat[] = new int[no_of_chars];
		int hash_str[] = new int[no_of_chars];

		// store occurrence ofs characters of pattern
		for (int i = 0; i < len2; i++)
			hash_pat[pat.charAt(i)]++;

		int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;

		// start traversing the string
		int count = 0; // count of characters
		for (int j = 0; j < len1; j++) {
			// count occurrence of characters of string
			hash_str[str.charAt(j)]++;

			// If string's char matches with pattern's char
			// then increment count
			if (hash_pat[str.charAt(j)] != 0 && hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)])
				count++;

			// if all the characters are matched
			if (count == len2) {
				// Try to minimize the window i.e., check if
				// any character is occurring more no. of times
				// than its occurrence in pattern, if yes
				// then remove it from starting and also remove
				// the useless characters.
				while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)] == 0) {

					if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
						hash_str[str.charAt(start)]--;
					start++;
				}

				// update window size
				int len_window = j - start + 1;
				if (min_len > len_window) {
					min_len = len_window;
					start_index = start;
				}
			}
		}

		// If no window found
		if (start_index == -1) {
			System.out.println("No such window exists");
			return "";
		}

		// Return substring starting from start_index
		// and length min_len
		return str.substring(start_index, start_index + min_len);
	}
}
