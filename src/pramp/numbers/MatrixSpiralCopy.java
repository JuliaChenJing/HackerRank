package pramp.numbers;

public class MatrixSpiralCopy {

	/*
	 *  [ [1, 2, 3, 4, 5],
	 *  [6, 7, 8, 9, 10],
	 *  [11, 12, 13, 14, 15], 
	 *  [16, 17, 18, 19, 20] ]
	 * 
	 * 
	 * Given a 2D array (matrix) inputMatrix of integers, create a function spiralCopy
	 *  that copies inputMatrix’s values into a 1D array in a spiral order, clockwise.
	 *   Your function then should return that array. Analyze the time and space
	 *    complexities of your solution.

     Example:

     input:  inputMatrix  = [ [1,    2,   3,  4,    5],
                         [6,    7,   8,  9,   10],
                         [11,  12,  13,  14,  15],
                         [16,  17,  18,  19,  20] ]

     output: [1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12]
	 * 
	 * Let inputMatrix be a matrix of numRows rows and numCols columns.

The general idea of the solution is to copy the 4 edges of the spiral rim we currently
 at and then move on to copy the next (inner) rim. We keep doing that until we reached 
 to the end of the spiral. We copy edges in the following order:

Copy the uppermost row from left to right.
Copy the rightmost column from top to bottom.
Copy the lowermost row from right to left.
Copy the leftmost column from bottom to top.
In order to figure what is the next row/column to copy in the spiral order we maintain
 4 indices:

topRow - index of the the uppermost row to be copied, starting from 0 and incrementing.
btmRow - index of the the lowermost row to be copied, starting from numRows-1 and
 decrementing.
leftCol - index of the leftmost column to be copied, starting from 0 and incrementing.
rightCol - index of the the rightmost column to be copied, starting from numCols-1 and 
decrementing.

	 * Pseudocode:

  function spiralCopy(inputMatrix):
    numRows = inputMatrix.length
    numCols = inputMatrix[0].length 
    
    topRow = 0
    btmRow = numRows - 1
    leftCol = 0
    rightCol = numCols - 1
    result = []

    while (topRow <= btmRow AND leftCol <= rightCol):
        # copy the next top row
        for i from leftCol to rightCol:
            result.push(inputMatrix[topRow][i])
        topRow++

        # copy the next right hand side column
        for i from topRow to btmRow:
            result.push(inputMatrix[i][rightCol])
        rightCol--

        # copy the next bottom row
        if (topRow <= btmRow):
            for i from rightCol to leftCol:
                result.push(inputMatri[btmRow][i])
            btmRow--

        # copy the next left hand side column
        if (leftCol <= rightCol):
            for i from btmRow to topRow:
                result.push(inputMatrix[i][leftCol])
            leftCol++

    return result
    
Time Complexity: iterating over N∙M cells, where N is the number of rows and M the 
number of columns, and copying them into any array takes O(N∙M). Note that this is
 a linear time complexity since the size of the input is O(N∙M).

Space Complexity: we used an auxiliary array of size N∙M as a return value, hence 
the space complexity is O(N∙M). This is a linear space complexity since the size 
of the input is O(N∙M) as well.
	 */
	static int[] spiralCopy(int[][] inputMatrix) {
		int sizeOfX = inputMatrix.length;
		int sizeOfY = inputMatrix[1].length;
		if (sizeOfX == 0 || sizeOfY == 0)
			return null;

		int startX = 0;
		int startY = 0;

		int[] result = new int[sizeOfX * sizeOfY];

		while (startX <= sizeOfX && startY <= sizeOfY) {

			// right

			// down

			// left

			// up

		}
		return result;
	}

	public static void main(String[] args) {

	}
}
