package datastructure.string;
/**
 * Class: Fundamental Programming Practice <br />
 * 
 * @author "Jing Chen" <br />
 *         Description:Merge the two sorted string into a single sorted
 *         string<br />
 */
import java.util.Arrays;

public class MergeStrings {
	static String mergeStrings(String[] strings) {

		if (strings == null)
			return "";
		StringBuffer sb = new StringBuffer();
		for (String str : strings) {
			str = str.replaceAll("[^a-z]+", "");
			sb.append(str);
		}

		char[] array = sb.toString().toCharArray();
		Arrays.sort(array);
		return String.valueOf(array);

	}

	static StringBuilder ret = new StringBuilder();

	public static String merge(String s, String t) {
		if (s.isEmpty() && t.isEmpty())
			return ret.toString();
		
		if (s.isEmpty()) {
			ret.append(t);
			return ret.toString();
		}
		if (t.isEmpty()) {
			ret.append(s);
			return ret.toString();
		}
		
		if (s.charAt(0) <= t.charAt(0)) {
			ret.append(s.charAt(0));
			return merge(s.substring(1), t);
		} else {
			ret.append(t.charAt(0));
			return merge(s, t.substring(1));
		}

	}

	public static void main(String[] args) {
	
		System.out.println(merge("ace", "bdefl"));
		
		String[] strings={"ace", "bdefl","opq"};
		System.out.println(mergeStrings(strings));
	}

}

/*
 * output: abcdeefl
 */