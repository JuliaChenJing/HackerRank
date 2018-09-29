package pramp.dynamic_programming;

public class NumOfPathWithPramp {

	// https://www.pramp.com/question/N5LYMbYzyOtbpovQoY7X
	public static void main(String[] args) {
		System.out.println(numOfPathsToDest(4));// 5
	}

	static int destinationTimes = 0;

	static int numOfPathsToDest(int n) {
		findPaths(0, 0, n);
		return destinationTimes;
	}

	static void findPaths(int i, int j, int n) {
		if (i == (n - 1) && j == (n - 1)) {
			destinationTimes++;
		} else {
			if (i >= (j + 1) && (j + 1) <= (n - 1)) {
				findPaths(i, j + 1, n);
			}
			if ((i + 1) >= j && (i + 1) <= (n - 1)) {
				findPaths(i + 1, j, n);
			}
		}
	}
}
