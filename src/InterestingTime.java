
import java.util.HashMap;

public class InterestingTime {

	//time only formed by 2 number
	public static void main(String[] args) {
		System.out.println(solution("15:15:00", "15:15:12"));
	}

	public static int solution(String S, String T) {
		// write your code in Java SE 8

		String[] partsS = S.split(":");
		String[] partsT = T.split(":");
		// System.out.println(partsS[1]);

		int hh1 = Integer.parseInt(partsS[0]);
		int mm1 = Integer.parseInt(partsS[1]);
		int ss1 = Integer.parseInt(partsS[2]);
		int hh2 = Integer.parseInt(partsT[0]);
		int mm2 = Integer.parseInt(partsT[1]);
		int ss2 = Integer.parseInt(partsT[2]);
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

	private static boolean isInteresting(int hh1, int mm1, int ss1) {
		int[] nums = { hh1, mm1, ss1 };

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int num : nums) {
			// System.out.print(num+" ");

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
		// System.out.println(map);
		return map.size() <= 2 ? true : false;
	}

	public static boolean isInteresting(String S) {
		// write your code in Java SE 8
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String[] partsS = S.split(":");

		int re = 0;
		for (int i = 0; i < 3; i++) {
			char c = partsS[i].charAt(0);
			if (!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c) + 1);

			c = partsS[i].charAt(1);
			if (!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c) + 1);

		}

		// System.out.println(map);
		return map.size() <= 2 ? true : false;
	}

}
