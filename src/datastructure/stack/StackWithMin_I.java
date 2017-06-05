package datastructure.stack;

import java.util.Stack;

/*
 *  How would you design a stack which, in addition to push and pop, also has a function
    min which returns the minimum element? Push, pop and min should all operate in
    O(1)
 */
public class StackWithMin_I extends Stack<NodeWithMin> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * You can implement this by having each node in the stack keep track of the
	 * minimum beneath itself. Then, to find the min, you just look at what the
	 * top element thinks is the min. When you push an element onto the stack,
	 * the element is given the current minimum. It sets its “local min” to be
	 * the min.
	 */
	public void push(int value) {
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value, newMin));
	}

	public int min() {
		if (this.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return peek().min;
		}
	}
}

class NodeWithMin {
	public int value;
	public int min;// added to store the new min when new value is pushed

	public NodeWithMin(int v, int min) {
		value = v;
		this.min = min;
	}
}
