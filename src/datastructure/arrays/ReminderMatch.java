package datastructure.arrays;

class ReminderMatch {
	/*
	 * 给定N个整数，N为偶数，是否能找到N/2对，使得每对和能被K整除。注意：每个元素只能出现在一个配对中。
	 * 观察：如果某个数能被k整除，那么该数除以k的余数为0。假设a和b之和能被k整除，即（a+b）%k=0，如果a%k=z，那么当z不等于0时，b%k=
	 * k-z；当z=0时，b%k=0。通过上面的推倒，我们需要记录这个数组除以k之后的余数情况。然后从余数里找出配对。
	 * 使用额外的一组数组保存余数情况，数组大小为k，A【i】记录余数为i的元素的个数。有了这个余数个数的数组之后，我们需要考虑如下边界情况：
	 * 先验条件：被k整除的个数是否为偶数？如果是奇数，那么就不可能找到和被k整除。
	 */
	static boolean checkPairable(int[] nums, int k) {
		if (k <= 0)
			return false;

		// 额外数组保存余数情况
		int[] counts = new int[k];
		for (int num : nums) {
			// 初始化余数数组,counts[i]保存的是余数为i的个数
			counts[num % k]++;
		}

		// 整除k的个数若不是偶数，返回false
		if (counts[0] % 2 != 0)
			return false;

		// k是偶数时，查看余数为k/2的个数是否为偶数
		if (k % 2 == 0) {
			if (counts[k / 2] % 2 != 0)// 如果余数为k的一半的个数不是偶数，直接返回false
				return false;
		}
		for (int i = 1; i <= k / 2; i++) {
			// 余数配对
			if (counts[i] != counts[k - i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 4, 6 };
		System.out.println(checkPairable(nums, 5));
	}

}
