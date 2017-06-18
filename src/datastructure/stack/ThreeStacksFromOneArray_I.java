package datastructure.stack;

//  Describe how you could use a single array to implement three stacks
public class ThreeStacksFromOneArray_I {

	/*
	 * Approach 1: Divide the array in three equal parts and allow the
	 * individual stack to grow in that limited space (note: “[“ means
	 * inclusive, while “(“ means exclusive of the end point). » for stack 1, we
	 * will use [0, n/3) » for stack 2, we will use [n/3, 2n/3) » for stack 3,
	 * we will use [2n/3, n) This solution is based on the assumption that we do
	 * not have any extra information about the usage of space by individual
	 * stacks and that we can’t either modify or use any extra space. With these
	 * constraints, we are left with no other choice but to divide equally.
	 */

	static int STACK_SIZE = 300;

	int[] buffer = new int[STACK_SIZE * 3];

	int[] stackPointer = { 0, 0, 0 }; // stack pointers to track top elem

	public static void main(String[] args) {

	}

	public void push(int stackNum, int value) {
		/*
		 * Find the index of the top element in the array + 1, and increment the
		 * stack pointer
		 */
		int index = stackNum * STACK_SIZE + stackPointer[stackNum] + 1;
		stackPointer[stackNum]++;
		buffer[index] = value;
	}

	public int pop(int stackNum) {

		int index = stackNum * STACK_SIZE + stackPointer[stackNum];

		stackPointer[stackNum]--;
		int value = buffer[index];
		buffer[index] = 0;
		return value;
	}

	public int peek(int stackNum) {
		int index = stackNum * STACK_SIZE + stackPointer[stackNum];
		return buffer[index];
	}

	public boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == stackNum * STACK_SIZE;
	}

}