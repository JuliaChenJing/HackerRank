package datastructure.tree;

//https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
public class Insert {


	// Runtime: O(log n) on a balanced tree.
	// Space Complexity: O(1)
	//return the root of the new tree
	static TreeNode Insert(TreeNode root, int value) {
		/* Create new Node */
		TreeNode newNode = new TreeNode(value);

		/* Special case: empty tree */
		if (root == null) {
			return newNode;
		}

		/* Iteratively walk tree and insert new Node */
		TreeNode curr = root;
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

	static TreeNode InsertWithRecurstion(TreeNode root, int value) {

		/* Create new Node */
		TreeNode newNode = new TreeNode(value);
	

		/* Special case: empty tree */
		if (root == null) {
			return newNode;
		}
		TreeNode roottracker = root;
		helper(root, value);

		return roottracker;
	}

	static void helper(TreeNode root, int value) {

		TreeNode newNode = new TreeNode(value);
	
		/* Iteratively walk tree and insert new Node */
		TreeNode curr = root;

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
