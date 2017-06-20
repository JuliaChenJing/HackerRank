package algorithm.bitmanipulationAndNumber;

public class LeastCommonMultiple {

	/*
	 * 
	 * /* Example: Given two numbers m and n, write a method to return the first
	 * number r that is divisible by both (e.g., the least common multiple).
	 * 
	 * The Approach: What does it mean for r to be divisible by m and n? It
	 * means that all the primes in m must go into r, and all primes in n must
	 * be in r. What if m and n have primes in common? For example, if m is
	 * divisible by 3^5 and n is divisible by 3^7, what does this mean about r?
	 * It means r must be divisible by 3^7.
	 * 
	 * The Rule: For each prime p such that p^a \ m (e.g., m is divisible by
	 * p^a) and p^b \ n, r must be divisible by p^max(a, b)
	 * 
	 * 
	 * NOTE: An alternate solution involves recognizing that gcd(a, b) * lcm(a,
	 * b) = ab. One could then compute the gcd(a, b) using the Euclidean
	 * algorithm. Of course, unless you already know this fact, it’s unlikely
	 * that this rule would occur to you during an interview.
	 * 
	 * 
	 */
	
	public static int lcm(int a, int b) {

		return a*b/GreatestCommonDivisor.gcd(a,b);
	}
	
	public static void main(String[] args) {
		System.out.println("最小公倍数数： " + lcm(6, 72));

	}

}
