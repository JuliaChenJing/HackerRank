

void preOrder(Node root) {
if( root != null ){
     System.out.print(root.data+" ");
			preOrder( root.left );
		    preOrder( root.right );
		} 
    
}


/
void postOrder(Node root) {
    if(root!=null)
        {
        postOrder(root.left);
          postOrder(root.right);
        System.out.print(root.data+" ");
    }

}

void inOrder(Node root) {
  if(root!=null)
  {
      inOrder(root.left);
      System.out.print(root.data+" ");
      inOrder(root.right);
  }
}


//https://www.hackerrank.com/challenges/tree-top-view/problem
void topView(Node root) {
    if (root != null) {
        printLeft(root.left);
        System.out.print(root.data + " ");
        printRight(root.right);
    }
}

void printLeft(Node n) {
    if (n != null) {
        printLeft(n.left);
        System.out.print(n.data + " ");
    }
}

void printRight(Node n) {
    if (n != null) {
        System.out.print(n.data + " ");
        printRight(n.right);
    }
}


	
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
