package algorithm.bitmanipulationAndNumber;

public class GCD {
	/*
	 * 算最大公约数 Given 2 non negative integers m and n, find gcd(m, n)
	 * 
	 * GCD of 2 integers m and n is defined as the greatest integer g such that
	 * g is a divisor of both m and n. Both m and n fit in a 32 bit signed
	 * integer.
	 * 
	 * Example
	 * 
	 * m : 6 n : 9
	 * 
	 * GCD(m, n) : 3
	 */
	public static int gcd(int a, int b) {

		int temp, r;

		// make a>=b
		if (a < b) {
			temp = a;
			a = b;
			b = temp;
		}

		r = a % b;
		while (r != 0) {

			a = b;
			b = r;
			r = a % b;
		}
		return b;
	}

	public static  int gcdWithRecurtion(int a, int b) {

		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static void main(String[] args) {
		System.out.println("最大公约数： " + gcd(6, 72));
		System.out.println("递归 最大公约数 ： " + gcdWithRecurtion(6, 72));
	}
}
