package datastructure.array.sortedArrays;

import java.util.Arrays;

public class Sum_IIIClosest {

	public static int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 2)
			return -1;
		int closestNumber = nums[0] + nums[1] + nums[2];
		int sum = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					sum = nums[i] + nums[j] + nums[k];
					// System.out.println(Math.abs(closestNumber - target));
					if (Math.abs(closestNumber - target) > Math.abs(sum - target)) {
						closestNumber = sum;

					}

				}
			}
		}

		return closestNumber;

	}

	

	public int threeSumClosest_perfect(int[] num, int target) {
		int result = num[0] + num[1] + num[num.length - 1];
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1, end = num.length - 1;
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				if (sum > target) {
					end--;
				} else {
					start++;
				}
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
			}
		}
		return result;

	}

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[] { 1, 1, -1, -1, 3 }, -1));
	}
}
