// https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
package datastructure.linkedlist;

public class CycleDetection {
	/*
	 * Detect a cycle in a linked list. Note that the head pointer may be 'null'
	 * if the list is empty.
	 * 
	 * A Node is defined as: class Node { int data; Node next; }
	 */

	/* If "slow" and "fast" collide, we must have a cycle */
	boolean hasCycle(Node head) {
		if (head == null)
			return false;

		Node slow = head; // moves 1 Node at a time
		Node fast = head; // moves 2 Nodes at a time

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true; // since "slow" and "fast" collided
			}
		}
		return false;
	}

	
	/*
	 * Given a linked list, return the node where the cycle begins.
	 *  If there is no cycle, return null.

       Try solving it using constant additional space.

       Example :

         Input : 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

       Return the node corresponding to node 3. 
	 */
	
	
	public Node detectCycle(Node a) 
	{
  
		Node fast = a;
		Node slow = a;
		boolean hasCycle = false;
		while(fast != null && fast.next != null && slow != null)
		{
    
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
     
				hasCycle = true;
				break;
			}
		}

		if(!hasCycle) return null;

		else{//hasCycle = true;
			
    
			fast = a;
   
			while(fast != slow){
      
				fast = fast.next;
      
				slow = slow.next;
   
			}
			return fast;
		}
	}
}
