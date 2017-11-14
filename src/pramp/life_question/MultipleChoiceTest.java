package pramp.life_question;

/**
 * Class: Fundamental Programming Practice <br />
 * 
 * @author "Jing Chen" <br />
 *         Description: Write a program that grades multiple-choice
 *         tests..<br />
 */

public class MultipleChoiceTest {

	public static void main(String[] args) {
		char[][] answer = {

				{ 'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D' },
				{ 'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D' },
				{ 'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D' },
				{ 'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'B', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D' } };
		char[] rightAnswer = { 'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D' };
		int[] score = new int[answer.length];
		for (int i = 0; i < score.length; i++)
			score[i] = 0;
		for (int i = 0; i < answer.length; i++)
			for (int j = 0; j < rightAnswer.length; j++) {
				if (answer[i][j] == rightAnswer[j])
					score[i]++;

			}
		for (int i = 0; i < score.length; i++)
			System.out.println("Student" + i + "'s correct count is " + score[i]);

	}

}

/*
 * Student0's correct count is 7 Student1's correct count is 6 Student2's
 * correct count is 5 Student3's correct count is 4 Student4's correct count is
 * 8 Student5's correct count is 8 Student6's correct count is 7 Student7's
 * correct count is 7
 * 
 */