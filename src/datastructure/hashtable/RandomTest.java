package datastructure.hashtable;

import java.util.*;
public class RandomTest{
    public static void main(String[] args)
    {
    	Random random=new Random();
    	Map <Integer, Integer> m=new HashMap <Integer, Integer>();
    	
    	for(int i=0;i<10000;i++)
    	{
    		//produce a number between 0 and 20
    		int key=random.nextInt(20);//key could not be bigger than 20
    		//System.out.println(r);
    		Integer value=m.get(key);
    		m.put(key, value==null? 1:value+1);
    	}
    	System.out.println(m);
   
    }

}