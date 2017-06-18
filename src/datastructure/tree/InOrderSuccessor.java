package datastructure.tree;

/*
 *     Write an algorithm to find the ‘next’ node (e.g., in-order successor)
 *     of a given node in a binary search tree where each node has a link
 *     to its parent.
 */
public class InOrderSuccessor {

	class TreeNode {
		TreeNode left;
		TreeNode right;
		TreeNode parent;// each node has a link to its parent
		int value;

		TreeNode(int v) {
			value = v;
		}
	}

	/*
	 * Solution: On an in-order traversal, we visit X.left, then X, then
	 * X.right. So, if we want to find X.successor(), we do the following:
	 * 
	 * 1. If X has a right child, then the successor must be on the right side
	 * of X (because of the order in which we visit nodes). Specifically, the
	 * left-most child must be the first node visited in that subtree.
	 * 
	 * 2. Else， we go to X 's parent (call it P).
	 * 
	 * 2.a. If X was a left child (P.left = X), then P is the successor of X
	 * 
	 * 2.b. If X was a right child (P.right = X), then we have fully visited P,
	 * so we call successor(P).
	 */

	public static TreeNode inorderSucc(TreeNode e) {
		if (e == null)
			return null;

		TreeNode p;

		// 1 Found right children ‐> return 1st inorder node on right
		if (e.parent == null || e.right != null) {
			p = leftMostChild(e.right);
		} else {

			// 2b Go up until we’re on left instead of right
			while ((p = e.parent) != null) {
				if (p.left == e) {
					break;// 2a
				}
				e = p;
			}
		}
		return p;

	}

	// find the left most child of the tree which has the parent node as e
	public static TreeNode leftMostChild(TreeNode e) {
		if (e == null)
			return null;
		while (e.left != null)
			e = e.left;
		return e;
	}
}
