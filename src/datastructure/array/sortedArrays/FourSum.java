package datastructure.array.sortedArrays;

import java.util.Arrays;

public class FourSum {

	
	public static void main(String[] args) {

		int[] arr = { 2, 7, 4, 0, 9, 5, 1, 3 };
		int[] result_1 = fourSum(arr, 20);//slow but easy to understand
		int[] result_2 =findArrayQuadruplet(arr, 20);//good
		for (int i = 0; i < 4; i++)
			System.out.print(result_1[i]);
		System.out.println();
		for (int i = 0; i < 4; i++)
			System.out.print(result_2[i]);
	}
	
	static int third = 0;
	static int fourth = 0;

	// arr = [2, 7, 4, 0, 9, 5, 1, 3], s = 20
	static int[] findArrayQuadruplet(int[] arr, int s) {
		// your code goes here
		Arrays.sort(arr);

		int[] result = new int[4];
		int first = 0;

		int second = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1; j < arr.length - 2; j++) {
				first = arr[i];
				second = arr[j];
				if (findHelper(arr, s - first - second, j)) {

					result[0] = first;
					result[1] = second;
					result[2] = third;
					result[3] = fourth;
					return result;

				}

			}

		}
		return null;
	}

	static boolean findHelper(int[] arr, int s, int start) {
		int first = start;
		int last = arr.length - 1;
		while (first < last) {
			if (arr[first] + arr[last] == s) {

				third = arr[first];
				fourth = arr[last];
				return true;
			} else if (arr[first] + arr[last] < s)
				first++;
			else
				last--;
		}

		return false;

	}

	public static int[] fourSum(int[] a, int sum) {
		int n = a.length;
		int[] result = new int[4];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					for (int l = k + 1; l < n; l++) {
						if (a[i] + a[j] + a[k] + a[l] == sum) {
							result[0] = a[i];
							result[1] = a[j];
							result[2] = a[k];
							result[3] = a[l];
						}
					}
				}
			}
		}
		Arrays.sort(result);
		return result;
	}

	
}
