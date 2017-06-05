package algorithm.bitmanipulation;

import java.util.Scanner;

public class NumberComplement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("which number do you want to trnasform in complement?");
			int i = sc.nextInt();
			System.out.println("The complement of number " + i + " is " + numberComplement(i));
		}

	}

	private static int numberComplement(int i) {
		int ones = (Integer.highestOneBit(i) << 1) - 1;
		return i ^ ones;
	}
}
