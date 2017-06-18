package datastructure.array;

class ReminderMatch {
	/*
	 * Given N integers, N is even, return if N/2 pairs of numbers whose sum
	 * could be devided by k
	 * 给定N个整数，N为�?�数，是�?�能找到N/2对，使得�?对和能被K整除。注�?：�?个元素�?�能出现在一个�?对中。
	 * 观察：如果�?个数能被k整除，那么该数除以k的余数为0。�?�设a和b之和能被k整除，�?�（a+b）%k=0，如果a%k=z，那么当z�?
	 * 等于0时，b%k=
	 * k-z；当z=0时，b%k=0。通过上�?�的推倒，我们需�?记录这个数组除以k之�?�的余数情况。然�?�从余数里找出�?对。
	 * 使用�?外的一组数组�?存余数情况，数组大�?为k，A�?i】记录余数为i的元素的个数。有了这个余数个数的数组之�?�，我们需�?
	 * 考虑如下边界情况： 先验�?�件：被k整除的个数是�?�为�?�数？如果是奇数，那么就�?�?�能找到和被k整除。
	 */
	static boolean checkPairable(int[] nums, int k) {
		if (k <= 0)
			return false;

		// �?外数组�?存余数情况
		int[] counts = new int[k];
		for (int num : nums) {
			// �?始化余数数组,counts[i]�?存的是余数为i的个数
			counts[num % k]++;
		}

		// 整除k的个数若�?是�?�数，返回false
		if (counts[0] % 2 != 0)
			return false;

		// k是�?�数时，查看余数为k/2的个数是�?�为�?�数
		if (k % 2 == 0) {
			if (counts[k / 2] % 2 != 0)// 如果余数为k的一�?�的个数�?是�?�数，直接返回false
				return false;
		}
		for (int i = 1; i <= k / 2; i++) {
			// 余数�?对
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
