package pramp.life_question;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
public class PhoneNumber {

	/*
	 * Given a digit string, return all possible letter combinations that the
	 * number could represent.
	 * 
	 * A mapping of digit to letters (just like on the telephone buttons) is
	 * given below.
	 * 
	 * 
	 * 
	 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf",
	 * "cd", "ce", "cf"].
	 * 
	 */
	public static List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (ans.peek().length() == i) {
				String t = ans.remove();
				for (char s : mapping[x].toCharArray())
					ans.add(t + s);
			}
		}
		return ans;
	}
	
	public static void main(String [] args){
		System.out.println(letterCombinations("012"));//[1a, 1b, 1c]
		System.out.println(letterCombinations("34"));//[dg, dh, di, eg, eh, ei, fg, fh, fi]
	}
}
