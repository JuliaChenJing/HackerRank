package pramp.life_question;

public class TimeSlotAvailable {

	static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {

		//int[] result = new int[2];
		int start = 0;

		int i = 0;
		int j = 0;
		int left;
		int right;
		boolean found = false;

		while (i < slotsA.length && j < slotsB.length) {

			left = Math.max(slotsA[i][0], slotsB[j][0]);
			right = Math.min(slotsA[i][1], slotsB[j][1]);
			if (right - left >= dur) {
				start = left;
				found = true;
				break;
			}

			// i=0
			// j=0
			if (j + 1 < slotsB.length && slotsA[i][1] > slotsB[j + 1][0])
				i--;
			else if (i + 1 < slotsA.length && slotsB[j][1] > slotsA[i + 1][0])
				j--;
			i++;
			j++;

		}

		// if start is found
		if (found) {

			return new int[] { start, start + dur };
		}
		// if not found
		else {
			return new int[] { -1, -1 };

		}

	}

	public static void main(String[] args) {
		int[][] slotsA = { { 10, 70 }, { 80, 120 }, { 140, 210 } };
		int[][] slotsB = { { 0, 15 }, { 62, 70 } };

		int[] result = meetingPlanner(slotsA, slotsB, 8);
		System.out.println(result[0]);
		System.out.println(result[1]);

	}

}
