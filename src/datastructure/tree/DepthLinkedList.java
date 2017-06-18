package datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * Given a binary search tree, design an algorithm which creates a linked list of all the
nodes at each depth (eg, if you have a tree with depth D, you’ll have D linked lists).
 */
public class DepthLinkedList {
	
//https://www.hackerrank.com/challenges/tree-level-order-traversal/problem	
void levelOrder(Node root) {
    ArrayDeque<Node> deque = new ArrayDeque<>(); // use deque as a queue
    if (root != null) {
        deque.add(root);
    }
    while (!deque.isEmpty()) {
        Node n = deque.remove();
        System.out.print(n.data + " ");
        if (n.left != null) {
            deque.add(n.left);
        }
        if (n.right != null) {
            deque.add(n.right);
        }
    }
}

	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		ArrayList<LinkedList<TreeNode>> re = getDepthLinkedList(root);
		for (int i = 0; i < re.size(); i++) {
			System.out.print("depth=" + i + " :");
			for (int j = 0; j < re.get(i).size(); j++)
				System.out.print(re.get(i).get(j).value);
			System.out.println();
		}

	}

	/*
	 * We can do a simple level by level traversal of the tree, with a slight
	 * modification of the breadth first traversal of the tree.    In a usual
	 * breadth-first search traversal, we simply traverse the nodes without
	 * caring which level we are on. In this case, it is critical to know the
	 * level. We thus use a dummy node to indicate when we have finished one
	 * level and are starting on the next.
	 */
	static ArrayList<LinkedList<TreeNode>> getDepthLinkedList(TreeNode root) {
		
		int level = 0;

		// stores the resultArrayList as a List of LinkedList<TreeNode>
		ArrayList<LinkedList<TreeNode>> resultArrayList = new ArrayList<LinkedList<TreeNode>>();
		
		// list initiation
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();

		// the level 0 list is just a root node
		list.add(root);
		resultArrayList.add(level, list);//level=0

		//数学归纳法
		while (true) {
			// list initiation again
			list = new LinkedList<TreeNode>();
			
			// for each of the node in the previous list stored in the resultArrayList
			for (int i = 0; i < resultArrayList.get(level).size(); i++) {
				TreeNode node = (TreeNode) resultArrayList.get(level).get(i);

				if (node != null) {

					if (node.left != null)
						list.add(node.left);
					if (node.right != null)
						list.add(node.right);
				}
			}

			// if there is something stored in the list
			if (list.size() > 0) {
				// the new list is added into the resultArrayList as the level+1 list
				resultArrayList.add(level + 1, list);
			} else {
				break;// jump out of the while
			}

			level++;
		}
		return resultArrayList;
	}

}
