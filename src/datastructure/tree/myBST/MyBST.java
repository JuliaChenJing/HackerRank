package datastructure.tree.myBST;


// Demo code for the user implemenation of Binary search tree
public class MyBST {
	/** The tree root. */
	protected BinaryNode root;

	public MyBST() {
		root = null;
	}
	
	/**
	* Prints the values in the nodes of the tree
	* in sorted order. Inorder Traversal
	*/
	public void printTree() {
		if( root == null )
			System.out.println( "Empty tree" );
		else
			printTree(root);
	}
	// Inorder Traversal to print the nodes in Ascending order
	private void printTree( BinaryNode t ){
		if( t != null ){
			printTree( t.left );
		    System.out.print(t.element+",");
		    printTree( t.right );
		} 
	}
		 
	//Assume the data in the Node is an Integer.	

	public void insert(Integer x) {
		if (root == null) {
			root = new BinaryNode(x);
			return;
		}
		else { 
			BinaryNode n = root;
			boolean inserted = false;

			while(!inserted)//true
				{
				if(x.compareTo(n.element)<0) {
					//space found on the left
					if(n.left == null){
						n.left = new BinaryNode(x,null,null);
						inserted = true;
					}
					//keep looking for a place to insert (a null)
					else {
						n = n.left;
					}
				}				
				else if(x.compareTo(n.element)>0){ 
					//space found on the right					
					if(n.right==null){
					n.right = new BinaryNode(x,null,null);
					inserted = true;
					}
						//keep looking for a place to insert (a null)
					else {
							n = n.right;
					}
										
				}
				// if a node already exists
				else {
					inserted = true;
				}

			}

		}
	}
	
	 public  void preOrder(BinaryNode t)
	 {
			if (t!= null) {

				System.out.print(t);
				preOrder(t.left);
				preOrder(t.right);

			}

		 
	 }
	 
	 public  void inOrder(BinaryNode t)
	 {
		 if (t!= null) {

			    inOrder(t.left);
				System.out.print(t);
				inOrder(t.right);

			}

		 
	 }
	 
	 public  void postOrder(BinaryNode t)
	 {
		 if (t!= null) {

				
				postOrder(t.left);
				postOrder(t.right);
				System.out.print(t);

			}

		 
	 }
	 
	 public boolean contains(int key)
	 {
			// Start at the top of the tree

			BinaryNode focusNode = root;

			// While we haven't found the Node
			// keep looking

			while (focusNode.element != key) {

				// If we should search to the left

				if (key < focusNode.element) {

					// Shift the focus Node to the left child

					focusNode = focusNode.left;

				} else {

					// Shift the focus Node to the right child

					focusNode = focusNode.right;

				}

				// The node wasn't found

				if (focusNode == null)
					return false;

			}

		 return true;
		 
	 }
	 
	  public BinaryNode getRoot()
	  {
		  return root;
	  }
	  public  int leafNodes()
	  {
		  return leafNodes(root);
	  }
	  
	  private int leafNodes(BinaryNode t)
	  {
		 
		  if( t != null )
		  {
			  if((t.left==null )&&(t.right==null))
				  return 1;
			  else if(t.left==null)
				return leafNodes( t.right);
			  else  if(t.right==null)
			    return  leafNodes( t.left );
			  else return  leafNodes( t.left)+leafNodes( t.right );
			} 
		  
		  return 0;
		
	  }
	  
	  private int size(BinaryNode t)
	  {
		  
		   if( t != null ){
			  
			    return 1+size(t.left)+size(t.right);
			} 
		   
		   else
			   return 0;
		  
		  
	  }
	  
	  public int size()
	  {
		  
		 return size(root);
		  
		  
	  }
		
	  private boolean isEmpty(BinaryNode t)
	  {
		  if (t==null)
		 
			  return true;
		  else 
			  return false;
	  }
	  
	  public boolean isEmpty()
	  {
		 return isEmpty(root);
	  }
	  
}
		

