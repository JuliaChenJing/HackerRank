package datastructure.stack;

import java.util.Stack;

/*
 * Write a program to sort a stack in ascending order. You should not
 *  make any assumptions about how the stack is implemented. 
 *  The following are the only functions that
   should be used to write this program: push | pop | peek | isEmpty.
 */
public class SortStack {
	/*
	 * Sorting can be performed with one more stack. The idea is to pull an item
	 * from the original stack and push it on the other stack.   If pushing this
	 * item would violate the sort order of the new stack, we need to remove
	 * enough items from it so that it’s possible to push the new item.    Since
	 * the items we removed are on the original stack, we’re back where we
	 * started. The algorithm is O(N^2) and appears below.
	 */
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> re = new Stack<Integer>();
		
		while (!s.isEmpty()) {
			int tmp = s.pop();
			//make sure all the numbers in re that is bigger than temp is moved back to s
			while (!re.isEmpty() && re.peek() > tmp)
			{
				//System.out.println(re.peek()+" is moved back from re to s");
				s.push(re.pop());
				
			}
			re.push(tmp);
		}
		return re;
	}
	
	public static void main(String[] args)
	{
		Stack <Integer> s=new Stack <Integer>();
		s.push(1);
		s.push(11);
		s.push(9);
		s.push(2);
		s.push(6);
		s.push(0);
		
		System.out.println("before: "+s);
		System.out.println("after: "+sort(s));
		
	}

}
