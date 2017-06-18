package datastructure.tree;

/*
 * Design an algorithm and write code to find the first common ancestor of two nodes
in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.
 */
public class FindCommonAncester_I {
//	https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/submissions/code/46958760
	
// Assumes tree has unique values.
// This problem is simpler since we're given a binary SEARCH tree.

//  Time Complexity: O(log n) on a balanced tree
// Space Complexity: O(1)
static Node lca(Node n, int v1, int v2) {
    while (n != null) {
        if (n.data > v1 && n.data > v2) {
            n = n.left;
        } else if (n.data < v1 && n.data < v2) {
            n = n.right;
        } else {
            break;
        } 
    }
    return n;
}


	/*
	 * Solution: If this were a binary search tree, we could do a modified find
	 * on the two nodes and see where the paths diverge. Unfortunately, this is
	 * not a binary search tree, so we much try other approaches.
	 * 
	 * Attempt #1: If each node has a link to its parent, we could trace p and
	 * q’s paths up until they intersect.
	 * 
	 * Attempt #2: Alternatively, you could follow a chain in which p and q are
	 * on the same side. That is, if p and q are both on the left of the node,
	 * branch left to look for the common ancestor. When p and q are no longer
	 * on the same side, you must have found the first common ancestor.
	 */
	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		// p and q is in the left branch
		if (covers(root.left, p) && covers(root.left, q))
			return commonAncestor(root.left, p, q);

		// p and q is in the right branch
		if (covers(root.right, p) && covers(root.right, q))
			return commonAncestor(root.right, p, q);

		// p and q is not in the same branch
		return root;
	}

	// Is p a child of root?
	private boolean covers(TreeNode root, TreeNode p) {

		if (root == null)
			return false;

		if (root == p)
			return true;

		return covers(root.left, p) || covers(root.right, p);
	}

	/*
	 * What is the running time of this algorithm? One way of looking at this is
	 * to see how many times each node is touched. Covers touches every child
	 * node, so we know that every single node in the tree must be touched at
	 * least once, and many nodes are touched multiple times.
	 * 
	 */

}
