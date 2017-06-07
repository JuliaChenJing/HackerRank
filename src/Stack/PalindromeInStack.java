package Stack;

import java.util.Stack;;

public class PalindromeInStack {

	public static void main(String[] args) {
		System.out.println(isPalindrome("1221"));
		System.out.println(isPalindrome("abccba"));
		System.out.println(isPalindrome("asbccba"));
		System.out.println(isPalindrome("abeba"));
		System.out.println(isPalindrome("abdsfeba"));
		System.out.println(isPalindrome(""));
		System.out.println(isPalindrome(null));

	}

	/*
	 *  test if a String is a Palindrome: Strings that read the same from left to right
	 *   as they do from right to left
	 */
	static public boolean isPalindrome(String s) {
		if (s==null)
				return false;
		int i = 0;
		boolean re = true;
		Stack<Character> stack = new Stack<Character>();
		
		if (s.length() % 2 == 0) {

			for (; i < s.length() / 2; i++)

				stack.push(s.charAt(i));

			for (; i < s.length(); i++)

			{
				if (stack.pop() != s.charAt(i)) {
					return false;
				}
			}
			
		} else {
			for (; i < s.length() / 2; i++)

				stack.push(s.charAt(i));

			for (i++; i < s.length(); i++)

			{

				if (stack.pop() != s.charAt(i)) {
					return false;
				}
			}

		}
		return re;

	}

}
