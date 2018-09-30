package pramp.binary_search_and_sort;

import java.util.*;

public class NumberMinusPair {

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
	 * input: A = [0, -1, -2, 2, 1], k = 1 
	 * output: [[0, -1], [-1, -2], [2, 1],
	 * [1, 0]]
	 * 
	 * input: A = [1, 7, 5, 3, 32, 17, 12], k = 17 
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

	static int[][] findPairsWithGivenDifference(int[] A, int k) {

		List<int[]> listOfArray = new ArrayList<int[]>();
		Arrays.sort(A);

		for (int i = 0; i < A.length; i++) {
			if (Arrays.binarySearch(A, A[i] + k) < 0)
				continue;
			else
				listOfArray.add(new int[] { A[i], A[i] + k });
		}

		// transfer List<int[]> list to int[][] result
		int[][] arrayOfArray = new int[listOfArray.size()][2];
		int i = 0;

		for (int[] array : listOfArray) {
			arrayOfArray[i] = array;
			i++;
		}

		return arrayOfArray;
	}
}
