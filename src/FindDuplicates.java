import java.util.ArrayList;

public class FindDuplicates {
	
	public static void main(String[] args) {

		int [] arr={8,20};
		int[] arr1 = { 1, 2, 3, 5, 6, 7 };
		int[] arr2 = { 3, 6, 7, 8, 20 };
	
		int[] re = findDuplicates(arr1, arr2);
		int[] re_BinarySearch = findDuplicatesWithBinarySearch(arr, arr2);

		for (int i = 0; i < re.length; i++)
			System.out.print(re[i]+" ");
		
		System.out.println();
		
		for (int i = 0; i < re_BinarySearch.length; i++)
			System.out.print( re_BinarySearch[i]+" ");

	}
	

	// when length of arr1 and arr2 are almost the same

	static int[] findDuplicates(int[] arr1, int[] arr2) {

		int pointer1 = 0;
		int pointer2 = 0;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		while (pointer1 < arr1.length && pointer2 < arr2.length) {
			if (arr1[pointer1] == arr2[pointer2]) {
				arrayList.add(arr1[pointer1]);
				pointer1++;
				pointer2++;
			}

			else if (arr1[pointer1] < arr2[pointer2])
				pointer1++;

			else // arr1[pointer1]>arr2[pointer2

				pointer2++;
		}

		int[] result = new int[arrayList.size()];
		int locationInResult = 0;
		for (int i : arrayList) {
			result[locationInResult] = i;
			locationInResult++;

		}

		return result;

	}

	/*
	 * when length of arr1 and arr2 are of big difference, try to find each
	 * element from the short array in the big array using binary search since
	 * the array is sorted originally
	 * 
	 */
	static int[] findDuplicatesWithBinarySearch(int[] arr1, int[] arr2) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		for (int number : arr1)
			if (binarySearch(arr2, number) != -1)
				arrayList.add(number);

		int[] result = new int[arrayList.size()];
		int locationInResult = 0;
		for (int i : arrayList) {
			result[locationInResult] = i;
			locationInResult++;

		}

		return result;
	}

	/**
	 * find the index of key in a sorted array
	 */
	public static int binarySearch(int[] array, int key) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (key < array[mid])
				high = mid - 1;
			else if (key > array[mid])
				low = mid + 1;

			else
				return mid;
		}
		return -1;
	}

	
}
