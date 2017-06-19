package algorithm.sorting;

import java.util.Random;

public class BucketSort {
	/*
	 * Understanding the common sorting algorithms is incredibly valuable, as
	 * many sorting or searching solutions require tweaks of known sorting
	 * algorithms. A good approach when you are given a question like this is to
	 * run through the different sorting algorithms and see if one applies
	 * particularly well.
	 * 
	 * 
	 * Example: You have a very large array of ‘Person’ objects. Sort the people
	 * in increasing order of age. We’re given two interesting bits of knowledge
	 * here: 
	 * 
	 * (1) It’s a large array, so efficiency is very important. 
	 * (2) We are sorting based on ages, so we know the values are in a small range.
	 * 
	 *  By scanning through the various sorting algorithms, we might notice that
	 * bucket sort would be a perfect candidate for this algorithm. In fact, we
	 * can make the buckets small (just 1 year each) and get O(n) running time.
	 * 
	 * 
	 */
	/*
	 * Partition the array into a finite number of buckets, and then sort each
	 * bucket individually. This gives a time of O(n + m), where n is the number
	 * of items and m is the number of distinct items.
	 */
	
	 static int[] bucketsort(int[] sequence, int maxValue) 
	    {
	        
	        int[] Bucket = new int[maxValue + 1];
	        int[] sorted_sequence = new int[sequence.length];
	 
	        for (int i = 0; i < sequence.length; i++)
	            Bucket[sequence[i]]++;
	 
	        int outPos = 0;
	        for (int i = 0; i < Bucket.length; i++)
	            for (int j = 0; j < Bucket[i]; j++)
	                sorted_sequence[outPos++] = i;
	 
	        return sorted_sequence;
	    }
	 
	    static void printSequence(int[] sorted_sequence) 
	    {
	        for (int i = 0; i < sorted_sequence.length; i++)
	            System.out.print(sorted_sequence[i] + " ");
	    }
	 
	    static int maxValue(int[] sequence) 
	    {
	        int maxValue = 0;
	        for (int i = 0; i < sequence.length; i++)
	            if (sequence[i] > maxValue)
	                maxValue = sequence[i];
	        return maxValue;
	    }
	 
	    public static void main(String args[]) 
	    {
	        System.out
	                .println("Sorting of randomly generated numbers using BUCKET SORT");
	        Random random = new Random();
	        int N = 20;
	        int[] sequence = new int[N];
	 
	        for (int i = 0; i < N; i++)
	            sequence[i] = Math.abs(random.nextInt(100));
	 
	        int maxValue = maxValue(sequence);
	 
	        System.out.println("\nOriginal Sequence: ");
	        printSequence(sequence);
	        
	        System.out.println();
	 
	        System.out.println("\nSorted Sequence: ");
	        printSequence(bucketsort(sequence, maxValue));
	    }
	

}
