package pramp.life_question;

import java.util.Scanner;

/**
 * Class: Fundamental Programming Practice <br />
 * 
 * @author "Jing Chen" <br />
 *         Description: Write a program that prompts the user to input as a
 *         digit. The program should then output a Checkerboard Pattern of
 *         Asterisks of that size using the “*”. For example, if input is 8,
 *         then the output is as follows.<br />
 */
public class CheckerBoard {

	public static void main(String[] args) {

		int num = 8;

		Scanner keyboard = new Scanner(System.in);

		while (true) {
			System.out.print("Input an integer: ");
			num = keyboard.nextInt();
			if (num < 10000 || num > 0)

				break;

			else
				System.out.printf("Are you sure this is an integer?");

		}

		for (int i = 0; i < num; i++) {
			if (i % 2 == 1)
				System.out.print(" ");
			for (int j = 0; j < num; j++) {

				System.out.print(" *");
			}
			System.out.println();
		}

	}

}

/*
 * Input an integer: 6 * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * *
 */