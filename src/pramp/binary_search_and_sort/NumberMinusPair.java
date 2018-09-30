package pramp.binary_search_and_sort;

import java.util.*;

public class NumberMinusPair {
	// Tim Sort : Merge + Quick
	// Heap Sort: nlog
	// Merge: nlogn --> O(n)
	// https://en.wikipedia.org/wiki/Timsort
	// Time:O(nlogn) Space:O(n)
	// O(nlogn), O(1)

	/*
	 * Given an array arr of distinct integers and a nonnegative integer k,
	 * write a function findPairsWithGivenDifference that returns an array of
	 * all pairs [x,y] in arr, such that x - y = k. If no such pairs exist,
	 * return an empty array.
	 * 
	 * In your solution, try to reduce the memory usage while maintaining time
	 * efficiency. Prove the correctness of your solution and analyze its time
	 * and space complexities.
	 * 
	 * Note: the order of the pairs in the output array doesn’t matter.
	 * 
	 * Examples:
	 * 
	 * input: arr = [0, -1, -2, 2, 1], k = 1 
	 * output: [[0, -1], [-1, -2], [2, 1],
	 * [1, 0]]
	 * 
	 * input: arr = [1, 7, 5, 3, 32, 17, 12], k = 17 
	 * output: []
	 */
	
	public static void main(String[] args) {
		int[] arr = { 0, -1, -2, 2, 1 };
		int[][] result = findPairsWithGivenDifference(arr, 1);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++)
				System.out.print(result[i][j] + " ");
			System.out.println();
		}
	}
	
	static int[][] findPairsWithGivenDifference(int[] arr, int k) {
		List<int[]> list = new ArrayList<int[]>();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (Arrays.binarySearch(arr, arr[i] + k) < 0)
				continue;
			else
				list.add(new int[] { arr[i], arr[i] + k });
		}
		int[][] result = new int[list.size()][2];
		int i = 0;
		for (int[] temp : list) {
			result[i] = temp;
			i++;
		}
		return result;
	}
}
