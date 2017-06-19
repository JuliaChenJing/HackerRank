package algorithm.sorting;

public class MergeSort {
	/*
	 * Sort each pair of elements. Then, sort every four elements by merging
	 * every two pairs. Then, sort every 8 elements, etc. O(n log n) expected
	 * and worst case.
	 */

	private int[] numbers;
	private int[] helper;

	private int number;

	public void mergeSort(int[] values) {
		this.numbers = values;
		number = values.length;
		this.helper = new int[number];
		mergeSortHelper(0, number - 1);
	}

	private void mergeSortHelper(int low, int high) {
		// check if low is smaller than high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			mergeSortHelper(low, middle);
			// Sort the right side of the array
			mergeSortHelper(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}

	}

}
