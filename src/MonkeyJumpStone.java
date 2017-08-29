
public class MonkeyJumpStone {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, -1, 0, 2, 3, 5 }, 3));// 2
		System.out.println(solution(new int[] { 3, 2, 1 }, 1));// 3
		System.out.println(solution(new int[] { 1, 2, 3, 4, -1, -1, -1 }, 3));// -1
		System.out.println(jumpleAble(new boolean[] {false, false,true}, 3));// true
		System.out.println(jumpleAble(new boolean[] {false, false,true}, 2));// false
	}

	public static int solution(int[] A, int D) {
		// write your code in Java SE 8
		boolean[] stones = new boolean[A.length];

		int re = 0;
		for (int i = 0; i < A.length; i++) {
			for (boolean b : stones)
				b = false;
			for (int j = 0; A.length < j; j++) {
				if (A[j] == -1)
					continue;
				if (A[j] > i)
					stones[i] = true;
			}
			if (jumpleAble(stones, D))
				re++;
		}
		return re;
	}

	private static boolean jumpleAble(boolean[] stones, int D) {
		int left = -1;
		int right = 1;
		while (right < stones.length) {
			if (stones[right]) {
				if (right - left > D)
					return false;
				else{
					right++;
					left = right;
				}
			}
			
			right++;
			
		}
		return true;
	}
}
