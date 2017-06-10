package datastructure.stack;

//Describe how you could use a single array to implement three stacks
public class ThreeStacksFromOneArray_II {
	/*
	 * In this approach, any stack can grow as long as there is any free space
	 * in the array. We sequentially allocate space to the stacks and we link
	 * new blocks to the previous block. This means any new element in a stack
	 * keeps a pointer to the previous top element of that particular stack.
	 * 
	 * In this implementation, we face a problem of unused space. For example,
	 * if a stack deletes some of its elements, the deleted elements may not
	 * necessarily appear at the end of the array. So, in that case, we would
	 * not be able to use those newly freed spaces.
	 * 
	 * To overcome this deficiency, we can maintain a free list and the whole
	 * array space would be given initially to the free list. For every
	 * insertion, we would delete an entry from the free list.
	 * 
	 * In case of deletion, we would simply add the index of the free cell to
	 * the free list. In this implementation we would be able to have flexibility
	 * in terms of variable space utilization but we would need to increase the
	 * space complexity.
	 */
	static int STACK_SIZE = 300;
	int indexUsed = 0;
	int[] stackPointer = { -1, -1, -1 };
	StackNode[] buffer = new StackNode[STACK_SIZE * 3];

	void push(int stackNum, int value) {
		int lastIndex = stackPointer[stackNum];
		stackPointer[stackNum] = indexUsed;
		indexUsed++;
		buffer[stackPointer[stackNum]] = new StackNode(lastIndex, value);
	}

	int pop(int stackNum) {
		int value = buffer[stackPointer[stackNum]].value;
		int lastIndex = stackPointer[stackNum];
		stackPointer[stackNum] = buffer[stackPointer[stackNum]].previous;
		buffer[lastIndex] = null;
		indexUsed--;
		return value;
	}

	int peek(int stack) {
		return buffer[stackPointer[stack]].value;
	}

	boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == -1;
	}

	class StackNode {
		public int previous;
		public int value;

		public StackNode(int p, int v) {
			value = v;
			previous = p;
		}
	}
}