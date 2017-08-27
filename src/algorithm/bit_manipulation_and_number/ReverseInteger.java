package algorithm.bit_manipulation_and_number;

public class ReverseInteger {
	/*
	 * Reverse digits of an integer.
	 * 
	 * Example1: x = 123, return 321 Example2: x = -123, return -321
	 * 
	 * click to show spoilers.
	 * 
	 * Note: The input is assumed to be a 32-bit signed integer. Your function
	 * should return 0 when the reversed integer overflows.
	 */
	public static int reverse(int x) {

		if (x / 10 == 0)
			return x;
		int y = 0;
		while (x / 10 != 0) {

			y = y * 10 + (x % 10);

			x = x / 10;
		}
		y = y * 10 + (x % 10);
		return y;

	}

	public static int reverse_perfect(int x) {
		int result = 0;

		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			/*
			 * Note: The input is assumed to be a 32-bit signed integer. Your
			 * function should return 0 when the reversed integer overflows.
			 */
			if ((newResult - tail) / 10 != result) {
				return 0;
			}
			result = newResult;
			x = x / 10;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(reverse(-123));
		System.out.println(reverse_perfect(1534236469));
	}
}
