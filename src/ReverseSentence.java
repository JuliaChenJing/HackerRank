public class ReverseSentence {

	/*
	 * You are given an array of characters arr that consists of sequences of
	 * characters separated by space characters. Each space-delimited sequence
	 * of characters defines a word.
	 * 
	 * Implement a function reverseWords that reverses the order of the words in
	 * the array in the most efficient manner.
	 * 
	 * Explain your solution and analyze its time and space complexities.
	 * 
	 * input: arr = [ 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k',
	 * 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]
	 * 
	 * output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', ' ', 'm', 'a', 'k',
	 * 'e', 's', ' ', 'p', 'e', 'r', 'f', 'e', 'c', 't' ]
	 */
	static char[] reverseWords(char[] arr) {
		// your code goes here
		reverseHelper(arr, 0, arr.length - 1);
		int start = 0;
		int end = 0;
		int location = 0;

		while (location < arr.length) {
			if (arr[location] == ' ') {

				end = location - 1;
				reverseHelper(arr, start, end);

				location++;
				start = location;
				end = location;
			} else
				location++;
		}

		reverseHelper(arr, start, arr.length - 1);// don't forget this step

		return arr;
	}

	static void reverseHelper(char[] arr, int start, int end) {

		char temp;
		while (start <= end) {

			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			start++;
			end--;

		}

	}

	public static void main(String[] args) {

		char[] arr = { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't',
				'i', 'c', 'e' };
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]);

		System.out.println();

		char[] result = reverseWords(arr);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i]);
	}

}
