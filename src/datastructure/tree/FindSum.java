package datastructure.tree;

import java.util.ArrayList;

/*
 *  You are given a binary tree in which each node contains a value. Design an algorithm
to print all paths which sum up to that value. Note that it can be any path in the tree
- it does not have to start at the root.
 */
public class FindSum {
	/*
	 * Solution： Let’s approach this problem by simplifying it. What if the path
	 * had to start at the root? In that case, we would have a much easier
	 * problem: Start from the root and branch left and right, computing the sum
	 * thus far on each path. When we find the sum, we print the current path.
	 * Note that we don’t stop just because we found the sum. Why? Because we
	 * could have the following path (assume we are looking for the sum 5): 2 +
	 * 3 + –4 + 3 + 1 + 2. If we stopped once we hit 2 + 3, we’d miss several
	 * paths (2 + 3 + -4 + 3 + 1 and 3 + -4 + 3 + 1 + 2). So, we keep going
	 * along every possible path. Now, what if the path can start anywhere? In
	 * that case, we make a small modification. On every node, we look “up” to
	 * see if we’ve found the sum. That is—rather than asking “does this node
	 * start a path with the sum?,” we ask “does this node complete a path with
	 * the sum?
	 */
	void findSum(TreeNode head, int sum, ArrayList<Integer> buffer, int start) {
		if (head == null)
			return;
		int tmp = sum;
		buffer.add(head.value);
		for (int i = start; i > -1; i--) {
			tmp = tmp - buffer.get(i);
			if (tmp == 0)
				print(buffer, i, start);// find it,print it
		}
		ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
		ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
		findSum(head.left, sum, c1, start + 1);
		findSum(head.right, sum, c2, start + 1);
	}

	void print(ArrayList<Integer> buffer, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(buffer.get(i) + "");
		}
		System.out.println();
	}
	
	/*
	 * What is the time complexity of this algorithm? Well, if a node is at level r, we do r amount
of work (that’s in the looking “up” step). We can take a guess at O(n lg n) (n nodes, doing anaverage of lg n amount of work on each step), or we can be super mathematical:
There are 2^r nodes at level r.
1*2^1 + 2*2^2 + 3*2^3 + 4*2^4 + ... d * 2^d
= sum(r * 2^r, r from 0 to depth)
= 2 (d‐1) * 2^d + 2
n = 2^d ==> d = lg n
NOTE: 2^lg(x) = x
O(2 (lg n ‐ 1) * 2^(lg n) + 2) = O(2 (lg n ‐ 1) * n ) = O(n lg n)
Following similar logic, our space complexity is O(n lg n).
	 */
}
