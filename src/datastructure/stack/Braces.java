package datastructure.stack;

import java.io.IOException;
import java.util.Stack;

public class Braces {
	public static void main(String[] args) throws IOException {
		String[] values={"()","([2343])","(}sfas"};
		for(int i=0;i<values.length;i++)
			System.out.println("Is " +values[i] + " a balanced String? "+braces(values)[i]);
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

	static String[] braces(String[] values)
	{
		String re[] =new String[values.length];

		if (values.equals(null))
			return null;
		for (int i = 0; i < values.length; i++) {
			if (CheckParentesis(values[i]))
			{

				re[i] = "Yes";
			
			}
			else
				re[i] = "No";
		}

		return re;

	}

}
