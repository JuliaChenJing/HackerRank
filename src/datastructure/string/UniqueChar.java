package datastructure.string;

import java.util.HashMap;

//Implement an algorithm to determine if a string has all unique characters.
public class UniqueChar {


	//using hashmap
    public static boolean allUniqueChar(String s) 
    {
    	if(s==null||s.length()==0)
    	return true;
    	
    	HashMap <Character, Integer> map=new HashMap<Character, Integer>();
    	for(int i=0;i<s.length();i++)
    	{
    		if(map.containsKey(s.charAt(i)))
    			return false;
    		else	
    			map.put(s.charAt(i), 0);
    	}
    		return true;
    	
  }
    //What if you can not use additional data structures?
    
    //For simplicity, assume char set is ASCII (if not, we need to increase the storage size.
    //The rest of the logic would be the same). 
    //NOTE: This is a great thing to point out to your interviewer!
    
    public static void main(String []args)
    {
    	System.out.println(allUniqueChar("apple"));
    	System.out.println(allUniqueChar("aple"));
    	
    }
	
}