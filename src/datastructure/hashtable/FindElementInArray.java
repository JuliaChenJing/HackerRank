package datastructure.hashtable;

import java.util.*;
public class FindElementInArray  {
	public static void main(String[] args) {
		int x[] = { 10, 11, 12, 13, 14, 15};
		 HashMap <Integer,Integer> map = new HashMap <Integer,Integer>();  
		 for(int i=0;i<x.length;i++)
         map.put(x[i] , i); 
		System.out.println("the position of element 15 is "+map.get(15));

	}

}