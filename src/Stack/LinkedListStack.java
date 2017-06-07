package Stack;


public class  LinkedListStack implements Stack{
	Node top;
	
	public static void main(String[] args)
	{
		Node t = new Node(1);
		
		
		LinkedListStack s=new LinkedListStack();
		s.top=t;
		s.push(2);
		s.push(3);
		System.out.println(s.toString());
		s.pop();
	
		System.out.println(s.toString());
		
		s.push(4);
		s.push(5);
		
		System.out.println(s.toString());
	}
	
	void push(int item){
		Node t=new Node(item);
		t.next=top;
		top=t;
	}
	
	public Node pop()
	{
		if(top!=null)
		{
			Node re=top;
			top=top.next;
			return re;
		}
		return null;
	}
	
	
	
	@Override
	public  String toString()
	{
		String re="top";
		Node n=top;
		while(n!=null)
		{
			re+="-->"+n.data;
			n=n.next;	
		}
		return re;
	}
	
	

	@Override
	public void push(Object ob) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object peek() {
		if(top!=null)
		{
			Node re=top;
			return re;
		}
		return null;
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}


class Node 
{
	Node next = null;
	int data;

	public Node(int d) 
	{
		data = d;
	}

	void appendToTail(int d) 
	{
		Node end = new Node(d);
		Node n = this;
		while (n.next != null)
			n = n.next;
		n.next = end;
	}

	Node deleteNode(Node head, int d)
	{
		Node n = head;
		if (n.data == d) {
			return head.next;
		}

		while (n.next != null)
		{
			if (n.next.data == d) 
			{
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		
		return head;
	}
}
