package datastructure.queue;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueSale_II  {
	public static void main(String args[]) {
		Queue<Sale_II> pq = new PriorityQueue<>();
		pq.add(new Sale_II(10,"Pen",2.5));
		pq.add(new Sale_II(5,"FlashDrive",6));
		pq.add(new Sale_II(8,"Mouse",25));
		pq.add(new Sale_II(6,"Head Phone",35));
		Iterator it = pq.iterator();
		System.out.println("List of Elements :");
		while(it.hasNext()){
			Sale_II ob = pq.poll();
			System.out.println(ob);
	
		}

	}
}