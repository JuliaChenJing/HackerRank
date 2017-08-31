package datastructure.array.sortedArrays;

public class FindKInSortedButRotatedArray {

	// Find an element K in an sorted but rotated array
	public static boolean findK(int k, int[] data) {

		if (data.length == 0 || data == null)
			return false;
		if (data.length == 1)
			return k == data[0];

		int left = 0;
		int right = data.length - 1;

		while (right > left) {

			if (data[left] < data[right]) // the left one is the smallest
											// one,the right one is the biggest
											// one
			{

				if (data[left] > k || data[right] < k)
					return false;

				if (data[left] == k || data[right] == k)
					return true;
				else {
					left++;
					right--;
				}
			}

			else// the left one is not the smallest one , the right one might be
				// the smallest one
			{

				if (data[left] == k || data[right] == k)
					return true;
				else {
					left++;
					right--;
				}
			}

		}
		if (left < data.length && data[left] == k)
			return true;
		if (right < data.length && data[right] == k)
			return true;
		return false;

	}

	/*
	 * Suppose an array sorted in ascending order is rotated at some pivot
	 * unknown to you beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * You are given a target value to search. If found in the array return its
	 * index, otherwise return -1.
	 * 
	 * You may assume no duplicate exists in the array.
	 */
	public static int search(int k, int[] data) {
		if (data.length == 0 || data == null)
			return -1;
		if (data.length == 1)
			return (k == data[0]) ? 0 : -1;

		int left = 0;
		int right = data.length - 1;

		while (right > left) {

			if (data[left] < data[right]) // the left one is the smallest
											// one,the right one is the biggest
											// one
			{

				if (data[left] > k || data[right] < k)
					return -1;

				if (data[left] == k || data[right] == k)
					return data[left] == k ? left : right;
				else {
					left++;
					right--;
				}
			}

			else// the left one is not the smallest one , the right one might be
				// the smallest one
			{

				if (data[left] == k || data[right] == k)
					return data[left] == k ? left : right;
				else {
					left++;
					right--;
				}
			}

		}
		if (data[left] == k)
			return left;

		return -1;
	}

	public static void main(String[] args) {
		int[] data = { 1, 3 };
		int[] data_2 = { 1, 2, 3, 4, 5, 6, 7 };

		System.out.println(findK(6, data));
		System.out.println(findK(6, data_2));
		System.out.println(findK(8, data));
		System.out.println(findK(8, data_2));

		System.out.println(search(1, data));
		System.out.println(search(6, data_2));
		System.out.println(search(8, data));
		System.out.println(search(8, data_2));
	}

}
