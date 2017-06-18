package datastructure.tree;

/*
 *  Implement a function to check if a tree is balanced. For the purposes of this question,
a balanced tree is defined to be a tree such that no two leaf nodes differ in distance
from the root by more than one.
 */
public class IsBalanced {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.right = new Node(5);
		root.right.right.right = new Node(7);
		System.out.println("Is it a balanced tree? " + isBalanced(root));
		System.out.println("The max height of the tree is : " + maxDepth(root));
		System.out.println("The min height of the tree is : " + minDepth(root));

	}

	public static boolean isBalanced(Node root) {
		return (maxDepth(root) - minDepth(root) <= 1);
	}

	// calculate the max depth of a tree=the height of the tree
	public static int maxDepth(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	// calculate the min depth of a tree
	public static int minDepth(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

}
