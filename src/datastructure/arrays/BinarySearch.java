package datastructure.arrays;

public class BinarySearch {

	 

    public static boolean binarySearch(int key, int [] data) 
    {
         int low = 0;
         int high = data.length - 1;
          
         while(high >= low) {
             int middle = (low + high) / 2;
            if(data[middle] == key) {
                return true;
             }
            if(data[middle] < key) {
                 low = middle + 1;
             }
             if(data[middle] > key) {
                 high = middle - 1;
             }
       }
        return false;
  }
    
    public static void main(String []args)
    {
    	int [] data={1,2,3,4};
    	System.out.println(binarySearch(3,data));
    }
	
}
