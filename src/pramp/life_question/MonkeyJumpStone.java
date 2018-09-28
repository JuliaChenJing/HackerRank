package pramp.life_question;

public class MonkeyJumpStone {

	public static void main(String[] args) {
		System.out.println(jumpableWithArray(new int[] { 1, -1, 0, 2, 3, 5 }, 3));// 2
		System.out.println(jumpableWithArray(new int[] { 3, 2, 1 }, 1));// 3
		System.out.println(jumpableWithArray(new int[] { 1, 2, 3, 4, -1, -1, -1 }, 3));// -1
		System.out.println(jumpableWithBoolean(new boolean[] { false, false, true }, 2));// false
		System.out.println(jumpableWithBoolean(new boolean[] { false, false, false }, 2));// false
		System.out.println();
		System.out.println(jumpableWithBoolean(new boolean[] { true, true, true }, 1));// true
		System.out.println(jumpableWithBoolean(new boolean[] { false, false, true }, 3));// true
		System.out.println(jumpableWithBoolean(new boolean[] { false, false, true, false, false, false }, 3));// false
		System.out.println(jumpableWithBoolean(new boolean[] { false, false }, 3));// true
		System.out.println(jumpableWithBoolean(new boolean[] { true, false, true, true, false, false }, 3));// true
	}

	public static int jumpableWithArray(int[] A, int D) {
		boolean[] stones = new boolean[A.length];
		for (int i = 0; i < A.length + 1; i++) {
			for (int j = 0; j < A.length; j++) {
				stones[j] = false;
				if (A[j] == -1)
					continue;
				else if (A[j] <= i)
					stones[j] = true;
			}
			if (jumpableWithBoolean(stones, D)) {

				return i;
			}
		}
		return -1;
	}

	private static boolean jumpableWithBoolean(boolean[] stones, int D) {
		int left = -1;
		int right = 0;
		while (right < stones.length) {
			if (stones[right]) {
				if (right - left > D)
					return false;
				else {
					right++;
					left = right;
				}
			}
			right++;
		}
		// System.out.println(left);
		// System.out.println(right);
		if (!stones[right - 2]) {
			if (left == -1)
				return stones.length < D;
			return stones.length - left + 1 < D;
		}
		return true;
	}
}