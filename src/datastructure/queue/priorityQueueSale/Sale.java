package datastructure.queue.priorityQueueSale;

class Sale {
	int sid;
	String item;
	double price;

	public Sale(int sid, String item, double price) {
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
		return "Sid=" + sid + ", Item Name=" + item + ", Item Price=" + price;
	}
}
