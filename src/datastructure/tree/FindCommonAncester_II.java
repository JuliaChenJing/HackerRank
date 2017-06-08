package datastructure.tree;

/*
 * Design an algorithm and write code to find the first common ancestor of two nodes
in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.
 */
public class FindCommonAncester_II {

	/*
	 * For any node r, we know the following: 
	 * 1. If p is on one side and q is on
	 * the other, r is the first common ancestor. 
	 * 
	 * 2. Else, the first common
	 * ancestor is on the left or the right side. So, we can create a simple
	 * recursive algorithm called search that calls search(left side) and
	 * search(right side) looking at how many nodes (p or q) are placed from the
	 * left side and from the right side of the current node. If there are two
	 * nodes on one of the sides, then we have to check if the child node on
	 * this side is p or q (because in this case the current node is the common
	 * ancestor). If the child node is neither p nor q, we should continue to
	 * search further (starting from the child). If one of the searched nodes (p
	 * or q) is located on the right side of the current node, then the other
	 * node is located on the other side. Thus the current node is the common
	 * ancestor
	 */
	
	static int TWO_NODES_FOUND = 2;
	static int ONE_NODE_FOUND = 1;
	static int NO_NODES_FOUND = 0;

	// Checks how many “special” nodes are located under this root
	int covers(TreeNode root, TreeNode p, TreeNode q) {
		int ret = NO_NODES_FOUND;
		if (root == null)
			return ret;
		if (root == p || root == q)
			ret += 1;
		ret += covers(root.left, p, q);
		if (ret == TWO_NODES_FOUND) // Found p and q
			return ret;// if two nodes found in left, no need to check right side
		return ret + covers(root.right, p, q);
	}

	TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (q == p && (root.left == q || root.right == q))
			return root;
		int nodesFromLeft = covers(root.left, p, q); // Check left side
		if (nodesFromLeft == TWO_NODES_FOUND) {
			if (root.left == p || root.left == q)
				return root.left;
			else
				return commonAncestor(root.left, p, q);
		} else if (nodesFromLeft == ONE_NODE_FOUND) {
			if (root == p)
				return p;
			else if (root == q)
				return q;
		}
		int nodesFromRight = covers(root.right, p, q); // Check right side
		if (nodesFromRight == TWO_NODES_FOUND) {
			if (root.right == p || root.right == q)
				return root.right;
			else
				return commonAncestor(root.right, p, q);
		} else if (nodesFromRight == ONE_NODE_FOUND) {
			if (root == p)
				return p;
			else if (root == q)
				return q;
		}
		if (nodesFromLeft == ONE_NODE_FOUND && nodesFromRight == ONE_NODE_FOUND)
			return root;
		else
			return null;
	}
}
