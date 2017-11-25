package datastructure.string;

import java.util.Scanner;

/* If a String is equivalent to itself when reversed, it's a palindrome */
public class PalindromeIgnoreCase {
	public static void main(String[] args) {
		/* Read input */
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {
			String str = scan.nextLine();
			str = str.replaceAll(" ", "");
			StringBuilder a = new StringBuilder();

			for (int i = 0; i < str.length(); i++) {
				if (((str.charAt(i) <= 122) && (str.charAt(i) >= 97))
						|| ((str.charAt(i) <= 90) && (str.charAt(i) >= 65)))
					a.append(str.charAt(i));
			}

			str = a.toString();

			String reversed = new StringBuilder(str).reverse().toString();
			// System.out.println(reversed);
			System.out.println(str.equalsIgnoreCase(reversed) ? "Yes" : "No");
		}
	}
}
