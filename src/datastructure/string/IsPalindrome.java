package datastructure.string;

public class IsPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("apple"));
		System.out.println(isPalindrome("appa"));
		System.out.println(isPalindrome("12321"));
		System.out.println(isPalindrome("123"));
	}

	static boolean isPalindrome(String str) {
		if (str == null || str.length() == 0)
			return true;
		int rightIndex = str.length() - 1;
		for (int leftIndex = 0; leftIndex < rightIndex; leftIndex++, rightIndex--) {
			if (str.charAt(leftIndex) != str.charAt(rightIndex))
				return false;
		}

		return true;
	}

	// Determine whether an integer is a palindrome. Do this without extra  space.
	public boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0))
			return false;
		int rev = 0;
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}
		return (x == rev || x == rev / 10);
	}
}
