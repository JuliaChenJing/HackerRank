
public class KMessedArraySort {

	static int[] sortKMessedArray(int[] arr, int k) {
		// your code goes here
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {

			if (i == 0)
				result[i] = helper(arr, i, k, -100);

			else
				result[i] = helper(arr, i, k, result[i - 1]);

		}

		return result;
	}

	static int helper(int[] arr, int location, int k, int front) {
		int min = 1000;
		for (int i = location - k; i <= location + k; i++) {
			if ((i >= 0) && (i < arr.length)) {
				if (arr[i] < min && arr[i] > front)
					min = arr[i];

			}

		}

		return min;

	}

	public static void main(String[] args) {

		int arr[] = { 1, 4, 5, 2, 3, 7, 8, 6, 10, 9 };
		int re[] = sortKMessedArray(arr, 3);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(re[i]);
			System.out.print(" ");

		}

	}
}
