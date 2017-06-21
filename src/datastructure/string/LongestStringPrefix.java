package datastructure.string;

public class LongestStringPrefix {

	/*
	 * Write a function that takes in a string and returns the length of the
	 * longest string prefix in which all characters are arranged in
	 * alphabetical order.
	 * 
	 * Note: The string contains only lower case letters from a - z.
	 * 
	 * Input: "apple"
	 * 
	 * Output: 3
	 * 
	 * Explanation: The longest prefix which follows alphabetical order is a, p,
	 * p.
	 */

	
	public static int longestPrefix(String s) {
       char pre=s.charAt(0);
       int re=1;
       for(int i=1;i<s.length();i++)
       {
    	   if(pre<=s.charAt(i))
    	   {
    		   re++;
    		  
    	   }
    	   else{
    		   break;
    	   }
    	   pre=s.charAt(i);
       }
        
       return re;
    }
	public static void main(String [] args)
	{
		System.out.println(longestPrefix("abbcdef"));
		
	}
	
}
