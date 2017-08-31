package datastructure.array.sortedArrays;

//https://leetcode.com/problems/search-for-a-range/description/
public class SearchForARange {

	/*
	 * Given an array of integers sorted in ascending order, find the starting
	 * and ending position of a given target value.
	 * 
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * 
	 * If the target is not found in the array, return [-1, -1].
	 * 
	 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
	 */

	public static void main(String[] args) {
		int[] re = searchRange_perfect(new int[] { 5, 7, 7, 8, 8, 10 }, 8);
		System.out.println(re[0] + " " + re[1]);
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] re = { -1, -1 };

		int left = 0;
		int right = nums.length - 1;
		boolean leftFound = false;
		boolean rightFound = false;

		while (left <= right && nums[left] <= target && nums[right] >= target) {
			if (leftFound != true) {
				if (nums[left] == target) {
					leftFound = true;
					re[0] = left;

				} else
					left++;
			}

			if (rightFound != true) {
				if (nums[right] == target) {
					rightFound = true;
					re[1] = right;

				} else
					right--;
			}
			if (leftFound == true && rightFound == true)
				break;

		}

		return re;
	}

	public static int[] searchRange_perfect(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = findFirst(nums, target);
		result[1] = findLast(nums, target);
		return result;
	}

	private static int findFirst(int[] nums, int target) {
		int idx = -1;
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] >= target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			if (nums[mid] == target)
				idx = mid;
		}
		return idx;
	}

	private static int findLast(int[] nums, int target) {
		int idx = -1;
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] <= target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			if (nums[mid] == target)
				idx = mid;
		}
		return idx;
	}
}
