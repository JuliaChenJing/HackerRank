public class Regex {
	
	
	/*
	 * Implement a regular expression function isMatch that supports the '.' and '*' symbols. The function receives two strings - text and pattern - and should return true if the text matches the pattern as a regular expression. For simplicity, assume that the actual symbols '.' and '*' do not appear in the text string and are used as special symbols only in the pattern string.

In case you aren’t familiar with regular expressions, the function determines if the text and pattern are the equal, where the '.' is treated as a single a character wildcard (see third example), and '*' is matched for a zero or more sequence of the previous letter (see fourth and fifth examples). For more information on regular expression matching, see the Regular Expression Wikipedia page.

Explain your algorithm, and analyze its time and space complexities.

Examples:

input:  text = "aa", pattern = "a"
output: false

input:  text = "aa", pattern = "aa"
output: true

input:  text = "abc", pattern = "a.c"
output: true

input:  text = "abbb", pattern = "ab*"
output: true

input:  text = "acd", pattern = "ab*c."
output: true
	 */

	
	public static void main(String[] args) {

		String str = "aabbcc";
		String pattern = "a*c";
		System.out.println(isMatch(str, pattern));

	}
	static boolean isMatch(String text, String pattern) {

		return isMatchHelper(text, pattern, 0, 0);

	}

	static boolean isMatchHelper(String text, String pattern, int indexOfText, int indexOfPattern) {
		if (indexOfText >= text.length() && indexOfPattern >= pattern.length())

			return true;

		if (pattern.charAt(indexOfPattern) == '.') {

			indexOfText++;
			indexOfPattern++;

			return isMatchHelper(text, pattern, indexOfText, indexOfPattern);

		}

		//*
		if (indexOfPattern + 1 < pattern.length() && (pattern.charAt(indexOfPattern + 1) == '*'))
			return isMatchHelper(text, pattern, indexOfText, indexOfPattern + 2);

		// letter

		if (pattern.charAt(indexOfText) != text.charAt(indexOfText))

			return false;
		
		indexOfText++;
		indexOfPattern++;

		return isMatchHelper(text, pattern, indexOfText, indexOfPattern);
	}



}