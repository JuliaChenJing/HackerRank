package datastructure.tree.myBST;

public class DriverClass {

	public static void main(String[] args) {
		
		MyBST mybst = new MyBST();
		
		int [] a = {15, 12, 9, 56, 1, 16, 19, 22, 3, 100, 2, 25};
	
		System.out.println("1 test insert() and printTree()");
	
		for (int j = 0; j < a.length; j++ ) {
			mybst.insert(a[j]);		
			mybst.printTree();
			System.out.println();
		}
		System.out.println();
		
		mybst.insert(3);
		mybst.insert(5);
		mybst.printTree();
		System.out.println();
		
		System.out.println();
		
		System.out.println("2 test preOrder()");
		mybst.preOrder(mybst.root);
		System.out.println();
		System.out.println();
		
		System.out.println("3 test inOrder()");
		mybst.inOrder(mybst.root);
		System.out.println();
		System.out.println();
		
		System.out.println("4 test postOrder()");
		mybst.postOrder(mybst.root);
		System.out.println();
		System.out.println();
		
		System.out.println("5 test contains()");
		System.out.println(mybst.contains(20));
		System.out.println(mybst.contains(5));
		System.out.println();
		
		System.out.println("5 test getRoot()");
		System.out.println(mybst.getRoot());
		System.out.println();
		
		System.out.println("5 test leafNodes()");
		System.out.println(mybst.leafNodes());
		System.out.println();
		
		System.out.println("6 test size()");
		System.out.println(mybst.size());
		System.out.println();
		
		System.out.println("7 test isEmpty()");
		System.out.println(mybst.isEmpty());
		System.out.println();
		
	}
}
