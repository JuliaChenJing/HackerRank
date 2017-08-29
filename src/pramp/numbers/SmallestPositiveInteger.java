package pramp.numbers;

import java.util.Arrays;

public class SmallestPositiveInteger {
	/*
	 * Write a function:
	 * 
	 * class Solution { public int solution(int[] A); }
	 * 
	 * that, given an array A of N integers, returns the smallest positive
	 * integer (greater than 0) that does not occur in A.
	 * 
	 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
	 * 
	 * For another example, given A = [1, 2, 3], the function should return 4.
	 * 
	 * Given A = [−1, −3], the function should return 1.
	 */

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 5 }));// 4
		System.out.println(solution(new int[] { 1, 3, 6, 4, 1, 2 }));// 5
		System.out.println(solution(new int[] { -1, 1, 2, 3, 5 }));// 4
	}

	public static int solution(int[] A) {
		if (A == null || A.length == 0)
			return 1;
		Arrays.sort(A);
		int i = 1;
		for (int n : A) {
			if (n <= 0)
				continue;
			else {
				if (n == i - 1)
					continue;
				if (n != i) {
					return i;
				} else

					i++;
			}

		}
		return i;
	}
}
