package algorithm.searching;

/**
 * find the index of key in a sorted array
 */
public class BinarySearch {

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

	public static boolean binarySearch(int key, int[] data) {
		int low = 0;
		int high = data.length - 1;

		while (high >= low) {
			int middle = (low + high) / 2;
			if (data[middle] == key) {
				return true;
			}
			if (data[middle] < key) {
				low = middle + 1;
			}
			if (data[middle] > key) {
				high = middle - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(binarySearch(array, 3));

		int[] data = { 1, 2, 3, 4 };
		System.out.println(binarySearch(3, data));

	}
}
