package algorithm.recursion;

public class Brackets {
	/*
	 * Implement an algorithm to print all valid (e.g., properly opened and
	 closed) combinations of n-pairs of brackettheses.
	 * 
	 *  EXAMPLE: 
	 *  
	 *  input: 3 (e.g. pairs of brackettheses) 
	 * 
	 * output: 
	 * ((()))
       (()())
       (())()
       ()(())
       ()()()

	 * 
	 * We can solve this problem recursively by recursing through the string. On
	 * each iteration, we have the index for a particular character in the
	 * string. We need to select either a left or a right bracket. When can we use
	 * left, and when can we use a right bracket?
	 * 
	 * » Left: As long as we haven’t used up all the left brackettheses, we can
	 * always insert a left bracket.
	 * 
	 * » Right: We can insert a right bracket as long as it won’t lead to a syntax
	 * error. When will we get a syntax error? We will get a syntax error if
	 * there are more right brackettheses than left.
	 * 
	 * So, we simply keep track of the number of left and right brackettheses
	 * allowed. If there are left brackets remaining, we’ll insert a left bracket
	 * and recurse. If there are more right brackets remaining than left (eg, if
	 * there are more left brackets used), then we’ll insert a right bracket and
	 * recurse.
	 */
	
	public static void main(String []args)
	{
		printPar(3);
	}


	
	public static void printPar(int numOfBrackets) {
		
		char[] str = new char[numOfBrackets * 2];
		
		printParHelper(numOfBrackets, numOfBrackets, str, 0);
	}
	
	public static void printParHelper(int leftRemains, int rightRemains, char[] str, int strLocation) {
		
		if (leftRemains < 0 || rightRemains < leftRemains)
			return; // invalid state
		
		if (leftRemains == 0 && rightRemains == 0) {
			System.out.println(str); // found one, so print it
			
		} 
		
		else {
			
			if (leftRemains > 0) { // try a left bracket, if there are some available
				str[strLocation] = '(';
				printParHelper(leftRemains - 1, rightRemains, str, strLocation + 1);
			}
			
			//there is no else, because we want to print all the possibilities
			if (rightRemains > leftRemains) { // try a right bracket, if there a matching left
				str[strLocation] = ')';
				
				printParHelper(leftRemains, rightRemains - 1, str, strLocation + 1);
			}
		}
	}
	
	



	
}
