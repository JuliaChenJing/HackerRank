package datastructure.string;

/*
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example:
 * 
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer. Example:
 * 
 * Input: "cbbd"
 * 
 * Output: "bb"
 */
public class LongestPalindromicSubstring {


	/*
	 * Example: "xxxbcbxxxxxa", (x is random character, not all x are equal) now
	 * we are dealing with the last character 'a'. The current longest
	 * palindrome is "bcb" with length 3. 1. check "xxxxa" so if it is
	 * palindrome we could get a new palindrome of length 5.
	 * 
	 * 2. check "xxxa" so if it is palindrome we could get a new palindrome of
	 * length 4.
	 * 
	 * 3. do NOT check "xxa" or any shorter string since the length of the new
	 * string is no bigger than current longest length.
	 * 
	 * 4. do NOT check "xxxxxa" or any longer string because if "xxxxxa" is
	 * palindrome then "xxxx" got from cutting off the head and tail is also
	 * palindrom. It has length > 3 which is impossible.'
	 */
	public static String longestPalindrome(String s) {
		String res = "";
		int currLength = 0;
		for (int i = 0; i < s.length(); i++) {
			if (isPalindrome(s, i - currLength - 1, i)) {
				res = s.substring(i - currLength - 1, i + 1);
				currLength = currLength + 2;
			} else if (isPalindrome(s, i - currLength, i)) {
				res = s.substring(i - currLength, i + 1);
				currLength = currLength + 1;
			}
		}
		return res;
	}

	public static boolean isPalindrome(String s, int begin, int end) {
		if (begin < 0)
			return false;
		while (begin < end) {
			if (s.charAt(begin++) != s.charAt(end--))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("bb"));
	}
}
