package algorithm.bitmanipulation;

/*
 * Write a program to swap odd and even bits in an integer with as few instructions as
possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc)
 */
public class SwapOddEvenBits {
	/*
	 * This seemingly complex problem is actually rather straightforward. To
	 * approach this, ask yourself how you would figure out which bits in two
	 * numbers are different. Simple: with an xor. Each 1 in the xor will
	 * represent one different bit between A and B. We then simply need to count
	 * the number of bits that are 1.
	 * 
	 */

	public static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c >> 1) {
			count += c & 1;
		}
		return count;
	}

}
