package pramp.strings;

public class RegEx {

	/*
	 * Implement a regular expression function isMatch that supports the '.' and
	 * '*' symbols. The function receives two strings - text and pattern - and
	 * should return true if the text matches the pattern as a regular
	 * expression. For simplicity, assume that the actual symbols '.' and '*' do
	 * not appear in the text string and are used as special symbols only in the
	 * pattern string.
	 * 
	 * In case you aren’t familiar with regular expressions, the function
	 * determines if the text and pattern are the equal, where the '.' is
	 * treated as a single a character wildcard (see third example), and '*' is
	 * matched for a zero or more sequence of the previous letter (see fourth
	 * and fifth examples). For more information on regular expression matching,
	 * see the Regular Expression Wikipedia page.
	 * 
	 * Explain your algorithm, and analyze its time and space complexities.
	 * 
	 * Examples:
	 * 
	 * input: text = "aa", pattern = "a" output: false
	 * 
	 * input: text = "aa", pattern = "aa" output: true
	 * 
	 * input: text = "abc", pattern = "a.c" output: true
	 * 
	 * input: text = "abbb", pattern = "ab*" output: true
	 * 
	 * input: text = "acd", pattern = "ab*c." output: true
	 */

	public static void main(String[] args) {

		System.out.println(isMatch("", "*"));
		System.out.println(isMatch("abc", "ab*"));
		System.out.println(isMatch("c", "*"));
		System.out.println(isMatch("abc", "a.c"));
		System.out.println(isMatch("abc", "*a"));
		System.out.println(isMatch("abc", ".b*"));

	}

	/*
	 * 
	 * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
       2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
       3, If p.charAt(j) == '*': 
          here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
	 */
	public boolean isMatch_perfect(String s, String p) {

		if (s == null || p == null) {
			return false;
		}
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*' && dp[0][i - 1]) {
				dp[0][i + 1] = true;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == '.') {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p.charAt(j) == s.charAt(i)) {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p.charAt(j) == '*') {
					if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
					} else {
						dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}

	static boolean isMatch(String text, String pattern) {

		return isMatchHelper(text, pattern, 0, 0);

	}

	static boolean isMatchHelper(String text, String pattern, int textIndex, int patIndex) {
		// base cases - one of the indexes reached the end of text or pattern
		if (textIndex >= text.length()) {
			if (patIndex >= pattern.length())
				return true;
			else {
				if ((patIndex + 1 < pattern.length()) && (pattern.charAt(patIndex + 1) == '*'))
					return isMatchHelper(text, pattern, textIndex, patIndex + 2);
				else
					return false;
			}
		}

		else if ((patIndex >= pattern.length()) && (textIndex < text.length()))
			return false;

		// string matching for '.'
		else if (pattern.charAt(patIndex) == '.') {

			textIndex++;
			patIndex++;

			return isMatchHelper(text, pattern, textIndex, patIndex);

		}

		// string matching for letter

		else if (pattern.charAt(patIndex) == text.charAt(textIndex)) {

			textIndex++;
			patIndex++;

			return isMatchHelper(text, pattern, textIndex, patIndex);
		}

		// # string matching for character followed by '*'
		else if ((patIndex + 1 < pattern.length()) && (pattern.charAt(patIndex + 1) == '*'))
			if ((pattern.charAt(patIndex) == '.') || (text.charAt(textIndex) == pattern.charAt(patIndex)))
				return (isMatchHelper(text, pattern, textIndex, patIndex + 2)
						|| isMatchHelper(text, pattern, textIndex + 1, patIndex));
			else
				return isMatchHelper(text, pattern, textIndex, patIndex + 2);
		else
			return false;
	}

}