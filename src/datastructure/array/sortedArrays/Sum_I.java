package datastructure.array.sortedArrays;

import java.util.*;

//给定一个整形数组，是�?�能找出其中的两个数使其和为一个指定的值

public class Sum_I {

	// if the array is sorted
	static boolean hasSum(int[] A, int N) {
		boolean res = false;
		if (A == null || A.length < 2)
			return res;

		Arrays.sort(A);

		int i = 0;
		int j = A.length - 1;
		while (i < j) {
			if (A[i] + A[j] == N) {
				res = true;
				break;
			} else if (A[i] + A[j] > N) {
				j--;
			} else {
				i++;
			}
		}
		return res;
	}

	// if the array is not sorted, you can not do this way. because index will
	// be wrong
	static int[] getIndicesOfItemWights(int[] arr, int limit) {
		// your code goes here
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length - 1;
		int[] result = new int[2];

		while (start < end) {
			if (arr[start] + arr[end] == limit) {
				result[0] = start;
				result[1] = end;
				return result;
			} else if (arr[start] + arr[end] < limit)
				start++;
			else
				end--;
		}

		return null;
	}

	public static void main(String[] args) {

		System.out.println(hasSum(new int[] { 3, 4, 1, 2, 9 }, 4));
		int[] arr = { 4, 6, 10, 15, 16 };
		int[] result = getIndicesOfItemWights(arr, 21);
		if (result == null)
			System.out.println("null");
		else {
			System.out.println(result[0]);
			System.out.println(result[1]);
		}
	}
}
