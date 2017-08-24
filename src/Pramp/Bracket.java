package Pramp;

public class Bracket {

	/*
	 * A string of brackets is considered correctly matched if every opening
	 * bracket in the string can be paired up with a later closing bracket, and
	 * vice versa. For instance, “(())()” is correctly matched, whereas “)(“ and
	 * “((” aren’t. For instance, “((” could become correctly matched by adding
	 * two closing brackets at the end, so you’d return 2.
	 * 
	 * Given a string that consists of brackets, write a function bracketMatch
	 * that takes a bracket string as an input and returns the minimum number of
	 * brackets you’d need to add to the input in order to make it correctly
	 * matched.
	 */
	static int bracketMatch(String text) {
		// your code goes here
		int result = 0;
		if (text == null || text.length() == 0)
			return 0;
		int numOfLeft = 0;
		for (int i = 0; i < text.length(); i++) {

			if (text.charAt(i) == '(')
				numOfLeft++;
			else { // ')'

				if (numOfLeft > 0)
					numOfLeft--;
				else
					result++;

			}

		}

		result += numOfLeft;
		return result;

	}

	public static void main(String[] args) {

		System.out.println(bracketMatch("())("));// 2
		System.out.println(bracketMatch("())"));// 1
		System.out.println(bracketMatch("()"));// 0
	}
	
	
	
}
