package pramp.life_question;

//https://leetcode.com/problems/trapping-rain-water/description/
public class RainWater {

	/*
	 * Given n non-negative integers representing an elevation map where the
	 * width of each bar is 1, compute how much water it is able to trap after
	 * raining.
	 * 
	 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 */
	public int trap(int[] A) {
		int a = 0;
		int b = A.length - 1;

		int re = 0;

		int leftmax = 0;
		int rightmax = 0;

		while (a <= b) {

			leftmax = Math.max(leftmax, A[a]);
			rightmax = Math.max(rightmax, A[b]);

			if (leftmax < rightmax) {
				re += (leftmax - A[a]);
				a++;
			} else {
				re += (rightmax - A[b]);
				b--;
			}
		}
		return re;
	}
}
