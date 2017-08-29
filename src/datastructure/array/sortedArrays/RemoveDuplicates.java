package datastructure.array.sortedArrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class RemoveDuplicates {

	public static void main(String[] args) {
		System.out.println(removeDuplicates_perfect(new int[] {}));
		System.out.println(removeDuplicates_perfect(new int[] { 1, 1 }));
		System.out.println(removeDuplicates_perfect(new int[] { 1, 1, 2 }));
	}

	/*
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place
	 * with constant memory.
	 * 
	 * For example, Given input array nums = [1,1,2],
	 * 
	 * Your function should return length = 2, with the first two elements of
	 * nums being 1 and 2 respectively. It doesn't matter what you leave beyond
	 * the new length.
	 */

	public static int removeDuplicates_perfect(int[] nums) {
		int i = nums.length > 0 ? 1 : 0;
		for (int n : nums)
			if (n > nums[i - 1])
				nums[i++] = n;
		return i;
	}

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return 1;
		int n = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				n++;
			} else {
				// move all values forward
				for (int j = i; j < nums.length - n - 1; j++) {
					nums[j] = nums[j + 1];
				}
				i--;
			}

		}

		return n;
	}

}
