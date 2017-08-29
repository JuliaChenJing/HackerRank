package pramp.life_question;

import java.util.HashMap;

public class InterestingTime {

	public static void main(String[] args) {
		System.out.println(isInteresting("15:15:00", "15:15:12"));
	}

	public static int solution(String S, String T) {
		// write your code in Java SE 8

		String[] partsS = S.split(":");
		String[] partsT = T.split(":");
		// System.out.println(partsS[1]);
		
		int hh1=Integer.parseInt(partsS[0]);
		int mm1=Integer.parseInt(partsS[1]);
		int ss1=Integer.parseInt(partsS[2]);
		int hh2=Integer.parseInt(partsT[0]);
		int mm2=Integer.parseInt(partsT[1]);
		int ss2=Integer.parseInt(partsT[2]);
		
		for( ;hh1<=hh2&&mm1<=mm2&&ss1<=ss2;ss1++){
			
		}
		int re = 0;

		
		return re;
	}

	public static boolean isInteresting(String S, String T) {
		// write your code in Java SE 8
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String[] partsS = S.split(":");
		String[] partsT = T.split(":");

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

			c = partsT[i].charAt(0);
			if (!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c) + 1);

			c = partsT[i].charAt(1);
			if (!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c) + 1);
		}
		
		//System.out.println(map);
		return map.size() <= 2 ? true : false;
	}

}
