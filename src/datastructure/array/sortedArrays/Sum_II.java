package datastructure.array.sortedArrays;

import java.util.Arrays;
import java.util.HashMap;
//https://leetcode.com/problems/two-sum/description/
public class Sum_II {
	public static void main(String[] args) {
		int[] a = twoSum(new int[] { 1, 2, 5, 3, 4 }, 4);// 1+3=4
		System.out.println("下标:" + a[0]);// 输出下标3
		System.out.println("下标:" + a[1]);// 输出下标0
	}

	static int[] twoSum(int[] nums, int target) {
		int[] res = { -1, -1 };

		if (nums == null || nums.length < 2)
			return res;

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			//to avoid having duplicates
			if (hm.containsKey(target - nums[i]) && target != 2 * nums[i]) {
				res[0] = i;
				res[1] = hm.get(target - nums[i]);
				Arrays.sort(res);
				break;
			} else
				hm.put(nums[i], i);
		}

		return res;
	}
}
