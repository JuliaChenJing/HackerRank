package datastructure.tree.anotherBST;
class BinarySearchTree {
	//insert
	public BSTNode insertTree(BSTNode p, int key) // create BST
	{
		if (p == null)
			p = new BSTNode(key); // Root node
		else if (key < p.data)
			p.left = insertTree(p.left, key); // Insert into Left
		else
			p.right = insertTree(p.right, key); // Insert into Right
		return p; // return root
	}

	
	public void inorder(BSTNode p) // 'p' starts with root
	{
		if (p != null) {
			inorder(p.left);
			System.out.print(p.data + " ");
			inorder(p.right);
		}
	}

	// Implement this method

	public int leafNodes(BSTNode p)
	{
		return 1;
	}

	// Implement this method

	public BSTNode Minimum(BSTNode p)
	{

		return null;
	}

	// Implement this method

	public BSTNode Maximum(BSTNode p)
	{
		return null;
	}

	// Implement this method

	public void preorder(BSTNode p) {
	}

	// Implement this method

	public void postorder(BSTNode p) {
	}

	public BSTNode search(BSTNode root2, int key) {
		// TODO Auto-generated method stub
		return null;
	}

} // end of BinarySearchTree class
	////////////////////// BinarySearchTreeDemo.java ////////////////////
