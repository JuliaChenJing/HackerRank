package pramp.life_question;

/**
 * Class: Fundamental Programming Practice <br />
 * Description: Write a program that grades multiple-choice tests..<br />
 */

public class MultipleChoiceTestScores {

	public static void main(String[] args) {
		char[][] answerOfStudents = 
			{
				{ 'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D' },
				{ 'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D' },
				{ 'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D' },
				{ 'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'B', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D' } 
		   };
		
		char[] rightAnswer = { 'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D' };
		int[] scoreOfStudents = new int[answerOfStudents.length];
		
		for (int i = 0; i < scoreOfStudents.length; i++)
			scoreOfStudents[i] = 0;
		
		for (int i = 0; i < answerOfStudents.length; i++)
			for (int j = 0; j < rightAnswer.length; j++) {
				if (answerOfStudents[i][j] == rightAnswer[j])
					scoreOfStudents[i]++;
			}
		
		for (int i = 0; i < scoreOfStudents.length; i++)
			System.out.println("Student" + i + "'s correct count is " + scoreOfStudents[i]);
	}
}

/*
 * Student0's correct count is 7
Student1's correct count is 6
Student2's correct count is 5
Student3's correct count is 4
Student4's correct count is 8
Student5's correct count is 8
Student6's correct count is 7
Student7's correct count is 7
 * 
 */