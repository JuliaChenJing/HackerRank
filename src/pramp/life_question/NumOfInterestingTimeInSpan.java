package pramp.life_question;

import java.util.HashMap;

public class NumOfInterestingTimeInSpan {

	// if the time is only formed by 2 number, it is considered an interesting
	// time
	public static void main(String[] args) {
		// return the number of interesting time in between this time span
		System.out.println(numOfInterestingTime("15:15:00", "15:15:16"));
	}

	public static int numOfInterestingTime(String S, String T) {
		String[] splitS = S.split(":");
		String[] splitT = T.split(":");

		int hh1 = Integer.parseInt(splitS[0]);
		int mm1 = Integer.parseInt(splitS[1]);
		int ss1 = Integer.parseInt(splitS[2]);
		int hh2 = Integer.parseInt(splitT[0]);
		int mm2 = Integer.parseInt(splitT[1]);
		int ss2 = Integer.parseInt(splitT[2]);
		int re = 0;

		for (; hh1 <= hh2 && mm1 <= mm2 && ss1 <= ss2; ss1++) {
			if (isInteresting(hh1, mm1, ss1))
				re++;
			if (ss1 == 60) {
				mm1++;
				ss1 = 0;
			}
			if (mm1 == 60) {
				hh1++;
				mm1 = 0;
			}
			if (hh1 == 24)
				break;
		}
		return re;
	}

	private static boolean isInteresting(int h, int m, int s) {
		int[] nums = { h, m, s };
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int num : nums) {
			System.out.print(num + " ");
			char c = (char) (num % 10 + 48);
			if (!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c) + 1);

			c = (char) (num / 10 + 48);
			if (!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c) + 1);
		}
		System.out.println(map);
		return map.size() <= 2 ? true : false;
	}

	public static boolean isInteresting(String S) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String[] splitS = S.split(":");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				char c = splitS[i].charAt(j);
				if (!map.containsKey(c)) {
					map.put(c, 1);
				} else {
					map.put(c, map.get(c) + 1);
				}
			}
		}
		return map.size() <= 2 ? true : false;
	}
}
