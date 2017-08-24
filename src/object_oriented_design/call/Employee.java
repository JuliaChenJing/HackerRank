package object_oriented_design.call;

public class Employee {

	// 0�? fresher, 1 �? technical lead, 2 �? product manager
	int rank;
	boolean free;
	CallHandler callHandler;

	Employee(int rank) {
		this.rank = rank;
	}

	void receiveCall(Call call) {
	}

	void callHandled(Call call) {
	}

	// escalate call
	void escalateCall(Call call) {
		call.setRank(rank + 1);
		callHandler.dispatchCall(call);
		free = true;
		callHandler.getNextCall(this);
	}
}

class Fresher extends Employee {
	public Fresher() {
		super(0);
	}
}

class TechLead extends Employee {
	public TechLead() {
		super(1);
	}
}

class ProductManager extends Employee {
	public ProductManager() {
		super(2);
	}
}
