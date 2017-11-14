package datastructure.queue.arrayQueue;

class ArrayQueue {

	private Object a[];
	private int front, rear; // stack top

	public ArrayQueue(int n) // constructor
	{
		a = new Object[n]; // create stack array
		front = -1; // no items in the stack
		rear = -1;
	}

	public void add(Object item) {

		if (front == -1)
		// queue is empty; insert first item
		{
			a[0] = item;
			front++;
			rear++;
		}else if (front == 0 && rear == 0)
		// queue contains one item; insert second item
		{
			a[1] = item;
			rear++;
		} else if (rear == a.length - 1) {
			System.out.println("Stack is full");
			return;
		} else
		// queue contains 2 or more items
		{
			a[++rear] = item;
		}

	}

	public Object remove() {
		if (isEmpty()) {
			System.out.println("Q is empty");
			return null;
		}
		else
		{
			Object temp=a[0];
			for(int i=0;i<rear;i++)
			{
				a[i]=a[i+1];
				
			}
			rear--;
			return temp;
		}
		
		
	}

	public Object peek() {
		return a[0];
	}

	public int size() {
		return  rear+1;
	}

	public boolean isEmpty() {
		if(rear==-1)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		String re="";
		for(int i=0;i<rear+1;i++)
			re+="a["+i+"]="+a[i]+"\n";
		return re;

	}
}
