package objectorienteddesign.chatserver;

class User {
	String username;
	String display_name;
	User[] contact_list;

	enum StatusType {
		online, offline, away;
	}

	class Status {
		StatusType status_type;
		String status_message;
	}

	AddRequest[] requests;

	boolean updateStatus(StatusType stype, String message) {
		return true;
	}

	boolean addUserWithUsername(String name) {
		return true;
	}

	boolean approveRequest(String username) {
		return true;
	}

	boolean denyRequest(String username) {
		return true;
	}

	boolean removeContact(String username) {
		return true;
	}

	boolean sendMessage(String username, String message) {
		return true;
	}
}