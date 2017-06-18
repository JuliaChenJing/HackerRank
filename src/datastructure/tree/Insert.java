package datastructure.tree;

//https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
public class Insert {

	// Runtime: O(log n) on a balanced tree.
	// Space Complexity: O(1)
	// return the root of the new tree
	static Node Insert(Node root, int value) {
		/* Create new Node */
		Node newNode = new Node(value);

		/* Special case: empty tree */
		if (root == null) {
			return newNode;
		}

		/* Iteratively walk tree and insert new Node */
		Node curr = root;
		while (true) {
			if (value <= curr.value) {
				if (curr.left == null) {
					curr.left = newNode;
					return root;
				} else {
					curr = curr.left;
				}
			} else {
				if (curr.right == null) {
					curr.right = newNode;
					return root;
				} else {
					curr = curr.right;
				}
			}
		}
	}

	static Node InsertWithRecurstion(Node root, int value) {

		/* Create new Node */
		Node newNode = new Node(value);

		/* Special case: empty tree */
		if (root == null) {
			return newNode;
		}
		Node roottracker = root;
		helper(root, value);

		return roottracker;
	}

	static void helper(Node root, int value) {

		Node newNode = new Node(value);

		/* Iteratively walk tree and insert new Node */
		Node curr = root;

		if (value <= curr.value) {
			if (curr.left == null) {
				curr.left = newNode;
				return;
			} else {
				helper(curr.left, value);
			}
		} else {
			if (curr.right == null) {
				curr.right = newNode;
				return;
			} else {
				helper(curr.right, value);
			}
		}

	}

}
