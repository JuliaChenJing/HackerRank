package datastructure.queue;


class ArrayQueue {

	private Object a[];
	private int front, back; 
	

	public static void main(String[] args)
	{
		ArrayQueue s=new ArrayQueue(5);
		
		s.enqueue(1);
		s.enqueue(2);
		s.enqueue(3);
		System.out.println(s.toString()+"      count: "+(s.size()));
		s.dequeue();
		System.out.println(s.toString()+"      count: "+(s.size()));
		s.enqueue(4);
		s.dequeue();
		s.enqueue(5);
		System.out.println(s.toString()+"      count: "+(s.size()));
	}
	
	public ArrayQueue(int n) // constructor
	{
		a = new Object[n]; // create stack array
		front = -1; // no items in the stack
		back = -1;
		
	}

	public void enqueue(Object item) {

		if (front == -1)
		// queue is empty; insert front item
		{
			a[0] = item;
			front++;
			back++;
		}else if (front == 0 && back == 0)
		// queue contains one item; insert second item
		{
			a[1] = item;
			back++;
		} else if (back == a.length - 1) {
			System.out.println("Stack is full");
			return;
		} else
		// queue contains 2 or more items
		{
			a[++back] = item;
		}

	}

	public Object dequeue() {
		if (isEmpty()) {
			System.out.println("Q is empty");
			return null;
		}
		else
		{
			Object temp=a[0];
			for(int i=0;i<back;i++)
			{
				//后移
				a[i]=a[i+1];
				
			}
			back--;
			return temp;
		}
		
		
	}

	public Object peek() {
		return a[0];
	}

	public int size() {
		return  back+1;
	}

	public boolean isEmpty() {
		if(back==-1)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		String re="";
		for(int i=0;i<back+1;i++)
			re+="a["+i+"]="+a[i]+"\n";
		return re;

	}
}