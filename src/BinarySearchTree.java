public class BinarySearchTree {

	Node root;
	public static void main(String[] args) {

		Node testNode = null, succ = null;

		// Create a Binary Search Tree
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(20);
		tree.insert(9);
		tree.insert(25);
		tree.insert(5);
		tree.insert(12);
		tree.insert(11);
		tree.insert(14);

		// Get a reference to the node whose key is 9
		testNode = tree.getNodeByKey(14);

		// Find the in order successor of test
		succ = tree.findInOrderSuccessor(testNode);

		// Print the key of the successor node
		if (succ != null) {
			System.out.println("Inorder successor of " + testNode.key + " is " + succ.key);
		} else {
			System.out.println("Inorder successor does not exist");
		}
	}

	

	Node findInOrderSuccessor(Node inputNode) {

		if (inputNode.right != null) {// right node is not null

			Node node = inputNode.right;
			while (node.left != null)
				node = node.left;
			return node;
		}
		
		else {// right node is null
			Node parent = inputNode.parent;
			Node node = inputNode;

			while (parent.left != node) {
				node = parent;
				parent = parent.parent;
			}

			return parent;

		}
	}

	// Given a binary search tree and a number, inserts a new node
	// with the given number in the correct place in the tree
	void insert(int key) {

		// 1. If the tree is empty, create the root
		if (root == null) {
			root = new Node(key);
			return;
		}

		// 2) Otherwise, create a node with the key
		// and traverse down the tree to find where to
		// to insert the new node
		Node currentNode = root;
		Node newNode = new Node(key);

		while (currentNode != null) {
			if (key < currentNode.key) {
				if (currentNode.left == null) {
					currentNode.left = newNode;
					newNode.parent = currentNode;
					break;
				} else {
					currentNode = currentNode.left;
				}
			} else {
				if (currentNode.right == null) {
					currentNode.right = newNode;
					newNode.parent = currentNode;
					break;
				} else {
					currentNode = currentNode.right;
				}
			}
		}
	}

	// Return a reference to a node in the BST by its key.
	// Use this method when you need a node to test your
	// findInOrderSuccessor method on
	Node getNodeByKey(int key) {
		Node currentNode = root;

		while (currentNode != null) {
			if (key == currentNode.key) {
				return currentNode;
			}

			if (key < currentNode.key) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}

		return null;
	}

	
	class Node {

		int key;
		Node left;
		Node right;
		Node parent;

		Node(int key) {
			this.key = key;
			left = null;
			right = null;
			parent = null;
		}
	}
}


