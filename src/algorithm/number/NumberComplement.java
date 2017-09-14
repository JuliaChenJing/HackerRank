package algorithm.number;

import java.util.Scanner;

public class NumberComplement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n which number do you want to trnasform in complement?");
			int i = sc.nextInt();
			System.out.println("The complement of number " + i + " is " + getIntegerComplement(i));
		}

	}

	private static int getIntegerComplement(int i) {
		// int ones = (Integer.highestOneBit(i) << 1) - 1;
		// return i ^ ones;

		int a = Integer.highestOneBit(i);
		System.out.println("Integer.highestOneBit (" + i + ") =" + a);
		int b = a << 1;
		System.out.println("double: << 1 of " + a + "=" + b);
		int ones = b - 1;
		System.out.println(b + "- 1 =" + ones);
		int re = i ^ ones;
		System.out.println(i + "^" + ones + " =" + re);
		return re;
	}
}
