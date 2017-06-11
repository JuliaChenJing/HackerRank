package algorithm.objectorienteddesign.call;

public class Call {
	private int rank = 0; // minimal rank of employee who can handle this call

	public void reply(String message) {

	}

	public void disconnect() {
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
