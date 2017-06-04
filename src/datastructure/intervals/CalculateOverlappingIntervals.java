package datastructure.intervals;

import java.util.Arrays;

// 给定多个可能重叠的区间，找出重叠区间的个数（只要这个区间与别的区间有重叠）
public class CalculateOverlappingIntervals {

	public static void main(String[] args) {
		Interval a = new Interval(1, 3);
		Interval b = new Interval(2, 10);
		Interval c = new Interval(3, 14);
		Interval[] A = { a, b, c };
		int re = getOverlappingCount(A);
		System.out.println();
		System.out.print("over lapping number is :" + re);
	}

	/*
	 * 本题考查的是面试者对复杂数据结构排序的能力。加入输入的四个区间：[start1,end1],[start2,end2],[start3,end3]
	 * ,[start4,end4],我们不区分区间点的类型，而是根据区间点的大小排序，得到start1-start2-start3-end1-end2-
	 * end3-start4-end4。 然后扫描上面的结果，当遇到起点时，重叠个数加1，并且记录重叠个数的最大值；否则当遇到止点时，重叠个数减1.
	 */

	public static int getOverlappingCount(Interval[] A) {

		int loap = 0, count = 0;

		// 如果Interval组为空或长度为0，返回0
		if (A == null || A.length == 0)
			return loap;

		// 区间转换为点，并将点排序，然后统计重叠的个数。
		// 保存点的数组的长度是保存Interval的数组的长度的两倍
		Point[] points = new Point[A.length * 2];

		for (int i = 0; i < A.length; i++) {// 将Interval里的起止位置转为可排序的点

			points[2 * i] = new Point(A[i].start, 0);// 偶数位置是起点

			points[2 * i + 1] = new Point(A[i].end, 1);// 奇数位置是止点

		}

		Arrays.sort(points);// 排序 ,这样点就不是成组出现的了
		System.out.println("sorted array: ");
		for (int i = 0; i < points.length; i++)
			System.out.println(points[i]);

		for (int i = 0; i < points.length; i++) {
			if (points[i].type == 0)// 如果这个点是起点
			{

				count++;// 到起点时，count加一，表示进入区间；当遇到止点时，count减一，表示离开区间。

				if (count > 1)// 如果遇到超过一个起点

				{
					if (loap == 0)
						loap = 2;// 头一次的count>1会产生两个和对方有重叠的区间
					else
						loap += 1;
				}
			}

			else// 如果这个点是止点
			{
				count--;
			}
		}
		return loap;
	}// 此算法时间主要消耗在对点的排序上，因此，时间复杂度为O（nlogn）

	/*
	 * 作者给出的思路，有两步，首先对区间进行区间点的排序， 以及之后对重叠的判定。
	 * 
	 * 作者给出对重叠的判定是这样：扫描排序后的结果，“当遇到起点时，重叠个数加一，并且记录重叠个数的最大值；否则当遇到止点时，重叠个数减一”。
	 * 但是怎么想都应该是当遇到起点时，计数加一，表示进入区间；当遇到止点时，计数减一，表示离开区间。计数不为0时，再次遇到另一个起点，表明区间发生了重叠
	 * ，这时重叠数加一。通过扮演分析，作者给出的判定方法，对于一个有序的每三个地重叠的的区间序列中，只能得到一个3的max值。
	 * 
	 * 此外作者给出的排序方法也有问题，根据作者的思路，他所希望的排序结果是，当边界发生重叠时，起点值一定是排在止点值的前面。对于作者的举例输入“[1,5
	 * ], [10,15], [5,10],
	 * [20,30]”中，如果排序是稳定的话，"[5"一定不会被排在"5]"的前面。所以比较方法中缺少了一个类型优先的次级比较条件。
	 * 
	 * 并且作者为得出他举例的结果3，在getOverlappingCount函数中作弊将count初始值为1。对于区间点排序的结果，
	 * 第一个点一定是起点类型，即使输入中只有一个区间，或输入的是一些不重叠的区间，作者的代码都返回2。
	 * 虽然区间发生重叠最少是2个不可能1个区间自己发生重叠，但是作者初始count=1明显不符合它自身的意义。
	 * 
	 */

}
