package pramp.life_question;

/** Class: Fundamental Programming Practice  <br /> 
@author "Jing Chen" <br /> 
Description:  Complete the following code by implementing the body<br /> 
*/
import java.util.Random;

class PairOfDice {
	public int die1; // Number showing on the first die.
	public int die2; // Number showing on the second die.

	public PairOfDice() {
		// Constructor. Rolls the dice, so that they initially
		// show some random values. Call the roll() method to roll the dice.
		roll();
	}

	public PairOfDice(int val1, int val2) {
		// Constructor. Creates a pair of dice that
		// are initially showing the values val1 and val2.
		die1 = val1;
		die2 = val2;

	}

	public void roll() {
		// Roll the dice by setting each of the dice (die1, die2) to be
		// a random number between 1 and 6.
		Random random = new Random();
		die1 = random.nextInt(7);
		die2 = random.nextInt(7);
	}

	public static void main(String[] args)

	{
		int num = 0;
		// Create two object for the PairOfDice
		PairOfDice pair1 = new PairOfDice();
		PairOfDice pair2 = new PairOfDice();

		// Roll the two pairs of pair for both objects until the totals are
		// same.
		while (true) {
			num++;
			pair1.roll();
			pair2.roll();
			System.out.println("Fist pair come up with total " + (pair1.die1 + pair1.die2));
			System.out.println("Second pair come up with total " + (pair2.die1 + pair2.die2));
			if ((pair1.die1 + pair1.die2) == (pair2.die1 + pair2.die2))
				break;
		}
		// Display how many times needed to get the same total
		System.out.println("it took " + num + " time to reach the same value");
	}

}

/*
 * Fist pair come up with total 6
Second pair come up with total 6
it took 1 time to reach the same value
 */