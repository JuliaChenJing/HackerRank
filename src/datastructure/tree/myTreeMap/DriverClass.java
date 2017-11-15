package datastructure.tree.myTreeMap;

public class DriverClass {

	public static void main(String[] args) {

		MyTreeMap theTree = new MyTreeMap();

		theTree.addNode(50, "Boss");

		theTree.addNode(25, "Vice President");

		theTree.addNode(15, "Office Manager");

		theTree.addNode(30, "Secretary");

		theTree.addNode(75, "Sales Manager");

		theTree.addNode(85, "Salesman");

		// Different ways to traverse binary trees

		theTree.inOrderTraverseTree(theTree.root);

		// theTree.preorderTraverseTree(theTree.root);

		// theTree.postOrderTraverseTree(theTree.root);

		// Find the node with key 75

		System.out.println("\n TreeMapEntry with the key 75");

		System.out.println(theTree.findNode(75));

	}
}

