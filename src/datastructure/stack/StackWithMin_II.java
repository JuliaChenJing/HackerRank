package datastructure.stack;

import java.util.Stack;

/*
 *  How would you design a stack which, in addition to push and pop, also has a function
    min which returns the minimum element? Push, pop and min should all operate in
    O(1)
 */
public class StackWithMin_II extends Stack<Integer> {
	/*
	 * There’s just one issue with solution I:if we have a large stack, we waste a
	 * lot of space by keeping track of the min for every single element. Can we
	 * do better? 
	 * 
	 * We can (maybe) do a bit better than this by using an
	 * additional stack which keeps track of the mins
	 * 
	 * Why might this be more space efficient? If many elements have the same
	 * local min, then we’re keeping a lot of duplicate data. By having the mins
	 * kept in a separate stack, we don’t have this duplicate data (although we
	 * do use up a lot of extra space because we have a stack node instead of a
	 * single int).
	 */

	private static final long serialVersionUID = 1L;
	Stack<Integer> s2;

	public StackWithMin_II() {
		s2 = new Stack<Integer>();
	}

	public void push(int value) {
		if (value <= min()) {
			s2.push(value);
		}
		super.push(value);//this class is originally a stack
	}

	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			s2.pop();
		}
		return value;
	}

	public int min() {
		if (s2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}
}
