package algorithm.bitmanipulationAndNumber;

public class Coins {

	public static void main(String args[]) {
		
		String money = "1.25";
		System.out.println("the num of coins needed for money " + calculateChange(money));//3

		System.out.println("write code to calculate  the number of ways of representing n cents "+makeChange(5, 25));//2

	}

	// count the num of coins needed for money
	
	static int calculateChange(String money) {
		
		int penny = 1, nickel = 5, dime = 10, quarter = 25, fiftyCent = 50;

		double amount = (Double.parseDouble(money)) * 100;

		int count = 0;

		count += amount / fiftyCent;
		amount = amount % fiftyCent;

		count += amount / quarter;
		amount = amount % quarter;

		count += amount / dime;
		amount = amount % dime;

		count += amount / nickel;
		amount = amount % nickel;

		count += amount / penny;
		amount = amount % penny;

		return count;
	}

	/*
	 * 8.7 p182 Given an infinite number of quarters (25 cents), dimes (10
	 * cents), nickels (5 cents) and pennies (1 cent), write code to calculate
	 * the number of ways of representing n cents.
	 * 
	 * This is a recursive problem, so let’s figure out how to do makeChange(n)
	 * using prior solutions (i.e., sub-problems).
	 * 
	 * Let’s say n = 100, so we want to compute the number of ways of making
	 * change of 100 cents. What’s the relationship to its sub-problems? We know
	 * that makeChange(100): = makeChange(100 using 0 quarters) + makeChange(100
	 * using 1 quarter) + makeChange(100 using 2 quarter) + makeChange(100 using
	 * 3 quarter) + makeChange(100 using 4 quarter)
	 * 
	 * Can we reduce this further? Yes! = makeChange(100 using 0 quarters) +
	 * makeChange(75 using 0 quarter) + makeChange(50 using 0 quarters) +
	 * makeChange(25 using 0 quarters) + 1 Now what?
	 * 
	 * We’ve used up all our quarters, so now we can start applying our next
	 * biggest denomination: dimes. This leads to a recursive algorithm that
	 * looks like this:
	 */

	public static int makeChange(int n, int denom) {
		int next_denom = 0;
		switch (denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		int ways = 0;
		for (int i = 0; i * denom <= n; i++) {
			ways += makeChange(n - i * denom, next_denom);
		}
		return ways;
	}
}
