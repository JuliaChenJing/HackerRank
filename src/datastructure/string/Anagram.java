package datastructure.string;

import java.util.HashMap;
import java.util.Map;
//Write a method to decide if two strings are anagrams （颠倒字母而成的字） or not
public class Anagram {
	
	
	//我自己想的答案
	public static boolean isAnagram(String s1, String s2) {
		
		//return sort(s1)==sort(s2);
		
		if (s1 == s2)
			return true;

		if (s1 == null && s2 != null)
			return false;

		if (s1 != null && s2 == null)
			return false;

		if (s1 != null && s2 != null && s1.length() != s2.length())
			return false;

		if (s1.length() != 0 && s2.length() != 0 && s1 != null && s2 != null) {
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			
			for (int i = 0; i < s1.length(); i++)
				if (!map.containsKey(s1.charAt(i)))
					map.put(s1.charAt(i), 1);

				else {
					int a = map.get(s1.charAt(i));
					map.put(s1.charAt(i), a + 1);

				}

			for (int j = 0; j < s1.length(); j++)
				if (!map.containsKey(s2.charAt(j)))
					return false;

				else {
					int b = map.get(s2.charAt(j));
					if (b <= 0)
						return false;
					else
						map.put(s2.charAt(j), b - 1);
				}

			for (Integer value : map.values()) {
				if (value != 0)
					return false;

			}

		}
		return true;

	}

	//书上的答案,有点复杂，看不大懂，没有上面的明白
	public static boolean anagram(String s, String t)
	{
		
		if (s.length() != t.length()) return false;//如果s或t是null就不对了
		
		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();//将string变成char []
		
		//遍历s中的每个字母
		for (char c : s_array) { // count number of each char in s.
		
			if (letters[c] == 0) 
				++num_unique_chars;//不同char的存在个数
		
			++letters[c];//每个char的个数
		}
		 
		for (int i = 0; i < t.length(); ++i) 
		{
		 
			int c = (int) t.charAt(i);
		
			if (letters[c] == 0)
			{ // Found more of char c in t than in s.  
			  //s里没有，t里还有
				return false;
			}
		 
			letters[c]=letters[c]-1;
		 
			if (letters[c] == 0) 
			{
		 
				++num_completed_t;//核对完成的字母数量
		
				if (num_completed_t == num_unique_chars) 
				{
		
					// it’s a match if t has been processed completely
	
					return i == t.length()-1;
				}	 
			}
		 }		 
		return false;		
	}
	
	public static void main(String[] args) {

		//test 1
		System.out.println("apple" == "apple");
		System.out.println("apple" == "appbe");
		System.out.println(null == "apple");
		System.out.println(null == null);
		System.out.println(null == "");
		System.out.println("" == "");

		//test 2
		System.out.println(isAnagram("apple", "apple"));
		System.out.println(isAnagram("apble", "apple"));
		System.out.println(isAnagram("aaabbb", "ab"));
		System.out.println(isAnagram("aaabbb", "abaaa"));
		System.out.println(isAnagram("", ""));
		System.out.println(isAnagram(null, null));
		System.out.println(isAnagram(null, ""));
		System.out.println(isAnagram(null, "ab"));
		
		//test 3
		System.out.println(anagram("apple", "apple"));
		System.out.println(anagram("apble", "apple"));
		System.out.println(anagram("aaabbb", "ab"));
		System.out.println(anagram("aaabbb", "abaaa"));
		System.out.println(anagram("", ""));
		//System.out.println(anagram(null, null));
		//System.out.println(anagram(null, ""));
		//System.out.println(anagram(null, "ab"));


	}

}

