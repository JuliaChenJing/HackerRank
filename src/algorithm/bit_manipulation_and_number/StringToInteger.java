package algorithm.bit_manipulation_and_number;

public class StringToInteger {
	/*
	 * Implement atoi to convert a string to an integer.
	 * 
	 * Hint: Carefully consider all possible input cases. If you want a
	 * challenge, please do not see below and ask yourself what are the possible
	 * input cases.
	 * 
	 * Notes: It is intended for this problem to be specified vaguely (ie, no
	 * given input specs). You are responsible to gather all the input
	 * requirements up front.
	 */
	public static int myAtoi(String str) {
		if (str == null || str.length() == 0)
			return 0;
		int isPositive = 1;
		int re = 0;
		int i = 0;
		if (str.charAt(0) == '-') {
			isPositive = -1;
			i++;
		}

		else if (str.charAt(0) == '+')
			i++;

		for (; i < str.length(); i++) {

			if (str.charAt(i) > '9' || str.charAt(i) < '0')
				return 0;
			re = 10 * re + numFromChar(str.charAt(i));

		}
		return re * isPositive;

	}

	private static int numFromChar(char c) {

		return c - '0';
	}

	public static int myAtoi_perfect(String str) {
		if (str == null || str.length() == 0)
			return 0;//
		str = str.trim();
		char firstChar = str.charAt(0);
		int sign = 1, start = 0, len = str.length();
		long sum = 0;
		if (firstChar == '+') {
			sign = 1;
			start++;
		} else if (firstChar == '-') {
			sign = -1;
			start++;
		}
		for (int i = start; i < len; i++) {
			if (!Character.isDigit(str.charAt(i)))
				return (int) sum * sign;
			sum = sum * 10 + str.charAt(i) - '0';
			if (sign == 1 && sum > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}

		return (int) sum * sign;
	}

	public static void main(String[] args) {
		System.out.println(numFromChar('1'));
		System.out.println(myAtoi("-122"));
		System.out.println(myAtoi("12*2"));
	}
}
