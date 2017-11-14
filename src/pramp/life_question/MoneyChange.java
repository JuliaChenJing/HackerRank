package pramp.life_question;

import java.util.Scanner;

/** Class: Fundamental Programming Practice  <br />
  @author "Jing Chen" <br />
  Description:  Develop a program to get the following output(how many coins). <br />
 */
public class MoneyChange {

		public static void main(String[] args) {
			
			double dollar=0, quater=0,dime=0,nickle=0,pennie=0;
			Scanner keyboard = new Scanner(System.in);

				System.out.print("How much money: ");
			double entry = keyboard.nextFloat();
			// verify if  the input is the amount of money
			
			if(entry<0)
				
				System.out.println("\n Not Accepted. TRY AGAIN.");

			else
			{
				dollar=Math.floor ((entry)/1.0);
				quater=Math.floor((entry-dollar)/0.25);
				dime=Math.floor((entry-quater*0.25-dollar)/0.1);
				nickle=Math.floor((entry-dime*0.1-quater*0.25-dollar)/0.05);
				pennie=Math.floor((entry-nickle*0.05-dime*0.1-quater*0.25-dollar)/0.01);
				System.out.printf("\nYour amount %.2f$ consists of \n",entry);
				
				System.out.println((int )dollar+" dollars");
				System.out.println((int )quater+" quaters");
				System.out.println((int )dime+" dimes");
				System.out.println((int )nickle+" nickles");
				System.out.println((int )pennie+" pennies");
		
			}
			
	}

}

/*
output:

How much money: 43.23

Your amount 43.23$ consists of 
43 dollars
0 quaters
2 dimes
0 nickles
2 pennies */
