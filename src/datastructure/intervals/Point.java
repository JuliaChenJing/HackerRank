package datastructure.intervals;

// 首先，要定义区间的类，实现Comparable接口，含有起点与止点的值和类型，还要重写用于排序的compareTo函数。
class Point implements Comparable<Point>// implements就是接口咯？
{
	int value;// 数值
	int type;// 点的类型，0为起点，1为止点

	Point(int v, int t)// 构造函数，这个点的形式很怪，不要和xy坐标混了
	{
		value = v;
		type = t;
	}

	// 实现CompareTo函数，以便排序，这一步用到 Arrays.sort(points)

	public int compareTo(Point p) {
		if (this.value == p.value) {
			return p.type - this.type;
		} else if (this.value > p.value) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override

	public String toString() {

		return "Point [value=" + value + ", type=" + type + "]";
	}

}