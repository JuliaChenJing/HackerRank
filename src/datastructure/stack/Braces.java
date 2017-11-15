package datastructure.stack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Braces {
	public static void main(String[] args) throws IOException {
		String[] values = { "()", "([2343])", "(}sfas" };
		for (int i = 0; i < values.length; i++)
			System.out.println("Is " + values[i] + " a balanced String? " + braces(values)[i]);

		System.out.println();
		System.out.println(generateParenthesis(3));
	}

	static String[] braces(String[] values) {
		String re[] = new String[values.length];

		if (values.equals(null))
			return null;
		for (int i = 0; i < values.length; i++) {
			if (CheckParentesis(values[i])) {

				re[i] = "Yes";

			} else
				re[i] = "No";
		}

		return re;

	}

	static boolean CheckParentesis(String str) {
		if (str.isEmpty())
			return true;

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			if (current == '{' || current == '(' || current == '[') {
				stack.push(current);
			}

			if (current == '}' || current == ')' || current == ']') {
				if (stack.isEmpty())
					return false;

				char last = stack.peek();
				if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
					stack.pop();
				else
					return false;
			}

		}

		return stack.isEmpty();
	}

	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		backtrack(list, "", 0, 0, n);
		return list;
	}

	public static void backtrack(List<String> list, String str, int left, int right, int max) {

		if (str.length() == max * 2) {
			list.add(str);
			return;
		}

		if (left < max)
			backtrack(list, str + "(", left + 1, right, max);
		if (right < left)
			backtrack(list, str + ")", left, right + 1, max);
	}

	public static int longestValidParentheses(String s) {
		for (int i = s.length() - 1; i > 0; i--) {
			if (isParentheses(s, i))
				return i + 1;
			break;
		}
		return 0;
	}

	/*
	 * Given a string containing just the characters '(' and ')', find the
	 * length of the longest valid (well-formed) parentheses substring.
	 * 
	 * For "())", the longest valid parentheses substring is "()", which has
	 * length = 2.
	 * 
	 * Another example is ")()())", where the longest valid parentheses
	 * substring is "()()", which has length = 4.
	 */
	public static boolean isParentheses(String s, int end) {
		int flag = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				flag++;
			else if (s.charAt(i) == ')')
				flag--;
			if (flag < 0)
				return false;
		}
		return flag == 0;
	}

	public int longestValidParentheses_perfect(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int left = -1;
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == '(')
				stack.push(j);//push the index of '('
			else {
				if (stack.isEmpty())
					left = j;
				else {
					stack.pop();
					if (stack.isEmpty())
						max = Math.max(max, j - left);
					else
						max = Math.max(max, j - stack.peek());
				}
			}
		}
		return max;
	}

}
