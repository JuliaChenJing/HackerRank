package datstructure.linkedlist;

import java.util.HashSet;

/*
 * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.

DEFINITION
Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an
earlier node, so as to make a loop in the linked list.
EXAMPLE
Input: A -> B -> C -> D -> E -> C [the same C as earlier]
Output: C
 */
public class FindBeginnerOfLoop {
	public static Node findBeginnerOfLoop(Node head) {

		HashSet<Node> h = new HashSet<Node>();
		Node n = head;
		while (n != null) {

			if (h.contains(n))
				return n;
			else
				h.add(n);
			n = n.next;
		}

		return null;

	}

	// 书上的答案，一个追另一个什么的
	/*
	 * If we move two pointers, one with speed 1 and another with speed 2, they
	 * will end up meeting if the linked list has a loop. Why? Think about two
	 * cars driving on a track—the faster car will always pass the slower one!
	 * The tricky part here is finding the start of the loop. Imagine, as an
	 * analogy, two people racing around a track, one running twice as fast as
	 * the other. If they start off at the same place, when will they next meet?
	 * They will next meet at the start of the next lap. Now, let’s suppose Fast
	 * Runner had a head start of k meters on an n step lap. When will they next
	 * meet? They will meet k meters before the start of the next lap. (Why?
	 * Fast Runner would have made k + 2(n - k) steps, including its head start,
	 * and Slow Runner would have made n - k steps. Both will be k steps before
	 * the start of the loop.) Now, going back to the problem, when Fast Runner
	 * (n2) and Slow Runner (n1) are moving around our circular linked list, n2
	 * will have a head start on the loop when n1 enters. Specially, it will
	 * have a head start of k, where k is the number of nodes before the loop.
	 * Since n2 has a head start of k nodes, n1 and n2 will meet k nodes before
	 * the start of the loop. So, we now know the following: 1. Head is k nodes
	 * from LoopStart (by definition). 2. MeetingPoint for n1 and n2 is k nodes
	 * from LoopStart (as shown above). Thus, if we move n1 back to Head and
	 * keep n2 at MeetingPoint, and move them both at the same pace, they will
	 * meet at LoopStart.
	 */
	static Node FindBeginning(Node head) {
		Node n1 = head;
		Node n2 = head;

		// Find meeting point
		while (n2.next != null) {// n2跑的比较快，测试n2
			n1 = n1.next;
			n2 = n2.next.next;// n2 跳两步，n1跳一步
			if (n1 == n2) {
				break;// 如果n1 n2相遇就跳出循环
			}
		}

		// Error check ‐ there is no meeting point, and therefore no loop
		if (n2.next == null) {// n2跑的比较快，测试n2
			return null;
		}

		/*
		 * Move n1 to Head. Keep n2 at Meeting Point. Each are k steps /* from
		 * the Loop Start. If they move at the same pace, they must meet at Loop
		 * Start.
		 */
		n1 = head;// 把n1重新调回head
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		// Now n2 points to the start of the loop.
		return n2;
	}

	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = c;
		Node n = a;
		System.out.println("THE LINKED LIST: ");
		int i = 0;
		while (n != null && i < 10) {
			System.out.print(n.data + "--->");
			n = n.next;
			i++;
		}

		Node re = findBeginnerOfLoop(a);
		// Node re = FindBeginning(a);//也对，就是不好理解
		System.out.println("\nthe beginner of the loop is :" + re.data);
	}
}
