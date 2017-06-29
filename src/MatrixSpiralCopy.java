public class MatrixSpiralCopy {

	/*
	 * [ [1, 2, 3, 4, 5], [6, 7, 8, 9, 10], [11, 12, 13, 14, 15], [16, 17, 18,
	 * 19, 20] ]
	 * 
	 * 
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
