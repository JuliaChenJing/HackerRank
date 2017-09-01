package datastructure.array.sortedArrays;

//https://leetcode.com/problems/search-insert-position/description/
public class SearchInsertPosition {

	/*
	 * Given a sorted array and a target value, return the index if the target
	 * is found. If not, return the index where it would be if it were inserted
	 * in order.
	 * 
	 * You may assume no duplicates in the array.
	 * 
	 * Here are few examples. [1,3,5,6], 5 → 2 [1,3,5,6], 2 → 1 [1,3,5,6], 7 → 4
	 * [1,3,5,6], 0 → 0
	 */

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 5));// 2
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 2));// 1
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 7));// 4
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 0));// 0
	}

	public static int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int middle;
		while (left <= right) {
			middle = (right + left) / 2;
			if (nums[middle] == target) {
				return middle;
			}
			if (nums[middle] < target) {
				left = middle + 1;

			} else
				right = middle - 1;
		}
		return left;

	}
}
