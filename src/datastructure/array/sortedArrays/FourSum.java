package datastructure.array.sortedArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {

		int[] arr = { 2, 7, 4, 0, 9, 5, 1, 3 };
		int[] result_1 = fourSum(arr, 20);// slow but easy to understand
		int[] result_2 = findArrayQuadruplet(arr, 20);// good
		for (int i = 0; i < 4; i++)
			System.out.print(result_1[i]);
		System.out.println();
		for (int i = 0; i < 4; i++)
			System.out.print(result_2[i]);
		System.out.println();
		System.out.println(fourSum_perfect(arr, 20));
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

	public static List<List<Integer>> fourSum_perfect(int[] nums, int target) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (nums == null || len < 4)
			return res;

		Arrays.sort(nums);

		int max = nums[len - 1];
		if (4 * nums[0] > target || 4 * max < target)
			return res;

		int i, z;
		for (i = 0; i < len; i++) {
			z = nums[i];
			if (i > 0 && z == nums[i - 1])// avoid duplicate
				continue;
			if (z + 3 * max < target) // z is too small
				continue;
			if (4 * z > target) // z is too large
				break;
			if (4 * z == target) { // z is the boundary
				if (i + 3 < len && nums[i + 3] == z)
					res.add(Arrays.asList(z, z, z, z));
				break;
			}

			threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
		}

		return res;
	}

	/*
	 * Find all possible distinguished three numbers adding up to the target in
	 * sorted array nums[] between indices low and high. If there are, add all
	 * of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, the three numbers))
	 */
	public static void threeSumForFourSum(int[] nums, int target, int low, int high,
			ArrayList<List<Integer>> fourSumList, int z1) {
		if (low + 1 >= high)
			return;

		int max = nums[high];
		if (3 * nums[low] > target || 3 * max < target)
			return;

		int i, z;
		for (i = low; i < high - 1; i++) {
			z = nums[i];
			if (i > low && z == nums[i - 1]) // avoid duplicate
				continue;
			if (z + 2 * max < target) // z is too small
				continue;

			if (3 * z > target) // z is too large
				break;

			if (3 * z == target) { // z is the boundary
				if (i + 1 < high && nums[i + 2] == z)
					fourSumList.add(Arrays.asList(z1, z, z, z));
				break;
			}

			twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
		}

	}

	/*
	 * Find all possible distinguished two numbers adding up to the target in
	 * sorted array nums[] between indices low and high. If there are, add all
	 * of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
	 */
	public static void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1, int z2) {

		if (low >= high)
			return;

		if (2 * nums[low] > target || 2 * nums[high] < target)
			return;

		int i = low, j = high, sum, x;
		while (i < j) {
			sum = nums[i] + nums[j];
			if (sum == target) {
				fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

				x = nums[i];
				while (++i < j && x == nums[i]) // avoid duplicate
					;
				x = nums[j];
				while (i < --j && x == nums[j]) // avoid duplicate
					;
			}
			if (sum < target)
				i++;
			if (sum > target)
				j--;
		}
		return;
	}

}
