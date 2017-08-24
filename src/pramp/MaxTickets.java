package pramp;
import java.util.Arrays;

public class MaxTickets {

	static int maxTickets(int[] tickets) {
		
		if (tickets==null||tickets.length==0)
			return 0;
		if(tickets.length==1)
			return 1;
		int count=1;
		int max=0;
		Arrays.sort(tickets);
		
		for(int i=1;i<tickets.length;i++){
			if(tickets[i]-tickets[i-1]<=1)
				count++;
			else {
				if(max<count)
					max=count;
				count=1;
			}
				
		}
		
		if(max<count)
			max=count;
		return max;

	}

	public static void main(String[] args) {
		int [] tickets={0,1,3,3,4,8,8,8,8};

		System.out.println(maxTickets(tickets));
	}

}