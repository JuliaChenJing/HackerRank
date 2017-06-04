package datastructure.intervals;

import java.util.ArrayList;

//  给定一个没有重叠的区间序列。现在插入一个新的区间到该序列中，要求维持没有重叠的情况。假设该 序列存放的区间是有序的
public class InsertInterval {

	public static void main(String[] args) {

		Interval a = new Interval(1, 3);
		Interval b = new Interval(6, 10);
		Interval c = new Interval(11, 14);
		Interval[] A = { a, b, c };
		Interval B = new Interval(4, 11);
		ArrayList<Interval> Re = insert(A, B);
		System.out.println("after merging,the left intervals are:");
		for (int i = 0; i < Re.size(); i++) {
			System.out.println(Re.get(i));
		}

	}

	/*
	 * 举例：假定我们已经有两个不重叠而且排好序的区间：【1，5】，【6，10】，现插入一个新的区间【4，6】，那么最后结果是【1，10】。
	 * 这道题的关键是找出与插入区间重叠的区间（可能有多个），然后合并成一个新的区间。对于其他非重叠的部分，直接加入结果集合就可以了。
	 * 如何合并两个有重叠的区间呢？例如【1，5】和【4，6】，因为4<=5<=6,所以这两个区间是重叠的，那么合并后新区间的起点取双方起点的最小值1，
	 * 止点取双方止点的最大值6，因此新的区间为【1，6】。
	 */

	// 实现合并新旧区间功能的函数
	static ArrayList<Interval> insert(Interval[] intervals, Interval newInt) {
		ArrayList<Interval> res = new ArrayList<Interval>();// 返回值

		if (intervals == null)

		{
			// 输出是null，那么直接返回新区间
			res.add(newInt);// 好感动，ArrayList.add()这么容易
			return res;
		}

		int i = 0;
		int n = intervals.length;// 数组.length统计数组长度

		// 如果新区间的起点大于前面的几个原有区间的终点
		while (i < n && newInt.start > intervals[i].end)

		{
			res.add(intervals[i]);
			i++;
		}

		// 如果存在重叠的区间，即越过了前面的几个小区间后，新区间的终点大于后面这个区间的起点，有重叠部分了
		while (i < n && newInt.end >= intervals[i].start) {

			newInt.end = Math.max(newInt.end, intervals[i].end);// 取较大值为终点
			newInt.start = Math.min(newInt.start, intervals[i].start);// 取较小值为起点
			i++;
		}

		// 加上合并后的新区间
		res.add(newInt);

		// 加上剩余的部分，如果有的话
		while (i < n) {
			res.add(intervals[i]);
			i++;
		}
		return res;
	}

}
