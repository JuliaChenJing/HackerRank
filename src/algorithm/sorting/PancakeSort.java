package algorithm.sorting;

public class PancakeSort {

	static int[] pancakeSort(int[] arr) {
		// your code goes here

		// 1 5 4 3 2
		// length=5

		// 5 1 4 3 2 done
		// 2 3 4 1 5 done

		// 4 3 2 1 5
		// 1 2 3 4 5
		int indexOfMax = 0;
		for (int i = arr.length - 1; i > 1; i--) {
			indexOfMax = findIndexOfMax(arr, i);
			flip(arr, indexOfMax + 1);
			flip(arr, i + 1);
		}

		return arr;
	}

	static int findIndexOfMax(int[] arr, int endOfIndex) {
		int max = Integer.MIN_VALUE;
		int indexOfMax = 0;
		for (int i = 0; i <= endOfIndex; i++) {
			if (arr[i] > max) {
				max = arr[i];
				indexOfMax = i;
			}
		}
		return indexOfMax;

	}

	static int[] flip(int[] arr, int k) {

		if (k > arr.length)
			return null;

		int temp;
		for (int i = 0; i < k / 2; i++) {
			temp = arr[i];
			arr[i] = arr[k - i - 1];
			arr[k - i - 1] = temp;
		}
		return arr;

	}

	public static void main(String[] args) {

		int[] a = { 2, 3, 7, 8, 1 };
		int[] result = pancakeSort(a);

		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}
}
