package datastructure.string;


public class ReverseCString {


    public static String reverseCString(String s) 
    {
    	if(s==null||s.length()==0)
    	return null;
    	StringBuffer re=new StringBuffer ();
    	
    	for(int i=s.length()-1;i>=0;i--)
    	re.append(s.charAt(i));
  
    	return re.toString();
    		
  }
    
    public static void main(String []args)
    {
    	System.out.println(reverseCString("apple "));
    	
   
    }
	
}

 /*
 elppa
  */