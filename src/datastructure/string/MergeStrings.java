package datastructure.string;

import java.util.Arrays;
public class MergeStrings {
	static String MergeStrings(String[] strings) {

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


}