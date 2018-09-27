package pramp.life_question;

public class BuildCastle {

	// build castle in the high and low place
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5 }));
		System.out.println(solution(new int[] { -3, -3 }));
	}

	public static int solution(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		if (A.length == 1)
			return 1;
		boolean isUphill = A[1] - A[0] >= 0 ? true : false;
		int re = 1;
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == 0)
				continue;
			if ((A[i] - A[i - 1] > 0) == isUphill)
				continue;
			else {
				re++;
				isUphill = !isUphill;
			}
		}
		return A[A.length - 1] == A[A.length - 2] ? re : re + 1;
	}
}
