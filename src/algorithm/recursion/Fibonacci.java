package algorithm.recursion;

//Write a method to generate the nth Fibonacci number.
public class Fibonacci {

	// Recursive Solution:
	public int fibo(int n) {
		if (n == 0) {
			return 0; // f(0) = 0
		} else if (n == 1) {
			return 1; // f(1) = 1
		} else if (n > 1) {

			return fibo(n - 1) + fibo(n - 2);

		} else {
			return -1; // Error condition

		}
	}

	// Iterative Solution:
	public int fibonacci(int n) {
		if (n < 0)
			return -1; // Error condition.
		if (n == 0)
			return 0;
		int a = 1, b = 1;
		for (int i = 3; i <= n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
}
