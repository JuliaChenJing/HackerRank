package datastructure.array;

import java.util.HashMap;

/*
 *        给定一个整型的数组，找出其中的两个数使其和为�?个指定的值，
 *        并返回这两个数的下标（数组下标是从0开始的），因此�?�?�以把数组原�?�的顺�?打乱。
 *        �?�设数组元素的值�?��?相�?�，则�?求时间�?�?�度为O（n），n为数组的长度。
 */
public class Sum_II {
	public static void main(String[] args) {
		int[] a = twoSum(new int[] { 1, 2, 5, 3, 4 }, 4);// 1+3=4
		System.out.println("下标:" + a[0]);// 输出下标1
		System.out.println("下标:" + a[1]);// 输出下标2
	}

	/*
	 * 扫�??一�??数组�?�需�?O（n）的时间，如何让查找时间是常数时间呢？�?�以考虑使用哈希函数。
	 * 
	 * 先扫�??一�??数组，把键值<value,index>存入哈希表；第二次扫�??的时候，检查target与当�?的差值是�?�在哈希表中。
	 * 如果�?�到target与当�?元素的差值为当�?元素的大�?怎么办呢？根�?�题�?，数组元素的值�?��?相�?�，�?�?�
	 * 能出现第二个值为当�?元素的元素， 因此出现这�?情况是�?符�?�题�?的，�?应返回当�?的下标。
	 * 
	 * 因为哈希表的查找是常数时间，所以程�?的时间�?�?�度还是O（n），而空间�?�?�度为哈希表大�?，�?�数组大�?O（n）。
	 */
	static int[] twoSum(int[] A, int target) {
		int[] res = { -1, -1 };
		// 数组是�?�符�?�长度标准
		if (A == null || A.length < 2)
			return res;// 这�?��?�?个数组题都�?写
		// 声明新的哈希表
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		// 给新哈希表赋�?值
		for (int i = 0; i < A.length; i++) {
			// 扫�??一�??，存储值与下标
			hm.put(A[i], i);// 键是数组的值，值是数组的下标
		}

		for (int i = 0; i < A.length; i++) {
			if (hm.containsKey(target - A[i]) && target != 2 * A[i]) {
				// 获�?�结果的两个下标
				res[0] = i;
				res[1] = hm.get(target - A[i]);// 通过键获得值，�?�数组的下标
				break;
			}
		}
		return res;
	}
}
