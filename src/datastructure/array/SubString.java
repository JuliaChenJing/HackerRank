package datastructure.array;

public class SubString {

	public static boolean isRotation(String s1, String s2) {
		int len = s1.length();

		/* check that s1 and s2 are equal length and not empty */
		if (len == s2.length() && len > 0) {
			
			/* concatenate s1 and s1 within new buffer */
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}

	private static boolean isSubstring(String s1, String s2) {

		return s1.contains(s2);
	}

	public static void main(String[] args) {
		System.out.println(isSubstring("applepie", "apple"));
		System.out.println(isRotation("applepie", "pieapple"));
	}
}
