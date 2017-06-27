
import java.util.PriorityQueue;

public class DifferentSmallestNumber {
	/*
	 * Given an array arr of unique nonnegative integers, implement a function
	 * getDifferentNumber that finds the smallest nonnegative integer that is
	 * NOT in the array.
	 * 
	 * Even if your programming language of choice doesn’t have that restriction
	 * (like Python), assume that the maximum value an integer can have is
	 * MAX_INT = 2^31-1. So, for instance, the operation MAX_INT + 1 would be
	 * undefined in our case.
	 * 
	 * Your algorithm should be efficient, both from a time and a space
	 * complexity perspective.
	 * 
	 * Solve first for the case when you’re NOT allowed to modify the input arr.
	 * If successful and still have time, see if you can come up with an
	 * algorithm with an improved space complexity when modifying arr is
	 * allowed. Do so without trading off the time complexity.
	 * 
	 * Analyze the time and space complexities of your algorithm.
	 * 
	 * 
	 * Example:
	 * 
	 * 
	 * input: arr = [0, 1, 2, 3]
	 * 
	 * 
	 * output: 4 #
	 */
	public static void main(String[] args) {
		int arr[] = { 0, 1, 2, 3,3,4, 5 };
		System.out.println(getDifferentNumber_I(arr));
		System.out.println(getDifferentNumber_II(arr));
	}

	
		  
	//method one
	static int getDifferentNumber_I(int[] arr) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int i = 0; i < arr.length; i++) {
			
			pq.offer(arr[i]);
		}

		//System.out.println(pq);
		int i = 0;
		for (; i < arr.length; i++) {

			if (pq.poll() != i)
				return i;
		}

		return i + 1;
	}

	//method 2 , worst case will be consuming

	static int getDifferentNumber_II(int[] arr) {
		if (!find(0, arr))
			return 0;
		int max = max(arr);

		for (int i = 0; i <= max + 1; i++) {

			if (!find(i, arr))
				return i;
		}

		return max + 1;

	}

	// return if int num is in array
	static boolean find(int num, int[] arr) {
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == num)
				return true;
		}
		return false;
	}

	// return the max value in arr
	static int max(int[] arr) {
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}

}