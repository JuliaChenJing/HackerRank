package datastructure.arrays;
//返回将一维数组向右旋转k个位置的结果。比如，一维数组{1,2,3,4,5}，k=2时，返回结果是{4,5,1,2,3}。
//要求常数级空间复杂度，允许修改原有数组。
public class RotateArray {

	// 如果允许额外分配线性空间，那么可以错位复制原有数组的元素。
	static int[] rotateK(int[] A, int k) {
		if (A == null || k >= A.length)
			return A;

		int[] B = new int[A.length];
		// 后面k个复制到前面
		System.arraycopy(A, A.length - k, B, 0, k);
		// 前面的a.length-1-k个复制到后面
		System.arraycopy(A, 0, B, A.length - k - 1, A.length - k);
		return B;
	}
	


	/*
	 * 如果允许修改原有数组，那么我们可以通过三次反转组来实现数组旋转，，不需要申请额外空间，
	 * 并且每次 反转时间为O（n），从而实现线性的时间复杂度和常数级的空间复杂度。
	 */
	 static int [] rotateK_2(int [] A, int k){
	        if(A==null|| k>=A.length) return A;
	        reverse(A,0,A.length-1);//反转整个数组
	        reverse(A,0,k-1);//反转前k个数
	        reverse(A,k,A.length-1);//反转剩下的数
	        return A;
	    }

	    //辅助函数，反转从start到end的数
	    static  void reverse (int [] A,int start,int end){
	        while(start<end){
	            //交换A[start]和A[end]两个数
	            int temp=A[start];
	            A[start]=A[end];
	            A[end]=temp;
	            start++;
	            end--;
	        }
	    }
	    
		public static void main(String[] args) {
			int a[] = { 1, 2, 3, 4, 5 };
			int b[] = rotateK(a, 2);
			for (int i = 0; i < b.length; i++)
				System.out.print(b[i]);
			
			System.out.println();
			
			int c[] =  rotateK_2(a,2);
		        for(int i=0;i<a.length;i++)
		        System.out.print(c[i]);
		}
}
