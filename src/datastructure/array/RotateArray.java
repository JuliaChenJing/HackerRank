package datastructure.array;

//返回将一维数组�?��?�旋转k个�?置的结果。比如，一维数组{1,2,3,4,5}，k=2时，返回结果是{4,5,1,2,3}。
//�?求常数级空间�?�?�度，�?许修改原有数组。
public class RotateArray {

	static int[] rotateK(int[] A, int k) {
		if (A == null || k >= A.length)
			return A;

		int[] B = new int[A.length];

		// 5
		System.arraycopy(A, k, B, 0, A.length - k);

		// 1 2 3 4
		System.arraycopy(A, 0, B, A.length - k, k);
		return B;
	}

	/*
	 * 如果�?许修改原有数组，那么我们�?�以通过三次�??转组�?�实现数组旋转，，�?需�?申请�?外空间， 并且�?次
	 * �??转时间为O（n），从而实现线性的时间�?�?�度和常数级的空间�?�?�度。
	 */
	static int[] rotateK_2(int[] A, int k) {
		if (A == null || k >= A.length)
			return A;
		reverse(A, 0, A.length - 1);// reverse the whole
		reverse(A, 0, k - 1);// reverse the first k
		reverse(A, k, A.length - 1);// reverse the rest
		return A;
	}

	// the helper class , reverse the number from start to end
	static void reverse(int[] A, int start, int end) {
		while (start < end) {
			int temp = A[start];
			A[start] = A[end];
			A[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		int b[] = rotateK(a, 4);
		for (int i = 0; i < b.length; i++)
			System.out.print(b[i]);

		System.out.println();

		int c[] = rotateK_2(a, 4);
		for (int i = 0; i < c.length; i++)
			System.out.print(c[i]);
	}
}
