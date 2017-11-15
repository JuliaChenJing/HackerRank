package algorithm.recursion;

import java.util.Scanner;

public class CountVowel {
public static void main(String[] args)
{

	String string;

	@SuppressWarnings("resource")
	Scanner in=new Scanner(System.in);

	System.out.print("Enter any Word : ");

	string=in.next();

	System.out.println("Total Vowels in the String " + string + " is:"+vowelCount(string));
}

	public static int vowelCount(String string) {
		char c;
		int count = 0;
		if (string.length() == 0)
			return 0;
		else {
			c = string.charAt(0);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				count++;
			return count + vowelCount(string.substring(1));
		}
	}
}

/*
Enter any Word : abcewafds 
Total Vowels in the String abcewafds is:3
*/
