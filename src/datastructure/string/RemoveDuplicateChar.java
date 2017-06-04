package datastructure.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
Design an algorithm and write code to remove the duplicate characters in a string without using any additional  buffer.
 Note: One or two additional varaibles are fine.
Follow Up: Write the test case for this method

1. String does not contain any duplicates, e.g.: abcd
2. String contains all duplicates, e.g.: aaaa
3. Null string
4. Empty string
5. String with all continuous duplicates, e.g.: aaabbb
6. String with non-contiguous duplicates, e.g.: abababa
 */
public class RemoveDuplicateChar {

	// extra space is used
	public static String removeDuplicateChar_HashSet(String str) {
		if (str == null)
			return str;
		int len = str.length();
		if (len < 2)
			return str;

		char[] chars = str.toCharArray();
		Set<Character> re = new HashSet<>();
		int l = 0;
		for (char c : chars)
			if (re.add(c))
				chars[l++] = c;
		return new String(chars, 0, l);
	}

	public static String removeDuplicateChar_HashMap(String s) {
		if (s == null || s.length() == 0)
			return null;
		StringBuffer re = new StringBuffer();

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i)))
				;
			else {
				map.put(s.charAt(i), 0);
				re.append(s.charAt(i));
			}
		}

		return re.toString();

	}

	/*
	 * First, ask yourself, what does the interviewer mean by an additional
	 * buffer? Can we use an additional array of constant size? Algorithm—No
	 * (Large) Additional Memory: 1. For each character, check if it is a
	 * duplicate of already found characters. 2. Skip duplicate characters and
	 * update the non duplicate characters. Time complexity is O(N*N)
	 * 不对，有问题
	 */

	public static char [] removeDuplicateChar(char[] str) {
		if (str == null)
			return str;
		int len = str.length;
		if (len < 2)
			return str;

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
		return str;
	}

	public static void main(String[] args) {

		System.out.println("hashset:-----------");
		System.out.println(removeDuplicateChar_HashSet("apple"));
		System.out.println(removeDuplicateChar_HashSet("aaabbb"));
		System.out.println(removeDuplicateChar_HashSet(""));
		System.out.println(removeDuplicateChar_HashSet(null));
		System.out.println();

		System.out.println("hashmap:------------");
		System.out.println(removeDuplicateChar_HashMap("apple "));
		System.out.println(removeDuplicateChar_HashMap("aaabbb"));
		System.out.println(removeDuplicateChar_HashMap(""));
		System.out.println(removeDuplicateChar_HashMap(null));
		System.out.println();

		System.out.println("not use extra space:------------");
		char[] str1 = { 'a', 'a', 'a' };
		char[] str2 = { 'a', 'b' };
		char[] str3 = null;
		char[] str4 = { 'a', 'a', 'b', 'b' };
		System.out.println(removeDuplicateChar(str1));
		// System.out.println( removeDuplicateChar(str2));
		// System.out.println( removeDuplicateChar(str3));
		// System.out.println( removeDuplicateChar(str4));

	}
}
