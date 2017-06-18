package datastructure.array;

public class Arrow {

	public static void main(String[] args) {
		int[] a = { 1, 5, 10, 3 };
		System.out.println("sprint of array :");
		for (int i = 0; i < a.length - 1; i++) {
			System.out.println(a[i] + "--->" + a[i + 1]);
		}

		int re = mostVisitedPosition(10, a);

		System.out.println("most visited location is : " + re);
	}

	/*
	 * n :length of the trail. Each position along the trail is indexed
	 * sequentially from 1 to n.
	 *
	 * int a[] : integer array, The sequence of locations a[0]-->a[1]-->a[2]
	 * 
	 * return an integer denoting most visited position on the trail after
	 * performing all a.length-1 sprints. If there are multiple such answers,
	 * return the smallest one.
	 */
	static int mostVisitedPosition(int n, int sprints[]) {
		int[] count = new int[n + 1];
		for (int i = 0; i <= n; i++)
			count[i] = 0;

		for (int i = 0; i < sprints.length - 1; i++) {

			if (sprints[i] < sprints[i + 1]) {

				for (int j = sprints[i]; j <= sprints[i + 1]; j++) {
					count[j]++;
				}
			} else {
				for (int j = sprints[i]; j >= sprints[i + 1]; j--) {
					count[j]++;
				}
			}
		}

		int max = count[1], re = 1;
		;
		for (int i = 1; i <= n; i++) {
			System.out.println(i + " : " + count[i]);
			if (max < count[i]) {
				max = count[i];
				re = i;
			}
		}

		return re;
	}

}
