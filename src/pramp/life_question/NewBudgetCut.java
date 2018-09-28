package pramp.life_question;

public class NewBudgetCut {

	/*
	 * The awards committee of your university asked for your assistance with a
	 * budget allocation problem they are facing. Originally, the committee
	 * planned to give N research grants this year. However, due to spending cut
	 * backs, the budget was reduced to newTotalBudget dollars and now they need
	 * to reallocate the grants. The committee made a decision that they would
	 * like to impact as few grant recipients as possible by applying a maximum
	 * cap on all grants. Every grant initially planned to be higher than cap
	 * will now be exactly cap dollars. Grants less or equal to cap, obviously,
	 * will not be impacted.
	 * 
	 * Given an array originalGrants of the original grants and the reduced
	 * budget newTotalBudget, write a function findGrantsNumber that finds in
	 * the most efficient manner a cap such that the least numOfOrganizationber
	 * of recipients is impacted and that the new budget constraint is met (i.e.
	 * sum of the N reallocated grants equals to newTotalBudget).
	 * 
	 * Analyze the time and space complexities of your solution.
	 * 
	 * Example:
	 * 
	 * input: originalGrants = [2, 100, 50, 120, 1000], newTotalBudget = 190
	 * 
	 * output: 47 # and given this cap the new grants array would be # [2, 47,
	 * 47, 47, 47]. Notice that the sum of the # new grants is indeed 190
	 */

	public static void main(String[] args) {
		double[] originalGrants = { 2, 100, 50, 120, 1000 };
		System.out.println(findGrantsNumber(originalGrants, 190));
	}

	static double findGrantsNumber(double[] originalGrants, double newTotalBudget) {
		int numOfOrganization = originalGrants.length;
		bubbleSort(originalGrants);// 2,50,100,120,1000
		double newCutGrand;

		for (int numOfOrganizationImpacted = 1; numOfOrganizationImpacted <= numOfOrganization; numOfOrganizationImpacted++) {
			double total = newTotalBudget;
			for (int i = 0; i < numOfOrganization - numOfOrganizationImpacted; i++) {
				total = total - originalGrants[i];
			}
			newCutGrand = total / numOfOrganizationImpacted;

			System.out.println("numOfOrganizationImpacted " + numOfOrganizationImpacted);
			System.out.println("newCutGrand " + newCutGrand);

			if (newCutGrand > 0 && isValid(originalGrants, newTotalBudget, newCutGrand, numOfOrganizationImpacted)) {
				System.out.println(numOfOrganizationImpacted);
				return newCutGrand;
			}
		}
		return -1;
	}

	static boolean isValid(double[] originalGrants, double newTotalBudget, double newCutGrand,
			int numOfOrganizationImpacted) {
		int numOfOrganization = originalGrants.length;
		for (int i = 0; i < numOfOrganization - numOfOrganizationImpacted; i++)
			if (originalGrants[i] > newCutGrand)
				return false;
		for (int j = numOfOrganization - 1; j >= numOfOrganizationImpacted - 1; j--)
			if (originalGrants[j] < newCutGrand)
				return false;
		return true;
	}

	static void bubbleSort(double[] arr) {
		int n = arr.length;
		double temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
