
package datastructure.tree;

import java.util.ArrayDeque;

public class Traversal {

	void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.value + " ");
			preOrder(root.left);
			preOrder(root.right);
		}

	}

	void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.value + " ");
		}

	}

	void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.value + " ");
			inOrder(root.right);
		}
	}

	// https://www.hackerrank.com/challenges/tree-top-view/problem
	void topView(Node root) {
		if (root != null) {
			printLeft(root.left);
			System.out.print(root.value + " ");
			printRight(root.right);
		}
	}

	void printLeft(Node n) {
		if (n != null) {
			printLeft(n.left);
			System.out.print(n.value + " ");
		}
	}

	void printRight(Node n) {
		if (n != null) {
			System.out.print(n.value + " ");
			printRight(n.right);
		}
	}

	// https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
	void levelOrder(Node root) {
		ArrayDeque<Node> deque = new ArrayDeque<>(); // use deque as a queue
		if (root != null) {
			deque.add(root);
		}
		while (!deque.isEmpty()) {
			Node n = deque.remove();
			System.out.print(n.value + " ");
			if (n.left != null) {
				deque.add(n.left);
			}
			if (n.right != null) {
				deque.add(n.right);
			}
		}
	}
}
