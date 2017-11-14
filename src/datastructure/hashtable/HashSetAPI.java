package datastructure.hashtable;

import java.util.HashSet;

public class HashSetAPI {
	public static void main(String[] args) {

		System.out.println("HashSet test~~~~~~~~~~~~~~~~~~~~~~~~~~");
		HashSet<String> stateSet = new HashSet<String>();
		stateSet.add("CA");
		stateSet.add("WI");
		stateSet.add("NY");
		stateSet.add(null);
		if (stateSet.contains(
				"PB")) /* if CA, it will not add but shows following message */
			System.out.println("Already found");
		else
			stateSet.add("PB");
		System.out.println(stateSet);

		HashSet<Integer> numberSet = new HashSet<Integer>();
		numberSet.add(10);
		numberSet.add(-12);
		numberSet.add(15);
		numberSet.add(16);
		numberSet.remove(15);
		boolean s = numberSet.add(19);
		for (Integer num : numberSet)
			System.out.println("Value : " + num);
		System.out.println(s);
	}
}

/*
 * HashMap test~~~~~~~~~~~~~~~~~~~~~~~~~~
{null=null, 1=Keys, 3=Systems, 4=Books, 7=Mobile}
Systems
false
[null, 1, 3, 4, 7]
[null, Keys, Systems, Books, Mobile]
*/
