package algorithm.searching;


/**
 find the index of key in a sorted array 
 */
public class BinarySearch {


    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (key < array[mid]) 
            	high = mid - 1;
            else 
            	if (key > array[mid])
            		low = mid + 1;
            
            else return mid;
        }
        return -1;
    }

  

    public static void main(String[] args) {

    	int[] array={0,1,2,3,4,5,6,7,8};
    	System.out.println(binarySearch(array,3));
       
        
    }
}
