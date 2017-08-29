package datastructure.string;

public class StrStr {

	public static void main(String[] args) {
		System.out.println(strStr("bananaapple", "apple"));
	}

	public static int strStr(String haystack, String needle) {
		for (int i = 0; i < haystack.length(); i++) {
			if (concludes(haystack, needle, i))
				return i;
		}
		return -1;
	}

	private static boolean concludes(String haystack, String needle, int start) {
		if (haystack.length() - start < needle.length())
			return false;
		else {
			for (int i = 0; i < needle.length(); i++) {
				if (needle.charAt(i) != haystack.charAt(i + start))
					return false;
			}
			return true;
		}

	}
}
