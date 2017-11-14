package datastructure.queue.arrayQueue;

public class DriverClass {

	public static void main(String[] args)
	{
		ArrayQueue q = new ArrayQueue(3);
		
		System.out.println("1 test add() and toString()");
		q.add('A');
		q.add('B');
		System.out.println(q.toString());
		q.add('C');
		q.add('D');
		System.out.println(q.toString());
		System.out.println();
		
		System.out.println("2 test remove() ");
		System.out.println("Remove(): " + q.remove());
		System.out.println(q.toString());
		System.out.println();
		
		System.out.println("3 test peek() ");
		System.out.println("peek(): " + q.peek());
		System.out.println(q.toString());
		System.out.println();
		
		
		System.out.println("4 test size () and empty() ");
		System.out.println("size(): " + q.size());
		System.out.println("isEmpty(): " + q.isEmpty());
		System.out.println(q.toString());
		ArrayQueue q1 = new ArrayQueue(3);
		System.out.println("isEmpty(): " + q1.isEmpty());
	}

}

/*
1 test add() and toString()
a[0]=A
a[1]=B

Stack is full
a[0]=A
a[1]=B
a[2]=C


2 test remove() 
Remove(): A
a[0]=B
a[1]=C


3 test peek() 
peek(): B
a[0]=B
a[1]=C


4 test size () and empty() 
size(): 2
isEmpty(): false
a[0]=B
a[1]=C

isEmpty(): true

 */
 

