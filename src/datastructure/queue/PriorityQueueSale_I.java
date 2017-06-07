package datastructure.queue;


import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

//Priority Queue implementation using Comparator Interface
public class PriorityQueueSale_I
{
	public static void main(String args[]) {
		Queue<Sale_I> pq = new PriorityQueue<>(idComparator);
		pq.add(new Sale_I(10, "Pen", 2.5));
		pq.add(new Sale_I(5, "FlashDrive", 6));
		pq.add(new Sale_I(8, "Mouse", 25));
		pq.add(new Sale_I(6, "Head Phone", 35));
		Iterator it = pq.iterator();
		System.out.println("List of Elements :" + pq);
		while (it.hasNext()) {
			Sale_I ob = pq.poll();
			// System.out.println(ob);
		}
	

	}

	public static Comparator<Sale_I> idComparator = new Comparator<Sale_I>() {

		@Override
		public int compare(Sale_I s1, Sale_I s2) {
			return (int) (s1.sid - s2.sid);
		}
	};
}