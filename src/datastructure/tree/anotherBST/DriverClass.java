package datastructure.tree.anotherBST;
class DriverClass {
	
	public static void main(String args[])
	{
		int arr[] = { 45, 25, 15, 10, 20, 30, 65, 55, 50, 60, 75, 80 };
		BinarySearchTree bst = new BinarySearchTree();

		System.out.println("1 test insert()");
		//insert all the array to the bst
		BSTNode root = null;
		// build tree by repeated insertions
		for (int i = 0; i < arr.length; i++)
			root = bst.insertTree(root, arr[i]);
		System.out.println();
		
		
		BSTNode root2 = root; // copy BST
		
		System.out.println("2 test search()");
		int key = 65;
		BSTNode item = bst.search(root2, key);
		if (item != null)
			System.out.print("item found: " + item.data);
		else
			System.out.println("Node " + key + " not found");
		System.out.println();
		
		System.out.println("3 test leafNodes()");
		System.out.print("\n Number of leaf nodes: " + bst.leafNodes(root));
		System.out.println();
		
		System.out.print("\n Inorder: ");
		bst.inorder(root);
		System.out.print("\n Preorder: ");
		bst.preorder(root);
		System.out.print("\n Postorder: ");
		bst.postorder(root);
		bst.inorder(root);
		key = 44; // insert 44
		bst.insertTree(root, key);
		System.out.println("\n Inorder, after insertion of " + key + ": ");
		bst.inorder(root);
		System.out.println("\nMinimum Value in the tree: " + bst.Minimum(root2).data);
		System.out.println("Maximum Value in the tree : " + bst.Maximum(root2).data);
	}
}
