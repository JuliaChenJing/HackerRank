package datastructure.linkedlist.myStringLinkedList;
public class DriverClass {

	public static void main(String[] args) {
		System.out.println("1 test toString()");
		MyStringLinkedList mySL = new MyStringLinkedList();
		System.out.println(mySL);
		System.out.println();
		
		
		
		System.out.println("2.1 test addFront()");
		mySL.addFront("Carrot Cake");
		mySL.addFront("Blueberry Muffin");
		mySL.addFront("Apple Pie");
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
		
		
		System.out.println("2.2 test addLast()");
		mySL.addLast("Orange Juice");
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
		System.out.println("3.1 test deleteNode()");
		mySL.deleteNode(mySL.findItem("Apple Pie"));
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
		
		System.out.println("3.2 test deleteNode()");
		mySL.deleteNode(mySL.findItem("Peach Sauce"));
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
		
		System.out.println("3.3 test deleteNode()");
		mySL.deleteNode(mySL.findItem("Carrot Cake"));
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
	
		
		
		System.out.println("4.1 test postAddNode()");
		mySL.postAddNode(mySL.findItem("Blueberry Muffin"), "Carrot Cake");
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
		System.out.println("4.2 test preAddNode()");
		mySL.preAddNode(mySL.findItem("Blueberry Muffin"), "Apple Pie" );
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println("Is the linked list empty? " + mySL.isEmpty());
		System.out.println();
		
		System.out.println("5 test the recursive print method to display the elements in the list.");
		mySL.print(mySL.header);
		System.out.println();
		
		System.out.println("6 test size()");
		System.out.println("the size of the linked list is : " + mySL.Size());
		System.out.println();
		
		System.out.println("7.1 test getLast()");
		System.out.println(mySL.getLast());
		System.out.println();
		
		System.out.println("7.2 test getFirst()");
		System.out.println(mySL.getFirst());
		System.out.println();
		
		System.out.println("8.1 test removeFirst()");
		mySL.removeFirst();
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
		System.out.println("8.2 test removeLast()");
		mySL.removeLast();
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
		
		
		System.out.println("9 test deleteList()");
		mySL.deleteList();
		System.out.println(mySL);
		mySL.printReverse();
		System.out.println();
		
		System.out.println("10 test isEmpty()");
		System.out.println("Is the linked list empty? " + mySL.isEmpty());
		System.out.println("the size of the linked list is : " + mySL.Size());
		System.out.println();		
		
	}

}
/*
 1 test toString()
-->[NULL]

2.1 test addFront()
-->[Apple Pie]-->[Blueberry Muffin]-->[Carrot Cake]-->[NULL]
==>[Carrot Cake]==>[Blueberry Muffin]==>[Apple Pie]==>[NULL]

2.2 test addLast()
-->[Apple Pie]-->[Blueberry Muffin]-->[Carrot Cake]-->[Orange Juice]-->[NULL]
==>[Orange Juice]==>[Carrot Cake]==>[Blueberry Muffin]==>[Apple Pie]==>[NULL]

3.1 test deleteNode()
I am here 2
-->[Blueberry Muffin]-->[Carrot Cake]-->[Orange Juice]-->[NULL]
==>[Orange Juice]==>[Carrot Cake]==>[Blueberry Muffin]==>[NULL]

3.2 test deleteNode()
-->[Blueberry Muffin]-->[Carrot Cake]-->[Orange Juice]-->[NULL]
==>[Orange Juice]==>[Carrot Cake]==>[Blueberry Muffin]==>[NULL]

3.3 test deleteNode()
I am here 4
-->[Blueberry Muffin]-->[Orange Juice]-->[NULL]
==>[Orange Juice]==>[Blueberry Muffin]==>[NULL]

4.1 test postAddNode()
-->[Blueberry Muffin]-->[Carrot Cake]-->[Orange Juice]-->[NULL]
==>[Orange Juice]==>[Carrot Cake]==>[Blueberry Muffin]==>[NULL]

4.2 test preAddNode()
-->[Apple Pie]-->[Blueberry Muffin]-->[Carrot Cake]-->[Orange Juice]-->[NULL]
==>[Orange Juice]==>[Carrot Cake]==>[Blueberry Muffin]==>[Apple Pie]==>[NULL]
Is the linked list empty? false

5 test the recursive print method to display the elements in the list.
Apple Pie
Blueberry Muffin
Carrot Cake
Orange Juice

6 test size()
the size of the linked list is : 4

7.1 test getLast()
Orange Juice

7.2 test getFirst()
Apple Pie

8.1 test removeFirst()
-->[Blueberry Muffin]-->[Carrot Cake]-->[Orange Juice]-->[NULL]
==>[Orange Juice]==>[Carrot Cake]==>[Blueberry Muffin]==>[NULL]

8.2 test removeLast()
-->[Blueberry Muffin]-->[Carrot Cake]-->[NULL]
==>[Carrot Cake]==>[Blueberry Muffin]==>[NULL]

9 test deleteList()
-->[NULL]
==>[NULL]

10 test isEmpty()
Is the linked list empty? true
the size of the linked list is : 0

*/
