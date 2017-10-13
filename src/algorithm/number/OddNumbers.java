package algorithm.number;

import java.util.LinkedList;
import java.util.Queue;

public class OddNumbers {

	static int[] oddNumbers(int l, int r) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = l; i <= r; i++) {
			if (i % 2 == 1)
				queue.add(i);
		}
		int[] re = new int[queue.size()];
		for (int i = 0; i < re.length; i++) {
			re[i] = queue.poll();
		}

		return re;
	}
}
