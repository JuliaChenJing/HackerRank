package datastructure.array;

public class OddNumbers {

	//find all odd numbers between [l,r ]
	static int[] oddNumbers(int left, int right) {
		
		int length;

		if (left % 2 == 0 && right % 2 == 0)// 0 0
		{
			length = (right - left) / 2;

		} else if (left % 2 == 1 && right % 2 == 1) // 1 1
		{
			length = (right - left) / 2 + 1;

		} else if (left % 2 == 0 && right % 2 == 1)// 0 1
		{
			length = (right - left) / 2 + 1;

		} else// 1 0

		{
			length = (right - left) / 2 + 1;
		}

		int[] arr = new int[length];
		int k = 0;
		for (int i = left; i <= right; i++) {
			if (i % 2 == 1) {
				arr[k] = i;
				k++;
			}
		}
		return arr;

	}

	public static void main(String[] args) {
		int a[] = oddNumbers(0, 6);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]+" ");
	}
}
