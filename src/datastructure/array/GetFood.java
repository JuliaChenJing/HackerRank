package datastructure.array;

public class GetFood {
	/*
	 * Ben is starving and he wants to get some food to eat as quickly as
	 * possible. Help him determine the shortest path to get the food. Ben's
	 * location is represented by '*' and there is only one '*' location. The
	 * food is presented by '#' and there may be multiple food locations. Areas
	 * with 'X' represent the space you cannot pass through. Areas with 'O' (the
	 * letter O) represent the space you can walk through.
	 * 
	 * 
	 * Output the length of the shortest path to food. If no food is available,
	 * return -1.
	 * 
	 * Example 1:
	 * 
	 * Input: XXXXXX X*OOOX XOO#OX XXXXXX Output: 3 Explanation: There is only
	 * one path to get the food.
	 * 
	 * Example 2:
	 * 
	 * Input: XXXXX X*XOX XOX#X XXXXX Output: -1 Explanation: We cannot find a
	 * path to get the food.
	 */

	public static int getFood(char[][] grid) {
		int locationX = 0;
		int locationY = 0;
		int foodX = 0;
		int foodY = 0;
		boolean locationFound = false;
		boolean foodFound = false;

		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++) {
				
				if (!(locationFound && foodFound)) {

					if (grid[i][j]=='*') {
						locationX = i;
						locationY = j;
						locationFound = true;
						System.out.println(i+" "+j);
					}

					if (grid[i][j] == '#') {
						foodX = i;
						foodY = j;
						foodFound = true;
					System.out.println(i+" "+j);
						
					}
				}
			}

		int re = path(grid,locationX,locationY, foodX,foodY) ;

		return re;

	}

	private static int path(char[][] grid, int x1, int y1, int x2, int y2) {
		if(x1<0 ||x1>=grid.length||y1<0||y1>=grid[0].length ||grid[x1][y1]=='X')
			return -1;//wrong way
		if(x1==x2 && y1==y2)
			return 0;
		
		return 1+min(path(grid,x1+1,y1,x2,y2),
				path(grid,x1-1,y1,x2,y2),
				path(grid ,x1,y1+1,x2,y2),
				path(grid,x1,y1-1,x2,y2));
	}

	private static int min(int a, int b, int c, int d) {
		int min=400;
		if(a<min &&a!=-1)
			min=a;
		if(b<min &&b!=-1)
			min=b;
		if(c<min&&c!=-1)
			min=c;
		if(d<min&&d!=-1)
			min=d;
		if(min==400)
			min=-400;
		return min;
	}

	public static void main(String[] args) {
		char[][] a = { { 'X', 'X' ,'X'}, { '*','#','O' } };
		//char[][] a = { { 'X', 'X' ,'X'}, { '*','O' ,'#'} };
		System.out.println(getFood(a));
	}

}
