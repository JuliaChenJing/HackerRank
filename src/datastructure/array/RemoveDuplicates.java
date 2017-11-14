package datastructure.array;

/** Class: Fundamental Programming Practice  <br /> 
@author "Jing Chen" <br /> 
Description:   Write a program called RemoveDups. Create an array which accepts an array of Strings only. Creates a new array in which all duplicate Strings in the original input array have been removed.<br /> 
*/
import java.util.*;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String test[] = { "horse", "dog", "cat", "horse", "dog" };

		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < test.length; i++) {
			if (!list.contains(test[i]))
				list.add(test[i]);
		}
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}
}
/*
 * horse dog cat
 */