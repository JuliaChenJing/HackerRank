package algorithm.sorting;

public class SelectionSort {
	/*
	 * Find the smallest element using a linear scan and move it to the front.
	 * Then, find the second smallest and move it, again doing a linear scan.
	 * Continue doing this until all the elements are in place. 
	 
	 O(n^2).
	 */

	/*
	 * 选择排序是一种比较简单的排序方法，非常容易理解。选择排序的基本思路是：对一个长度为n的数组进行n趟遍历，第一趟遍历选出最大的元素，
	 * 将之与数组的第一个元素交换；然后进行第二趟遍历，再从剩余的元素中选出最大（或者最小）的元素，将之与数组的第二个元素交换。这样遍历n次后，
	 * 得到的就为降序的数组。
	 */

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index]) {
					index = j;// searching for lowest index
				}
			}
			//switch
			int smallerNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNumber;
		}
	}

	public static void main(String a[]) {
		int[] arr1 = { 9, 14, 3, 2, 43, 11, 58, 22 };
		System.out.println("Before Selection Sort");
		for (int i : arr1) {
			System.out.print(i + " ");
		}
		System.out.println();

		selectionSort(arr1);// sorting array using selection sort

		System.out.println("After Selection Sort");
		for (int i : arr1) {
			System.out.print(i + " ");
		}
	}
}
