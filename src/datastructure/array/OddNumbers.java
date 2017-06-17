package datastructure.array;


public class OddNumbers {

	static int[] oddNumbers(int l, int r) {
		int length;

		if (l % 2 == 0 && r % 2 == 0)// 0 0
		{
			length = (r - l) / 2  ;

		} else if (l % 2 == 1 && r % 2 == 1) //1 1
		{
			length = (r - l) / 2+1;

		} else if (l % 2 == 0 && r % 2 == 1)//0 1
		{
			length = (r - l) / 2+1;

		} else// 1 0

		{
			length = (r - l) / 2+1;
		}
		
		int[] arr = new int[length];
		int k = 0;
		for (int i = l; i <= r; i++) {
			if (i % 2 == 1) {
				arr[k] = i;
				k++;
			}
		}
		return arr;

	}

	public static void main(String[] args) {
		int a[]=oddNumbers(0,6);
		for(int i=0;i<a.length;i++)
		System.out.print( a[i]);
	}
}
