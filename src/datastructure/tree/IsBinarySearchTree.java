//    https://www.hackerrank.com/challenges/is-binary-search-tree/problem

package datastructure.tree;

public class IsBinarySearchTree {

	boolean checkBST(Node root) {
		return checkBST(root, 0, 10000);
	}

	boolean checkBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		} else if (node.value < min || node.value > max) { //we assume BST cannot have duplicate values
			return false;
		} else {
			return checkBST(node.left, min, node.value - 1) && checkBST(node.right, node.value + 1, max);
		}
	}

}