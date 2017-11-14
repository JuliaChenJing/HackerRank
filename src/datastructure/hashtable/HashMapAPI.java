package datastructure.hashtable;

import java.util.HashMap;

public class HashMapAPI {

	public static void main(String[] args) {

		HashMap<Integer, String> productMap = new HashMap<Integer, String>();
		productMap.put(1, "Keys");
		productMap.put(4, "Books");
		productMap.put(3, "Systems");
		productMap.put(7, "Mobile");
		productMap.put(null, null);
		System.out.println("HashMap test~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(productMap);
		System.out.println(productMap.get(3));
		System.out.println(productMap.containsKey(5));
		System.out.println(productMap.keySet());
		System.out.println(productMap.values());

	}

}
/*
HashMap test~~~~~~~~~~~~~~~~~~~~~~~~~~
{null=null, 1=Keys, 3=Systems, 4=Books, 7=Mobile}
Systems
false
[null, 1, 3, 4, 7]
[null, Keys, Systems, Books, Mobile]
 * 
 */
