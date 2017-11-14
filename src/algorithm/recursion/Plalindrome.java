package algorithm.recursion;

/**
 * Class: Fundamental Programming Practice <br />
 * 
 * @author "Jing Chen" <br />
 *         Description:Check the given string input is palindrome or not<br />
 */
public class Plalindrome {

	public static void main(String[] args) {

		String a = "appaappa";
		System.out.println("Is this string a palindrome? " + pa(a));
	}

	public static boolean pa(String str) {

		if (str.length() == 0)
			return true;
		else if (str.length() == 1)
			return true;
		else {
			if (str.charAt(0) == str.charAt(str.length() - 1))
				return pa(str.substring(1, str.length() - 1));
			else
				return false;
		}
	}
}

/* Is this string a Plalindrome? true */
