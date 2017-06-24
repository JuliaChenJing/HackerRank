package algorithm.recursion;

public class PowerSum {


	/*
	 * Find the number of ways that a given integer, 
	 *  can be expressed as the sum of the  power of unique, natural numbers.

Input Format

The first line contains an integer . 
The second line contains an integer .

Constraints

Output Format

Output a single integer, the answer to the problem explained above.

Sample Input 0

10
2
Sample Output 0

1
Explanation 0

If  and , we need to find the number of ways that  can be represented as the sum of squares of unique numbers.


This is the only way in which  can be expressed as the sum of unique squares.
	 */
	public static void main(String []args) { 
	  
		System.out.println(findPowerSum(10, 2, 1)); 
	    System.out.println(findPowerSum(100, 2, 1)); 
	    System.out.println(findPowerSum(100, 3, 1)); 
	  
	}

	static int findPowerSum(int total, int power, int num)
	{
		//Math.pow(7, 2);    // 49
	    int value = (int) (total - Math.pow(num, power));
	    
	    if(value < 0)
	    	return 0;
	    
	    else if(value == 0) 
	    	return 1;
	    
	    else return findPowerSum(value , power, num + 1) +
	    			findPowerSum(total, power, num+1);
	}
}
