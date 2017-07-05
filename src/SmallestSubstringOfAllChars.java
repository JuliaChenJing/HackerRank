import java.util.HashMap;

public class SmallestSubstringOfAllChars {

	/*
	 * Given an array of unique characters arr and a string str, Implement a
	 * function getShortestUniqueSubstring that finds the smallest substring of
	 * str containing all the characters in arr. Return "" (empty string) if
	 * such a substring doesn’t exist.
	 * 
	 * Come up with an asymptotically optimal solution and analyze the time and
	 * space complexities.
	 * 
	 * Example:
	 * 
	 * input: arr = ['x','y','z','a'], str = "xayyzyzyx"
	 * 
	 * output: "zyx"
	 */

	public static void main(String[] args) {
		char[] arr = { 'x', 'y', 'z', 'a' };
		System.out.println(getShortestUniqueSubstring(arr, "xayyzyzyx"));
	}

	static String getShortestUniqueSubstring(char[] arr, String str) {
		int headIndex = 0;
		String result = "";
		int uniqueCounter = 0;
		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

		// initialize countMap
		for (int i = 0; i < arr.length; i++)
			hashmap.put(arr[i], 0);

		// scan str
		for (int tailIndex = 0; tailIndex < str.length(); tailIndex++) {
			// handle the new tail
			char tailChar = str.charAt(tailIndex);

			// skip all the characters not in arr
			if (!hashmap.containsKey(tailChar))
				continue;

			int tailCount = hashmap.get(tailChar);
			if (tailCount == 0)
				uniqueCounter = uniqueCounter + 1;

			hashmap.put(tailChar, tailCount + 1);

			// push head forward
			while (uniqueCounter == arr.length) {
				int tempLength = tailIndex - headIndex + 1;
				if (tempLength == arr.length)
					// return a substring of str from
					// headIndex to tailIndex (inclusive)
					return str.substring(headIndex, tailIndex + 1);

				if (result == "" || tempLength < result.length())
					// return a substring of str from
					// headIndex to tailIndex (inclusive)
					result = str.substring(headIndex, tailIndex + 1);

				char headChar = str.charAt(headIndex);

				if (hashmap.containsKey(headChar)) {
					int headCount = hashmap.get(headChar) - 1;
					if (headCount == 0) {
						uniqueCounter = uniqueCounter - 1;
						hashmap.put(headChar, headCount);
					}
				}
				headIndex = headIndex + 1;
			}

		}
		return result;
	}
}
