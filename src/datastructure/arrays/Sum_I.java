package datastructure.arrays;

import java.util.*;

//给定一个整形数组，是否能找出其中的两个数使其和为某个指定的值？
/*
  输入数组是有序的吗？
你可以假定是无序的。
 */
public class Sum_I {
	public static void main(String[] args) {
		System.out.println(hasSum(new int[] { 3, 4, 1, 2, 9 }, 4));
	}

	/*
	 * 举例 
	 * 输入数组为{1,5,7,3}以及指定的目标值为10，我们可以从中找出两个数3和7，和为10.
	 *  思考
	 * 一种非常直观的办法就是使用两个循环，从组里提取一个数，然后在该数之后的部分找出另外一个数，计算这两个数之和，看看是否等于指定的值。
	 * 这种暴力破解的方法显然不是面试官想要的。那么，能否降低暴力破解O（n*n）的时间复杂度呢？
	 * 
	 * 尝试先把该数组排序，排序之后，从首位两端移动，一次移动一端的指针，直至相遇或找出两个数的和为指定的值为止。
	 * 假设当前首位指针分别为i和j，其中i<j,如果A[i]与A[j]之和大于指定的值，那么要找的两个数一定在j的左侧，因此，尾指针j往前移动一步。
	 * 如果A[i]与A[j]之和小于指定的值，那么要找的两个数一定在i的右侧，所以首指针i往后移动一步。
	 * 
	 * 通过排序，使得时间复杂度降至O(nlogn)。在while循环里，至多扫描一遍数组就可以得出结果。能否继续降低时间复杂度呢？
	 * 如果允许使用额外的存储空间，那么答案是可以，详见“两数之和II”。
	 */
	static boolean hasSum(int[] A, int target) {
		boolean res = false;
		if (A == null || A.length < 2)
			return res;

		Arrays.sort(A);//注意： 可以调用系统自带的排序算法

		int i = 0;
		int j = A.length - 1;
		while (i < j) {
			if (A[i] + A[j] == target) {
				res = true;
				break;
			} else if (A[i] + A[j] > target) {
				j--;// 目标值过小，则向前移动尾部指针，减小两数和
			} else {
				i++;// 目标值过大，则向后移动首部指针，增加两数和
			}
		}
		return res;
	}
}
