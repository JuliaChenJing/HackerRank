package pramp.dynamic_programming;

//https://blog.pramp.com/how-to-solve-any-dynamic-programming-problem-603b6fbbd771
public class Fib {

	// method 1: recursion , bad
	public int fib_1(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fib_1(n - 1) + fib_1(n - 2);
	}

	// method 2 :use cache and recursion
	public int fib_2(int n) {
		if (n < 2)
			return n;

		// Create cache and initialize to -1
		int[] cache = new int[n + 1];
		for (int i = 0; i < cache.length; i++)
			cache[i] = -1;

		// Fill initial values in cache
		cache[0] = 0;
		cache[1] = 1;
		return fib(n, cache);
	}

	private int fib(int n, int[] cache) {
		// If value is set in cache, return it
		if (cache[n] >= 0)
			return cache[n];
		// Otherwise compute result and add it to the cache before returning
		cache[n] = fib(n - 1, cache) + fib(n - 2, cache);
		return cache[n];
	}

	/*
	 * In computing, memoization or memoisation is an optimization technique
	 * used primarily to speed up computer programs by storing the results of
	 * expensive function calls and returning the cached result when the same
	 * inputs occur again.
	 */

	// method 3:best way memoization
	public int fib_3(int n) {
		if (n == 0)
			return 0;
		// Initialize cache
		int[] cache = new int[n + 1];
		cache[0] = 1;
		cache[1] = 1;
		// Fill cache iteratively
		for (int i = 2; i <= n; i++) {
			cache[i] = cache[i - 1] + cache[i - 2];
		}
		return cache[n];
	}
}
