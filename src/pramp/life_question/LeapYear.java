package pramp.life_question;

import java.util.Scanner;
/** Class: Fundamental Programming Practice  <br /> 
5   @author "Jing Chen" <br /> 
6   Description: Check the given year is Leap year or not using ternary operator. <br /> 
7  */ 

public class LeapYear{

		public static void main(String[] args) {
			
			
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Input a year: ");
				int year = keyboard.nextInt();
				if(year<0)
					System.out.printf("Are you sure this is a year?");
			boolean leapyear=(((year%4==0)&&(year%100!=0))||(year%400==0))?  true:false;
			
			if(leapyear==true)
				
				System.out.printf("\n The year %d is a leap year" ,year);

			else
				System.out.printf("\n The year %d is not a leap year" ,year);
			

	}


}
