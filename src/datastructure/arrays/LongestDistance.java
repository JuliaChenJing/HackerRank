package datastructure.arrays;

//给定一个整型数组，找出最大下标距离j-i，当且仅当A[i]<A[j]和i<j
public class LongestDistance {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 0 };
		int b = K(a);
		System.out.println(b);
	}

	/*
	 * 直观的方法是对每个元素，从其后找出比其大的元素，并计算两者下标的差值，取差值中的最大值。 该方案时间复杂度为O（n*n）,n为数组长度。
	 */
	static int K(int[] A) {

		if (A == null)
			return -1;
		int max = 0;
		for (int i = 0; i < A.length; i++)
			for (int j = A.length - 1; j > i; j--) {
				if (A[i] < A[j]) {
					if (max < j - i)
						max = j - i;
				}
			}
		return max;
	}

	/*
	 * 那么有没有更快的解决方法？ 我们可以试试排序。为了记录元素下标，使用一个哈希表存储下标，如果允许数组有相同元素，那么哈希表的值为一个数组；
	 * 将数组排序之后，使用俩指针方法，一个指针从头部开始扫描，另一个指针从尾部开始，计算俩指针的下标差值，直至俩指针相遇。
	 * 记录下标和两端开始扫描的时间复杂度为O（n），所以时间复杂度为排序的复杂度O（nlogn），而空间复杂度为O（n），即哈希表的大小。
	 */
}