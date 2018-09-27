package pramp.strings;

public class DeletionDistance {

	/*
	 * https://www.pramp.com/question/61ojWAjLJbhob2nP2q1O
	 *
	 * The deletion distance of two strings is the minimum number of characters
	 * you need to delete in the two strings in order to get the same string.
	 * For instance, the deletion distance between "heat" and "hit" is 3:
	 * 
	 * By deleting 'e' and 'a' in "heat", and 'i' in "hit", we get the string
	 * "ht" in both cases. We cannot get the same string from both strings by
	 * deleting 2 letters or fewer. Given the strings str1 and str2, write an
	 * efficient function deletionDistance that returns the deletion distance
	 * between them. Explain how your function works, and analyze its time and
	 * space complexities.
	 * 
	 * Examples:
	 * 
	 * input: str1 = "dog", str2 = "frog" output: 3
	 * 
	 * input: str1 = "some", str2 = "some" output: 0
	 * 
	 * input: str1 = "some", str2 = "thing" output: 9
	 * 
	 * input: str1 = "", str2 = "" output: 0
	 */
	static int deletionDistance(String str1, String str2) {
		if (str1.equals(str2))
			return 0;
		if (str1.length() == 0)
			return str2.length();
		if (str2.length() == 0)
			return str1.length();

		int m = str1.length();
		int n = str2.length();

		if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
			return 0 + deletionDistance(str1.substring(0, m - 1), str2.substring(0, n - 1));
		} else {
			return 1 + Math.min(deletionDistance(str1.substring(0, m - 1), str2),
					deletionDistance(str1, str2.substring(0, n - 1)));
		}
	}

	public static void main(String[] args) {
		System.out.println(deletionDistance("apple", "bpple"));
		System.out.println(deletionDistance("apple", "apple"));
		System.out.println(deletionDistance("apple", "capple"));
		System.out.println(deletionDistance("apple", "abepple"));
	}
}
