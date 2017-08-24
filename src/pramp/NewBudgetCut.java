package pramp;

public class NewBudgetCut {

	/*
	 * The awards committee of your alma mater (i.e. your college/university)
	 * asked for your assistance with a budget allocation problem they’re
	 * facing. Originally, the committee planned to give N research grants this
	 * year. However, due to spending cutbacks, the budget was reduced to
	 * newBudget dollars and now they need to reallocate the grants. The
	 * committee made a decision that they’d like to impact as few grant
	 * recipients as possible by applying a maximum cap on all grants. Every
	 * grant initially planned to be higher than cap will now be exactly cap
	 * dollars. Grants less or equal to cap, obviously, won’t be impacted.
	 * 
	 * Given an array grantsArray of the original grants and the reduced budget
	 * newBudget, write a function findGrantsCap that finds in the most
	 * efficient manner a cap such that the least number of recipients is
	 * impacted and that the new budget constraint is met (i.e. sum of the N
	 * reallocated grants equals to newBudget).
	 * 
	 * Analyze the time and space complexities of your solution.
	 * 
	 * Example:
	 * 
	 * input: grantsArray = [2, 100, 50, 120, 1000], newBudget = 190
	 * 
	 * output: 47 # and given this cap the new grants array would be # [2, 47,
	 * 47, 47, 47]. Notice that the sum of the # new grants is indeed 190
	 */

	public static void main(String[] args) {
		double[] grantsArray = { 2, 100, 50, 120, 1000 };
		System.out.println(findGrantsCap(grantsArray, 190));
	}

	static double findGrantsCap(double[] grantsArray, double newBudget) {

		int num = grantsArray.length;// store the length of array

		bubbleSort(grantsArray);// 2,50,100,120,1000
		double cut;

		for (int cutNum = 0; cutNum <= 5; cutNum++) {
			if (cutNum == 0)
				cut = newBudget / 5;
			else {
				double total = newBudget;
				for (int i = 0; i < num - cutNum; i++) {
					total = total - grantsArray[i];

				}
				cut = total / (num - cutNum);

			}

			if (isValid(grantsArray, newBudget, cut, cutNum))
				// System.out.println(cutNum);
				return cut;

		}

		return -1;
	}

	static boolean isValid(double[] grantsArray, double newBudget, double cut, int cutNum) {

		int num = grantsArray.length;// store the length of array
		for (int i = num - 1; i >= num - cutNum; i--)
			if (grantsArray[i] >cut)
				return false;
		return true;
	}

	static void bubbleSort(double[] arr) {

		int n = arr.length;

		double temp = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					// swap elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}

			}
		}
		/// for (int i = 0; i < n; i++)
		// System.out.println(arr[i]);
	}

}
