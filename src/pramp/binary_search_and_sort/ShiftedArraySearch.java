package pramp.binary_search_and_sort;

public class ShiftedArraySearch {

	/*
	 * [2, 4, 5, 9, 12,17]
	 * 
	 * ,[9, 12, 17, 2, 4, 5],
	 */
	public static void main(String[] args) {
		int[] arr = { 9, 12, 17, 2, 4, 5 };
		System.out.println(findShiftPointIndex(arr));// 3
		System.out.println(shiftedArrSearch(arr, 17));// 2
	}

	// find shift Point index
	static int findShiftPointIndex(int[] shiftArray) {
		int first = 0;
		int last = shiftArray.length - 1;
		int middle;

		while (shiftArray[first] > shiftArray[last] && first < last) {
			middle = shiftArray[(last - first) / 2];
			if (shiftArray[middle] > shiftArray[first]) {
				first = middle;
			} else {
				last = middle;
			}
		}

		return first;
	}

	static int shiftedArrSearch(int[] shiftArray, int num) {
		int shiftPoint = findShiftPointIndex(shiftArray);

		if (shiftArray[shiftPoint] == num)
			return shiftPoint;

		if (shiftArray[0] > num)// left sorted array
			return binarySearch(shiftArray, 0, shiftPoint - 1, num);

		else // right sorted array
			return binarySearch(shiftArray, shiftPoint + 1, shiftArray.length - 1, num);
	}

	// binary search for num
	static int binarySearch(int[] shiftArray, int begin, int last, int num) {
		if (shiftArray[begin] == num)
			return begin;
		if (shiftArray[last] == num)
			return last;

		int middle;

		while (begin < last) {// here
			middle = (last - begin) / 2;

			if (shiftArray[middle] == num)
				return middle;
			if (shiftArray[middle] > num) // in the left of middle
				return binarySearch(shiftArray, begin, middle, num);
			else // num is in the right of middle
				return binarySearch(shiftArray, middle, last, num);
		}

		return begin;
	}
}
