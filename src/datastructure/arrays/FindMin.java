package datastructure.arrays;


public class FindMin {

	// Find minimum element K in an sorted but rotated array
    public static int findMin( int [] data) 
    {
    	
    	if (data.length==0 || data==null)
    			return 0;
    	if (data.length==1 )
			return data[0];
    	
    	 int min=100;
         int left = 0;
         int right = data.length-1;
          
         while(right != left&& right<data.length &&left<data.length) {
            
            if(data[left] <data[right]) //the left one is the smallest one
            {
            	
                if (data[left]<min)
                	min=data[left];
                left=right+1;
                right=data.length-1;
                
             }
          //if the left one is not the smallest one ,then the right one might be the smallest one
            else
            {
            	if (data[right]<min)
                	min=data[right];
            	 left++;
                 right--;
             }
           
       }
        return min;
    
  }
    
    public static void main(String []args)
    {
    	int [] data={3,4,5,6,7,1,2};
    	int [] data_2={1,2,3,4,5,6,7};
    	System.out.println(findMin(data));
    	System.out.println(findMin(data_2));
    }
	
}

