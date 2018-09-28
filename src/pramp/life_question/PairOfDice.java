package pramp.life_question;

/** Class: Fundamental Programming Practice  <br /> 
Description:  Complete the following code by implementing the body<br /> 
*/
import java.util.Random;

class PairOfDice {
	public int dice1; // Number showing on the first dice.
	public int dice2; // Number showing on the second dice.

	public PairOfDice() {
		// Constructor. Rolls the dice, so that they initially
		// show some random values. Call the roll() method to roll the dice.
		roll();
	}

	public PairOfDice(int val1, int val2) {
		// Constructor. Creates a pair of dice that
		// are initially showing the values val1 and val2.
		dice1 = val1;
		dice2 = val2;

	}

	public void roll() {
		// Roll the dice by setting each of the dice (dice1, dice2) to be
		// a random number between 1 and 6.
		Random random = new Random();
		dice1 = random.nextInt(7);
		dice2 = random.nextInt(7);
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
			System.out.println("Fist pair come up with total " + (pair1.dice1 + pair1.dice2));
			System.out.println("Second pair come up with total " + (pair2.dice1 + pair2.dice2));
			if ((pair1.dice1 + pair1.dice2) == (pair2.dice1 + pair2.dice2))
				break;
		}
		// Display how many times needed to get the same total
		System.out.println("it took " + num + " time to reach the same value");
	}

}

/*
Fist pair come up with total 8
Second pair come up with total 4
Fist pair come up with total 6
Second pair come up with total 4
Fist pair come up with total 7
Second pair come up with total 7
it took 10 time to reach the same value
 */