package algorithm.searching;

import java.util.Arrays;

/**
 find the index of key in a sorted array a
 */
public class BinarySearch {

   
    public static int binarySearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

  

    public static void main(String[] args) {

    	int[] a={0,1,2,3,4,5,6,7,8};
    	System.out.println(binarySearch(a,3));
       
        
    }
}
