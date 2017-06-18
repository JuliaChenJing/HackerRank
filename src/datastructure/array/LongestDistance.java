package datastructure.array;

//给定一个整型数组，找出最大下标�?离j-i，当且仅当A[i]<A[j]和i<j
public class LongestDistance {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 0 };
		int b = K(a);
		System.out.println(b);
	}

	/*
	 * 直观的方法是对�?个元素，从其�?�找出比其大的元素，并计算两者下标的差值，�?�差值中的最大值。
	 * 该方案时间�?�?�度为O（n*n）,n为数组长度。
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
	 * 那么有没有更快的解决方法？
	 * 我们�?�以试试排�?。为了记录元素下标，使用一个哈希表存储下标，如果�?许数组有相�?�元素，那么哈希表的值为一个数组；
	 * 将数组排�?之�?�，使用俩指针方法，一个指针从头部开始扫�??，�?�一个指针从尾部开始，计算俩指针的下标差值，直至俩指针相�?�。
	 * 记录下标和两端开始扫�??的时间�?�?�度为O（n），所以时间�?�?�度为排�?的�?�?�度O（nlogn），而空间�?�?�度为O（n），
	 * �?�哈希表的大�?。
	 */
}