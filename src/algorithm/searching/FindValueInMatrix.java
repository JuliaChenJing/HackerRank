package algorithm.searching;

public class FindValueInMatrix {

	/*
	 * Given a matrix in which each row and each column is sorted, write a
	 * method to !nd an element in it.
	 * 
	 * Assumptions: » Rows are sorted left to right in ascending order. Columns
	 * are sorted top to bottom in ascending order. » Matrix is of size MxN.
	 * This algorithm works by elimination. Every move to the left (--col)
	 * eliminates all the elements below the current cell in that column.
	 * Likewise, every move down eliminates all the elements to the left of the
	 * cell in that row.
	 */

	boolean FindElem(int[][] mat, int elem, int M, int N) {
		int row = 0;
		int col = N - 1;
		while (row < M && col >= 0) {
			if (mat[row][col] == elem) {
				return true;
			} else if (mat[row][col] > elem) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
}
