package datastructure.arrays;

import java.util.Arrays;

/*
 *     给定两个数组表示的整数，比如x=1234={1，2，3，4}，y=2410={2,4,1,0},返回第一个数组的重组后的值 最接近第二个整数，并且大于第二个整数。假设两个整数的数组大小相同，并且肯定能找出符合条件的数。输入{1，2，3，4}和{2，4，0，1}，返回{2，4，1，3}
 */
public class GetClosestBigger {

	static public void main(String[] args) {
		int[] a = { 3, 8, 3, 4, 5 };
		System.out.println("next to integer ");
		int[] b = { 2, 3, 4, 8, 1 };
		int[] c = getClosestBigger(a, b);
		for (int i = 0; i < c.length; i++)
			System.out.print(c[i]);

	}

	/*
    分析：从y的高位开始，挑一个和该位数字相等或更大的数字，直至到达数组的尾部。
    为了方便从x里挑出一个与y对应的相等或更大的数字，我们需要：
  1. 将数字x进行排序
  2. 使用一个一维数组记录x的使用情况
   如果从x挑出来的是相等的数字，那么我们对剩下数位重复上述操作；否则，如果挑出来的是大于y的数字，
   后面的数位只要复制递增未使用的x数就可以了。  
   例如，x={1，2，3，5}，y={2，4，1，0}；
  1. 从x挑出2，即y的首位数值
  2. 从x挑出5，因为最接近4且大于等于4 的值为5
  3. 因为5大于4，只需复制x未使用的数字，，即{2，5，1，3}
	 */
	static int[] getClosestBigger(int[] x, int[] y) {
		int r = 0;
		boolean[] isUsed = new boolean[x.length];
		int re[] = new int[x.length];
		for (int i = 0; i < isUsed.length; i++)
			isUsed[i] = false;

		Arrays.sort(x);

		for (int i = 0, j = 0; j < x.length; i++, j++) {
			if (isUsed[i] = false) {
				if (x[i] == y[j]) {
					isUsed[i] = true;
					re[r++] = x[i];
					continue;
				} 
				else if (x[i] > y[j]) {
					isUsed[i] = true;
					re[r++] = x[i];
					for (int p = 0; p < x.length; p++)
						if (isUsed[p] = false)
							re[r++] = x[p];
				} else {
					j--;

				}

				if (i == 4)
					i = 0;
			}

		}

		return x;
	}
}