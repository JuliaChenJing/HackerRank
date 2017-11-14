package algorithm.recursion;

/**
 * Class: Fundamental Programming Practice <br />
 * 
 * @author "Jing Chen" <br />
 *         Description: Using recursion to find the minimum character in a given
 *         string input. If your input is "akel" in return 'a'. <br />
 **/
public class MinimumChar {

	public static void main(String[] args) {
		String str = "pplea";
		System.out.println("The minimum charactor in this string is: " + min(str, 0, str.length() - 1));
	}

	public static char min(String str, int lowerIndex, int upperIndex) {
		char m;

		if (lowerIndex == upperIndex) // size of the sublist is 1
			return str.charAt(lowerIndex);
		else {

			m = min(str, lowerIndex + 1, upperIndex);

			if ((int) str.charAt(lowerIndex) < (int) m)
				return str.charAt(lowerIndex);
			else
				return m;
		}
	}
}
/* The minimum charactor in this string is: a */
