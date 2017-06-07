package datastructure.queue;


//Implementation using Comparable Interfacce
class Sale_II  implements Comparable 
{
	int sid;
	String item;
	double price;
	
	@Override
	public int compareTo(Object obj) {
		Sale_II AObj = (Sale_II) obj;
		if (this.sid > AObj.sid)
			return 1;
		else if (this.sid < AObj.sid)
			return -1;
		else
			return 0;
	}

	public Sale_II(int sid, String item, double price) {
		this.sid = sid;
		this.item = item;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	
	 public String toString() {
	        return  "Sid=" + sid + ", Item Name=" + item + ", Item Price=" + price ;
	    }
}