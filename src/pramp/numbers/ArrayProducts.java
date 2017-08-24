package pramp.numbers;

public class ArrayProducts {
	  
	  static int[] arrayOfArrayProducts(int[] arr)
	  {
	    
	    int [] products =new int [arr.length];
	    for(int i=0;i<arr.length;i++)
	      products[i]=productHelper(arr,i);
	    
	    return products;
	  
	  }
	  

	  static int productHelper(int [] arr, int position )
	  {
	    int result=1;
	    for(int i=0;i<arr.length;i++)
	    {
	      if(i!=position)
	        result*=arr[i];
	    }
	    
	    return result;
	      
	  }
	  
	  public static void main(String[] args) {
	    int [] arr={8,10,2};
	    int [] products =arrayOfArrayProducts(arr);
	    
	     for(int i=0;i<arr.length;i++)
	    {
	      System.out.println(products[i]);
	    }

	  }
}
