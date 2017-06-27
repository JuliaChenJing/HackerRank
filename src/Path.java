public class Path {
	
	//http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
	
	//http://www.programcreek.com/2014/05/leetcode-unique-paths-java/
	
	//https://www.pramp.com/question/N5LYMbYzyOtbpovQoY7X
	
	/*8.2 p176
	 * Imagine a robot sitting on the upper left hand corner of an NxN grid. The
	 * robot can only move in two directions: right and down. How many possible
	 * paths are there for the robot?
	 * 
	 * FOLLOW UP Imagine certain squares are limited, such that the robot
	 * can not step on them. Design an algorithm to get all possible paths for
	 * the robot.
	 */

	// Returns count of possible paths to reach cell at row number m and column
	// number n from the topmost leftmost cell (cell at 1, 1)
	
	
	public static void main(String [] args)
	{
		System.out.println(numberOfPathsWithRecursion(4,4));
		System.out.println(numberOfPathsWithRestriction(4,4));
		System.out.println(uniquePathsWithDFS(4,4));
		System.out.println(uniquePathsWithDFSWithRestriction(4,4));
		System.out.println(uniquePathsWithDynamicProgramming(4,4));
	
		System.out.println(numberOfPaths_I(4,4));
	}
	
	static int  numberOfPathsWithRecursion(int m, int n)
	{
	   // If either given row number is first or given column number is first
	   if (m == 1 || n == 1)
	        return 1;
	 
	   // If diagonal movements are allowed then the last addition
	   // is required.
	   return  numberOfPathsWithRecursion(m-1, n) + numberOfPathsWithRecursion(m, n-1);
	           // + numberOfPaths(m-1,n-1);
	}
	
	static int  numberOfPathsWithRestriction(int m, int n)
	{
	   // If either given row number is first or given column number is first
	   if (m == 1 || n == 1)
	        return 1;
	   if(m<n)
		   return 0;
	 
	   // If diagonal movements are allowed then the last addition
	   // is required.
	   return  numberOfPathsWithRestriction(m-1, n) + numberOfPathsWithRestriction(m, n-1);
	           // + numberOfPaths(m-1,n-1);
	}
	
	//Returns count of possible paths to reach cell at row number m and column
	// number n from the topmost leftmost cell (cell at 1, 1)
	static int numberOfPaths_I(int m, int n)
	{
	    // Create a 2D table to store results of subproblems
	    int [][]count=new int[m][n];
	 
	    // Count of paths to reach any cell in first column is 1
	    for (int i = 0; i < m; i++)
	        count[i][0] = 1;
	 
	    // Count of paths to reach any cell in first column is 1
	    for (int j = 0; j < n; j++)
	        count[0][j] = 1;
	 
	    // Calculate count of paths for other cells in bottom-up manner using
	    // the recursive solution
	    for (int i = 1; i < m; i++)
	    {
	        for (int j = 1; j < n; j++)
	 
	            // By uncommenting the last part the code calculatest he total
	            // possible paths if the diagonal Movements are allowed
	            count[i][j] = count[i-1][j] + count[i][j-1]; //+ count[i-1][j-1];
	 
	    }
	    return count[m-1][n-1];
	}
	
	public static int uniquePathsWithDFS(int m, int n) {
	    return dfs(0,0,m,n);
	}
	 
	public static int dfs(int i, int j, int m, int n){
	    if(i==m-1 && j==n-1){
	        return 1;
	    }
	 
	    if(i<m-1 && j<n-1){
	        return dfs(i+1,j,m,n) + dfs(i,j+1,m,n);
	    }
	 
	    if(i<m-1){
	        return dfs(i+1,j,m,n);
	    }
	 
	    if(j<n-1){
	        return dfs(i,j+1,m,n);
	    }
	 
	    return 0;
	}
	
	public static int uniquePathsWithDFSWithRestriction(int m, int n) {
	    return dfsWithRestriction(0,0,m,n);
	}
	 
	public static int dfsWithRestriction(int i, int j, int m, int n){
	    if(i==m-1 && j==n-1&&i<=j){
	        return 1;
	    }
	 
	    if(i<m-1 && j<n-1&&i<=j){
	        return dfsWithRestriction(i+1,j,m,n) + dfsWithRestriction(i,j+1,m,n);
	    }
	 
	    if(i<m-1&&i<=j){
	        return dfsWithRestriction(i+1,j,m,n);
	    }
	 
	    if(j<n-1&&i<=j){
	        return dfsWithRestriction(i,j+1,m,n);
	    }
	 
	    return 0;
	}
	
	public static int uniquePathsWithDynamicProgramming(int m, int n) {
	    if(m==0 || n==0) return 0;
	    if(m==1 || n==1) return 1;
	 
	    int[][] dp = new int[m][n];
	 
	    //left column
	    for(int i=0; i<m; i++){
	        dp[i][0] = 1;
	    }
	 
	    //top row
	    for(int j=0; j<n; j++){
	        dp[0][j] = 1;
	    }
	 
	    //fill up the dp table
	    for(int i=1; i<m; i++){
	        for(int j=1; j<n; j++){
	            dp[i][j] = dp[i-1][j] + dp[i][j-1];
	        }
	    }
	 
	    return dp[m-1][n-1];
	}

}
