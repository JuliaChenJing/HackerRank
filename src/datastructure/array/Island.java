package datastructure.array;

public class Island {
	
	
https://www.careercup.com/question?id=5708658983829504
	static int getNumberOfIslands(int[][] binaryMatrix) {

		int re = 0;
		int sizeX = binaryMatrix.length;
		int sizeY = binaryMatrix[0].length;

		for (int i = 0; i < sizeX; i++)
			for (int j = 0; j < sizeY; j++) {
				if (binaryMatrix[i][j] == 1) 
				{
				
					//left top corner
					if(i==0 &&j==0 &&binaryMatrix[i ][j]==1)
						re++;
					
					if ((i - 1 >= 0 && binaryMatrix[i - 1][j] != 1)
							|| (j - 1 >= 0 && binaryMatrix[i][j - 1] != 1))
						re++;
				}
			}

		return re;

	}

	public static void main(String[] args) {
		int[][] binaryMatrix = { { 1, 1 }, { 0, 1 } ,{ 0, 1 } };
		System.out.println(getNumberOfIslands(binaryMatrix));
	}

}
