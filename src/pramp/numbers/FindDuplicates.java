package pramp.numbers;

import java.util.ArrayList;

public class FindDuplicates {

	public static void main(String[] args) {

		int[] arr1 = { 1, 2, 3, 5, 6, 7 };
		int[] arr2 = { 3, 6, 7, 8, 20 };
		int[] arr3 = { 8, 20 };

		// when length of arr1 and arr2 are almost the same
		int[] re = findDuplicates(arr1, arr2);

		/*
		 * when length of arr1 and arr2 are of big difference, try to find each
		 * element from the short array in the big array using binary search
		 * since the array is sorted originally
		 */
		int[] re_BinarySearch = findDuplicatesWithBinarySearch(arr2, arr3);
		for (int i = 0; i < re.length; i++)
			System.out.print(re[i] + " ");

		System.out.println();

		for (int i = 0; i < re_BinarySearch.length; i++)
			System.out.print(re_BinarySearch[i] + " ");

	}

	// when length of arr1 and arr2 are almost the same

	/*
	 * Time Complexity: O(N+M) since in the worst case scenario we traverse both
	 * arrays once. Note that O(N+M) is a linear time complexity because the
	 * input size is O(N+M) as well.
	 * 
	 * Space Complexity: the variable duplicates is the only dynamic auxiliary
	 * space we’re using in the algorithm. In the worst case scenario, the size
	 * of duplicates is going to be as big as big as the smaller input array.
	 * For instance, when the smaller array is fully contained within the bigger
	 * one. The space complexity is therefore O(N), where N ≤ M.
	 */

	static int[] findDuplicates(int[] arr1, int[] arr2) {

		int pointer1 = 0;
		int pointer2 = 0;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		while (pointer1 < arr1.length && pointer2 < arr2.length) {
			if (arr1[pointer1] == arr2[pointer2]) {
				arrayList.add(arr1[pointer1]);
				pointer1++;
				pointer2++;
			}

			else if (arr1[pointer1] < arr2[pointer2])
				pointer1++;

			else // arr1[pointer1]>arr2[pointer2

				pointer2++;
		}

		int[] result = new int[arrayList.size()];
		int locationInResult = 0;
		for (int i : arrayList) {
			result[locationInResult] = i;
			locationInResult++;

		}

		return result;

	}

	/*
	 * when length of arr1 and arr2 are of big difference, try to find each
	 * element from the short array in the big array using binary search since
	 * the array is sorted originally
	 * 
	 * 
	 * Time Complexity: we running a binary search on arr2 N times. Hence the
	 * time complexity is O(N⋅log(M)). So why is this algorithm better than the
	 * previous one when M ≫ N? To demonstrate that let’s analyze the case that
	 * M = N^C, where C is a constant such that C 2. In this case, the time
	 * complexity of the second algorithm is: O(N⋅log(M)) = O(N⋅log(N^C)) =
	 * O(C⋅N⋅log(N)) = O(N⋅log(N)) And the time complexity of the first
	 * algorithm is: O(N + M) = O(N + N^C) = O(N^C) As we all know O(N^C) >
	 * O(N⋅log(N)).
	 * 
	 * Space Complexity: the variable duplicates is the only dynamic auxiliary
	 * space we’re using in the algorithm. In the worst case scenario, the size
	 * of duplicates is going to be as big as big as the smaller input array.
	 * For instance, when the smaller array is fully contained within the bigger
	 * one. The space complexity is therefore O(N), where N ≤ M.
	 * 
	 */
	static int[] findDuplicatesWithBinarySearch(int[] arr1, int[] arr2) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		for (int number : arr1)
			if (binarySearch(arr2, number) != -1)
				arrayList.add(number);

		int[] result = new int[arrayList.size()];
		int locationInResult = 0;
		for (int i : arrayList) {
			result[locationInResult] = i;
			locationInResult++;

		}

		return result;
	}

	/**
	 * find the index of key in a sorted array
	 */
	public static int binarySearch(int[] array, int key) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (key < array[mid])
				high = mid - 1;
			else if (key > array[mid])
				low = mid + 1;

			else
				return mid;
		}
		return -1;
	}

}
