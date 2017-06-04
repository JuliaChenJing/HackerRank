package datastructure.arrays;


public class KExists {

	// Find an  element K in an sorted but rotated array
    public static boolean findK( int k,int [] data) 
    {
    	
    	if (data.length==0 || data==null)
    			return false;
    	if (data.length==1 )
			return k==data[0];
    	
         int left = 0;
         int right = data.length-1;
          
         while(right != left&& right<data.length &&left<data.length) {
            
            if(data[left] <data[right]) //the left one is the smallest one,the right one is the biggest one
            {
            	
                if (data[left]>k|| data[right]<k)
                	return false;
               
                if(data[left]==k|| data[right]==k)
                	return true;
                else
                {
                	 left++;
                	 right--;
                }
             }
           
            else//the left one is not the smallest one , the right one might be the smallest one
            {
            	
            	 if(data[left]==k|| data[right]==k)
                 	return true;
                 else
                 {
                 	 left++;
                 	 right--;
                 }
             }
           
       }
        return true;
    
  }
    
    public static void main(String []args)
    {
    	int [] data={3,4,5,6,7,1,2};
    	int [] data_2={1,2,3,4,5,6,7};
    	System.out.println(findK(6,data));
    	System.out.println(findK(7,data_2));
    }
	
}

 
