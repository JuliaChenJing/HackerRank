package algorithm.sorting;

public class BubbleSort {
	/*
	 * Start at the beginning of an array and swap the first two elements, if the
	 * first is bigger than the second. Go to the next pair, etc, continuously
	 * making sweeps of the array until sorted. O(n^2).
	 */
	
	static void bubbleSort(int[] arr) {  
		
        int n = arr.length;  
        
        int temp = 0;  
        
         for(int i=0; i < n; i++)
         {  
                 for(int j=1; j < (n-i); j++)
                 {  
                          if(arr[j-1] > arr[j])
                          {  
                                 //swap elements  
                                 temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                         }  
                          
                 }  
         }  
  
    }  
    public static void main(String[] args) {  
                int arr[] ={3,60,35,2,45,320,5};  
                 
                System.out.println("Array Before Bubble Sort");  
                for(int i=0; i < arr.length; i++){  
                        System.out.print(arr[i] + " ");  
                }  
                System.out.println();  
                  
                bubbleSort(arr);
                 
                System.out.println("Array After Bubble Sort");  
                for(int i=0; i < arr.length; i++){  
                        System.out.print(arr[i] + " ");  
                }  
   
        }  

}
