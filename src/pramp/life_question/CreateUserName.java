package pramp.life_question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Class: Fundamental Programming Practice  
 *         Description: Implement necessary string methods and userName number to
 *         produce a userName based on the user's first and last names. Assumes
 *         the last name is at least five characters long. userName = First
 *         character from first name and first five characters from last name +
 *         three digit userName number.
 */
public class CreateUserName {
	public static void main(String[] args) throws IOException {

		String firstName = null, lastName = null;
		StringBuilder userName = new StringBuilder();
		Random random = new Random();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Type your first name: ");
		firstName = in.readLine();
		System.out.println("Your first Name " + firstName);

		System.out.print("Type your last name: ");
		lastName = in.readLine();
		System.out.println("Your first Name " + lastName);

		in.close();
		userName.append(firstName.charAt(0));
		userName.append(lastName.substring(0, 4));
		userName.append(random.nextInt(10));
		userName.append(random.nextInt(10));
		userName.append(random.nextInt(10));
		System.out.println("Your userName is:" + userName);
	}
}

/*
Type your first name: julia
Your first Name julia
Type your last name: chen
Your first Name chen
Your userName is:jchen639
 */
