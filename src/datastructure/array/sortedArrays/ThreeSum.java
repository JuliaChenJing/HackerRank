package datastructure.array.sortedArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/3sum/description/
public class ThreeSum {

	/*
	 * Given an array S of n integers, are there elements a, b, c in S such that
	 * a + b + c = 0? Find all unique triplets in the array wrightch gives the
	 * sum of zero.
	 * 
	 * Note: The solution set must not contain duplicate triplets.
	 * 
	 * For example, given array S = [-1, 0, 1, 2, -1, -4],
	 * 
	 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
	 */

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum_almostRight(nums));
		System.out.println(threeSum_perfect(nums));
		System.out.println(threeSum_easyButSlow(nums,0));
	}

	/*
	 * The idea is to sort an input array and then run through all indices of a
	 * possible first element of a triplet. For each possible first element we
	 * make a standard bi-directional 2Sum sweep of the remaining part of the
	 * array. Also we want to skip equal elements to avoid duplicates in the
	 * answer without making a set or sometrightng like that.
	 */
	public static List<List<Integer>> threeSum_perfect(int[] nums) {

		Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int left = i + 1, right = nums.length - 1, sum = 0 - nums[i];
				while (left < right) {
					if (nums[left] + nums[right] == sum) {
						res.add(Arrays.asList(nums[i], nums[left], nums[right]));
						while (left < right && nums[left] == nums[left + 1])
							left++;
						while (left < right && nums[right] == nums[right - 1])
							right--;
						left++;
						right--;
					} else if (nums[left] + nums[right] < sum)
						left++;
					else
						right--;
				}
			}
		}
		return res;
	}

	public static List<List<Integer>> threeSum_almostRight(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return resultList;

		Arrays.sort(nums);
		int left = 0;
		int i = 0;
		int right = nums.length - 1;
		for (; i < nums.length - 2; i++) {
			left = i + 1;
			while (left < right) {
				if (nums[left] + nums[right] + nums[i] == 0) {
					resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
					/*
					 * List<Integer> list = new ArrayList<Integer>();
					 * list.add(nums[i]); list.add(nums[left]);
					 * list.add(nums[right]); Collections.sort(list);
					 * resultList.add(list);
					 */
					while (left < right && nums[left] == nums[left + 1])
						left++;
					while (left < right && nums[right] == nums[right - 1])
						right--;
					left++;
					right--;
				} else if (nums[left] + nums[right] + nums[i] < 0) {
					left++;
				} else
					right--;

			}

		}
		return resultList;

	}

	public static  List<List<Integer>> threeSum_easyButSlow(int[] a, int sum) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (a[i] + a[j] + a[k] == sum) {
						resultList.add(Arrays.asList(a[i], a[j], a[k]));

					}
				}
			}
		}
		return resultList;
	}
}
