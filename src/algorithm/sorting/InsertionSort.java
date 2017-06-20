package algorithm.sorting;

public class InsertionSort {

	// http://www.growingwiththeweb.com/2012/11/algorithm-insertion-sort.html

	/*
	 * Insertion sort works by looking at each item in an array (starting with
	 * the second) and comparing it with the item before. If the item before is
	 * larger, they are swapped. This continues until the item is smaller at
	 * which point we do the same for the next item.
	 * 
	 * As you probably guessed, insertion sort isn’t one of the fastest sorts,
	 * running in O(n^2)O(n ​2 ​​ ) worst case time. 
	 * 
	 * It does have a few benefits
	 * however: It is faster than most O(n \log n)O(nlogn) sorting algorithms
	 * for small lists.
	 * 
	 *  It is very memory efficient requiring only O(1)O(1)
	 * auxiliary space for the single item that is being moved. 
	 * 
	 * It is a stable
	 * sort; equal elements appear in the same order in the sorted list. It is
	 * an adaptive sort; 
	 * 
	 * it’s fast when sorting mostly sorted lists or when
	 * adding items to an already sorted list. It is really easy to implement.
	 * 
	 * 
	 * 
	 * When it’s fast:
	 * Sorting 2,3,4,5,1 example As mentioned above it can be fast under certain
	 * circumstances. Consider the array [2,3,4,5,1], when using an algorithm
	 * like merge sort we would still need to split all the items and them merge
	 * them back up. With insertion sort we just need to verify that [2,3,4,5]
	 * are in the correct ‘sorted so far’ order, then we shift all of them up
	 * one index for 1. Being an adaptive sort also makes it an online
	 * algorithm, which means we can start sorting before we get all the items
	 * and then merge the lists once the partial sorting has completed.
	 */
	public static <T extends Comparable<T>> void sort(T[] array) {
		for (int i = 1; i < array.length; i++) {
			T item = array[i];
			int indexHole = i;
			while (indexHole > 0 && array[indexHole - 1].compareTo(item) > 0) {
				array[indexHole] = array[--indexHole];
			}
			array[indexHole] = item;
		}
	}
}
