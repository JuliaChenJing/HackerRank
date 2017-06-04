package datastructure.string;

//Write a method to replace all spaces in a string with ‘%20’.
public class ReplaceSpace {

	public static String replaceSpace(String s) {

		if ((s != null && s.length() == 0) || s == null)
			return s;
		StringBuffer re = new StringBuffer();

		for (int i = 0; i < s.length(); i++)

			if (s.charAt(i) == ' ')
				re.append("%20");

			else
				re.append(s.charAt(i));

		return re.toString();
	}

	/*
	 * The algorithm is as follows: 1. Count the number of spaces during the
	 * first scan of the string. 2. Parse the string again from the end and for
	 * each character: » 3 If a space is encountered, store “%20”. » Else, store
	 * the character as it is in the newly shifted location.
	 */


	public static void main(String[] args) {

		System.out.println(replaceSpace("ab"));
		System.out.println(replaceSpace(""));
		System.out.println(replaceSpace("  "));
		System.out.println(replaceSpace("a b"));
		System.out.println(replaceSpace(null));

		
	}
}
