package algorithm.sorting;

public class MergeBintoA {
	

	public static void main(String array[]) {
		int[] a ={ 9, 14, 43, 58,0,0,0 };
		System.out.println("array a");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		int[] b = { 1, 3, 24 };
		System.out.println("array b");
		for (int i : b) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		//int [] re=merge( a, b, a.length,b.length);

		System.out.println("After Merge");
		//for (int i : re) {
		//	System.out.print(i + " ");
		//}
	}
	
	
	/*
	 * 9.1 p185 You are given two sorted arrays, A and B, and A has a large
	 * enough buffer at the end to hold B. Write a method to merge B into A in
	 * sorted order. This code is a part of the standard merge-sort code. We
	 * merge A and B from the back, by comparing each element.
	 */

	public static int []  merge(int[] a, int[] b, int lengthOfA,int lengthOfB ) {
		int k = lengthOfA + lengthOfB - 1; // Index of last location of array b
		int i = lengthOfB - 1; // Index of last element in array b
		int j = lengthOfA - 1; // Index of last element in array a

		// Start comparing from the last element and merge a and b
		while (i >= 0 && j >= 0) {
			if (a[i] > b[j]) {
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			}
		}
		while (j >= 0) {
			a[k--] = b[j--];
		}
		
		return a;
	}

	/*
	 * Note: You don't need to copy the contents of a after running out of b’s.
	 * They are already in place.
	 */
	
	

}
