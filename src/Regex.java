public class Regex {

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

	public static void main(String[] args) {

		String str = "aabbcc";
		String pattern = "a*c";
		System.out.println(isMatch(str, pattern));

	}

}