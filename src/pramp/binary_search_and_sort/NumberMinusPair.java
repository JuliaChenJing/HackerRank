package pramp.binary_search_and_sort;

import java.util.*;

public class NumberMinusPair {

	// Tim Sort : Merge + Quick
	// Heap Sort: nlog
	// Merge: nlogn --> O(n)
	// https://en.wikipedia.org/wiki/Timsort
	// Time:O(nlogn) Space:O(n)
	// O(nlogn), O(1)
	static int[][] findPairsWithGivenDifference(int[] arr, int k) {
		// your code goes here
		List<int[]> list = new ArrayList<int[]>();
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {

			if (Arrays.binarySearch(arr, arr[i] + k) < 0)
				continue;
			else
				list.add(new int[] { arr[i], arr[i] + k });

			/*
			 * if( arr[i] + k == arr[middle]) list.add(new int { arr[i],
			 * arr[middle]}); else if( arr[i]+ k< arr[middle]) { middle=(start
			 * +end)/2;
			 * 
			 * 
			 * }
			 */

		}
		int[][] result = new int[list.size()][2];

		int i = 0;
		for (int[] temp : list) {
			result[i] = temp;
			i++;
		}

		return result;
	}

	public static void main(String[] args) {

		int[] arr = { 0, -1, -2, 2, 1 };
		int[][] result = findPairsWithGivenDifference(arr, 1);
		for (int i = 0; i < result.length; i++){
			for (int j = 0; j < result[0].length; j++)
				System.out.print(result[i][j]+" ");
			System.out.println();
		}
			

	}

}
