package datastructure.queue;

class Sale_I {
	int sid;
	String item;
	double price;

	public Sale_I(int sid, String item, double price) {
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
		return "\n Sid=" + sid + ", Item Name=" + item + ", Item Price=" + price;
	}
	
	
}