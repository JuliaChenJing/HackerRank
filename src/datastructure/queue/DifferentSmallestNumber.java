package datastructure.queue;
import java.util.PriorityQueue;

public class DifferentSmallestNumber {
	
	public static void main(String [] args)
	{
		int arr[]={0,1,2,3,5};
		System.out.println(getDifferentNumber_I(arr));
		System.out.println(getDifferentNumber_II(arr));
	}

	String s="abc";

	static int getDifferentNumber_I(int[] arr) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int i = 0; i < arr.length; i++) {
			pq.offer(arr[i]);
		}
		
		int i = 0;
		for (; i < arr.length; i++) {

			if (pq.poll() != i)
				return i;
		}

		return i + 1;
	}

	static int getDifferentNumber_II(int[] arr) {
		if (!find(0,arr))
			return 0;
		int max = max(arr);

		for (int i = 0; i <= max + 1; i++) {

			if (!find(i,arr))
				return i;
		}

		return max+1;

	}

	// return if int num is in array
	static boolean find(int num, int[] arr) {
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == num)
				return true;
		}
		return false;
	}

	// return the max value in arr
	static int max(int[] arr) {
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}

	

}