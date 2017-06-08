package datastructure.tree;
import java.util.Scanner;

public class SearchElementInTree {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(12);
		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(40);

		System.out.println("which number do you want to search in tree?");
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		if(isPresent(root,num ))
			System.out.println("The number "+num+ " exists in tree.");
		else
			System.out.println("The number "+num+ " does't exist in tree.");

	}

	public static boolean isPresent(TreeNode root, int x) {
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
