package datastructure.intervals;

import java.util.Comparator;

class Interval{
    int start;
    int end;
  
	public Interval(int a, int b) {
		  start=a;
	        end=b;
	}
	
	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}
	
	static Comparator <Interval> comparator=new Comparator <Interval> ()
	{
		@Override
		public int compare(Interval a, Interval b)
		{
			if(a.start<b.start) return -1;
			else if(a.start>b.start) return 1;
			else
			{
				//start值相同，还要比较end
				if(a.end<b.end) return -1;
				else if(a.end>b.end) return 1;
				else return 0;	
			}
		}
	};
}
