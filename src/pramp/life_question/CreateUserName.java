package pramp.life_question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Class: Fundamental Programming Practice <br />
 * 
 * @author "Jing Chen" <br />
 *         Description: Implement necessary string methods and random number to
 *         produce a username based on the user's first and last names. Assumes
 *         the last name is at least five characters long. Username = First
 *         character from first name and first five characters from last name +
 *         three digit random number.<br />
 */
public class CreateUserName {
	public static void main(String[] args) throws IOException {

		String firstName = null, lastName = null;
		StringBuilder random = new StringBuilder();
		Random r = new Random();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Type your first name: ");
		firstName = in.readLine();
		System.out.println("Your first Name " + firstName);

		System.out.print("Type your last name: ");
		lastName = in.readLine();
		System.out.println("Your first Name " + lastName);

		in.close();
		random.append(firstName.charAt(0));
		random.append(lastName.substring(0, 4));
		random.append(r.nextInt(10));
		random.append(r.nextInt(10));
		random.append(r.nextInt(10));
		System.out.println("Your username is:" + random);
	}
}

/*
 * Type your first name: Julia Your first Name Julia Type your last name: Chen
 * Your first Name Chen Your username is:JChen925
 */
