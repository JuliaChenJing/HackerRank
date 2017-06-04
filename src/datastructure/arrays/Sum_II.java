package datastructure.arrays;

import java.util.HashMap;

/*
 *        给定一个整型的数组，找出其中的两个数使其和为某个指定的值，
 *        并返回这两个数的下标（数组下标是从0开始的），因此不可以把数组原来的顺序打乱。
 *        假设数组元素的值各不相同，则要求时间复杂度为O（n），n为数组的长度。
 */
public class Sum_II {
	public static void main(String[] args) {
		int[] a = twoSum(new int[] { 1, 2, 5,3, 4 }, 4);// 1+3=4
		System.out.println("下标:" + a[0]);// 输出下标1
		System.out.println("下标:" + a[1]);// 输出下标2
	}

	/*
	 * 扫描一遍数组即需要O（n）的时间，如何让查找时间是常数时间呢？可以考虑使用哈希函数。
	 * 
	 * 先扫描一遍数组，把键值<value,index>存入哈希表；第二次扫描的时候，检查target与当前的差值是否在哈希表中。
	 * 如果遇到target与当前元素的差值为当前元素的大小怎么办呢？根据题意，数组元素的值各不相同，不可能出现第二个值为当前元素的元素，
	 * 因此出现这种情况是不符合题意的，不应返回当前的下标。
	 * 
	 * 因为哈希表的查找是常数时间，所以程序的时间复杂度还是O（n），而空间复杂度为哈希表大小，即数组大小O（n）。
	 */
	static int[] twoSum(int[] A, int target) {
		int[] res = { -1, -1 };
		// 数组是否符合长度标准
		if (A == null || A.length < 2)
			return res;// 这句话每个数组题都要写
		// 声明新的哈希表
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		// 给新哈希表赋初值
		for (int i = 0; i < A.length; i++) {
			// 扫描一遍，存储值与下标
			hm.put(A[i], i);// 键是数组的值，值是数组的下标
		}

		for (int i = 0; i < A.length; i++) {
			if (hm.containsKey(target - A[i]) && target != 2 * A[i]) {
				// 获取结果的两个下标
				res[0] = i;
				res[1] = hm.get(target - A[i]);// 通过键获得值，即数组的下标
				break;
			}
		}
		return res;
	}
}
