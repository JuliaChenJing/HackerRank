package datastructure.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//给定一个区间集合，合并里面重叠的区间，并返回新的不含重叠区间的集合。
//例如，输入[1,5],[6,10],[4,6],[15,20],输出[1,10],[15,20]
public class MergeInterval {

	public static void main(String[] args) {

		Interval a = new Interval(1, 5);
		Interval b = new Interval(6, 10);
		Interval c = new Interval(5, 11);
		Interval d = new Interval(15, 20);
		Interval[] A = { a, b, c, d };
		ArrayList<Interval> Re = merge(A);
		for (int i = 0; i < Re.size(); i++) {
			System.out.println("[" + Re.get(i).start + "," + Re.get(i).end + "]");
		}

		ArrayList<Interval> Ori = new ArrayList<Interval>();
		Ori.add(a);
		Ori.add(b);
		Ori.add(c);
		Ori.add(d);
		ArrayList<Interval> re = merge(Ori);
		for (int i = 0; i < re.size(); i++) {
			System.out.println("[" + re.get(i).start + "," + re.get(i).end + "]");

		}

	}

	// 1 我自己做的，还行，第一个起点算的不对
	static ArrayList<Interval> merge(Interval[] A) {
		int start = -1, end = -1, count = 0;
		ArrayList<Interval> res = new ArrayList<Interval>();// 返回值

		if (A == null) {
			// 输出是null，那么直接返回新区间
			res = null;
			return res;
		}

		Point[] points = new Point[A.length * 2];

		for (int i = 0; i < A.length; i++) {// 将Interval里的起止位置转为可排序的点

			points[2 * i] = new Point(A[i].start, 0);// 偶数位置是起点

			points[2 * i + 1] = new Point(A[i].end, 1);// 奇数位置是止点

		}

		Arrays.sort(points);// 排序 ,这样点就不是成组出现的了

		//依次处理每一个点
		for (int i = 0; i < points.length; i++) {

			if (points[i].type == 0)// 如果这个点是起点
			{

				count++;// 到起点时，count加1，表示进入区间；当遇到止点时，count减1，表示离开区间。

				if (count > 1)// 两个起点

				{
					start = Math.min(points[i].value, start);

				}

				else
					start = points[i].value;
			}

			else// 如果这个点是止点
			{
				count--;

				if (count == 0)// 区间结束了
				{
					if (i + 1 < points.length)// 还有下一个区间

					{
						if (points[i].value != points[i + 1].value)// 下一个区间的起点不等于上一个的终点
						{
							end = Math.max(points[i].value, end);
							res.add(new Interval(start, end));
						} else// 起点终点重合
							end = points[i].value;
					}

					else if (i + 1 == points.length)// 没有下一个区间了
					{
						end = points[i].value;
						res.add(new Interval(start, end));
					}

				} else// 区间没结束
				{
					end = points[i].value;
				}

			}
		}
		return res;
	}

	/*
	 * 2 书上的答案 有点儿递归的意思 1. 首先，为了方便合并区间，首先对集合进行排序。 2. 然后，初始化结果集。 3.
	 * 最后，扫描原始集合。如果原始集的区间和结果集的最后一个区间重叠，那么合并这两个区间，并更新结果集；如果不重叠，则将此区间加入结果集。
	 */

	static ArrayList<Interval> merge(ArrayList<Interval> intervals)// 合并Interval
	{
		ArrayList<Interval> res = new ArrayList<Interval>();
		if (intervals == null || intervals.isEmpty())
			return res;// 不用再写res=null;因为本来没赋值的话就是null

		// 调用java排序函数
		// 1. 对集合进行排序，这样就是我们认为的数法，这样就不会出现我自己编程的问题了
		Collections.sort(intervals, Interval.comparator);

		// 2. 处理
		for (int i = 0; i < intervals.size(); i++)// 这是ArrayList数个数的方法
		{
			Interval current = intervals.get(i);// 得到当前的Interval进行处理
			if (res.isEmpty())// 放一个在空的里面
			{
				res.add(current);
			} else {
				// 这样定义很清楚处理的是哪个Interval
				Interval last = res.get(res.size() - 1);// 得到res的最后一个保存的区间
				if (last.end >= current.start)// 有前后重合的情况
				{
					last.end = Math.max(last.end, current.end);// 应该是把res里面的最后一个的end值也改了
				} else {
					res.add(current);// 不重合
				}
			}
		}
		return res;
	}

}
