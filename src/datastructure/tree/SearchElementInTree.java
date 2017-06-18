package datastructure.tree;

import java.util.Scanner;

public class SearchElementInTree {

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(25);
		root.right.right = new Node(40);

		System.out.println("which number do you want to search in tree?");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if (isPresent(root, num))
			System.out.println("The number " + num + " exists in tree.");
		else
			System.out.println("The number " + num + " does't exist in tree.");

	}

	public static boolean isPresent(Node root, int x) {
		if (root != null) {

			// check if current TreeNode has the element we are looking for
			if (root.value == x) {
				return true;
			} else {
				// check if the sub trees
				return isPresent(root.left, x) || isPresent(root.right, x);
			}
		}
		return false;
	}

}
