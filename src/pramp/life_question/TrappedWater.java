package pramp.life_question;

//https://leetcode.com/problems/trapping-rain-water/description/
public class TrappedWater {

	/*
	 * Given n non-negative integers representing an elevation map where the - *
	 * width of each bar is 1, compute how much water it is able to trap after -
	 * * raining.
	 * 
	 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 */

	public static void main(String[] args) {
		int[] A = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.print("how much water it is able to trap after raining: " + getTrappedWater(A));
	}

	public static int getTrappedWater(int[] A) {
		int left = 0;
		int right = A.length - 1;

		int numOfTrappedWater = 0;

		int leftMax = 0;
		int rightMax = 0;

		while (left <= right) {

			leftMax = Math.max(leftMax, A[left]);
			rightMax = Math.max(rightMax, A[right]);

			if (leftMax < rightMax) {
				numOfTrappedWater += (leftMax - A[left]);
				left++;
			} else {
				numOfTrappedWater += (rightMax - A[right]);
				right--;
			}
		}
		return numOfTrappedWater;
	}
}
