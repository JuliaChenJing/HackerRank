package pramp.binary_search_and_sort;

public class IndexEqualsValue {
	static int indexEqualsValueSearch(int[] arr) {
	
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == i)
				return i;
		}

		return -1;
	}

	static int indexEqualsValueSearchWithBinarySearch(int[] arr) {
		
		if (arr == null)
			return -1;

		if (arr.length == 0)
			return -1;

		return helper(arr, 0, arr.length - 1);

	}

	static int helper(int[] arr, int start, int end) {
		

		while (start <= end) {
			
			int middle = (start + end) / 2;

			if (arr[middle] == middle)
				return middle;
			
			else if (arr[middle] > middle)
				return helper(arr, start, middle-1);
			else
				return helper(arr, middle+1, end);
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { -1,0,3,6 };
		int [] arr2={-8,0,2,5};
		System.out.println(indexEqualsValueSearch(arr));
		System.out.println(indexEqualsValueSearchWithBinarySearch(arr));
		System.out.println(indexEqualsValueSearch(arr2));
		System.out.println(indexEqualsValueSearchWithBinarySearch(arr2));

	}

}
