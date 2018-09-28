package pramp.dynamic_programming;

public class IslandCount {

	public static void main(String[] args) {
		int[][] smallSea = 
			{
				{ 1, 1 }, 
				{ 0, 1 },
				{ 0, 0 },
				{ 1, 0 } 
				};
		System.out.println("Number of islands is " +countIslands(smallSea));

		int[][] bigSea = new int[][] {
			new int[] { 0, 1, 0, 1, 0 }, 
			new int[] { 0, 0, 1, 1, 1 },
			new int[] { 1, 0, 0, 1, 0 },
			new int[] { 0, 1, 1, 0, 0 },
			new int[] { 1, 0, 1, 0, 1 },
			new int[] { 1, 0, 1, 0, 1 } 
			};		
		System.out.println("Number of islands is " + +countIslands(bigSea));
	}

	// https://www.careercup.com/question?id=5708658983829504
	public static int countIslands(int[][] sea) {
		boolean[][] visited = new boolean[sea.length][sea[0].length];
		// set all values false
		for (int i = 0; i < sea.length; i++) {
			for (int j = 0; j < sea[0].length; j++) {
				visited[i][j] = false;
			}
		}
		// transfer two matrix
		return countIslandsHelper(sea, visited);
	}

	public static int countIslandsHelper(int[][] sea, boolean[][] visited) {
		int numOfIslands = 0;
		for (int i = 0; i < sea.length; i++) {
			for (int j = 0; j < sea[0].length; j++) {
				if (visited[i][j])
					continue;
				if (sea[i][j] == 0) {
					visited[i][j] = true;
					continue;
				}
				// ==1 and not visited
				numOfIslands++;
				floodFill(i, j, sea, visited);
			}
		}
		return numOfIslands;
	}

	public static void floodFill(int row, int col, int[][] sea, boolean[][] visited) {
		if (sea[row][col] == 0 || visited[row][col])
			return;

		visited[row][col] = true;// visited

		if (col < sea[0].length - 1)
			floodFill(row, col + 1, sea, visited);
		if (row < sea.length - 1)
			floodFill(row + 1, col, sea, visited);
		if (col > 0)
			floodFill(row, col - 1, sea, visited);
		if (row > 0)
			floodFill(row - 1, col, sea, visited);
	}
}
