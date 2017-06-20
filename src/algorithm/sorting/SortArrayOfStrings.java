package algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//Write a method to sort an array of strings so that all the anagrams (abccba) are next to each other
public class SortArray {

	// just sort the arrays, using this compareTo method instead of the usual
	// one
	public static void main(String[] args) {

		String[] array = { "apple", "banana", "orange", "ant" };

		System.out.println("1 original value");
		for (int i = 0; i < array.length; i++)

			System.out.print(array[i] + "-->");

		System.out.println("\n2 sort chars value");
		for (int i = 0; i < array.length; i++) {
			System.out.print(sortChars(array[i]) + "-->");
		}

		Arrays.sort(array);

		System.out.println("\n3 Arrays.sort(array)");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + "-->");

		Arrays.sort(array, new AnagramComparator());

		System.out.println("\n4 Arrays.sort(array, new AnagramComparator())");
		for (int i = 0; i < array.length; i++)

			System.out.print(array[i] + "-->");

		/*
		 *1 original value
         apple-->banana-->orange-->ant-->

          2 sort chars value
          aelpp-->aaabnn-->aegnor-->ant-->
 
         3 Arrays.sort(array)
         ant-->apple-->banana-->orange-->

          4 Arrays.sort(array, new AnagramComparator())
          banana-->orange-->apple-->ant-->
		 */
	}

	/*
	 * The basic idea is to implement a normal sorting algorithm where you
	 * override the compareTo method to compare the “signature” of each string.
	 * In this case, the signature is the alphabetically sorted string.
	 */

	static class AnagramComparator implements Comparator<String> {

		public int compare(String s1, String s2) {
			return sortChars(s1).compareTo(sortChars(s2));
		}

	}

	public static String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

}
