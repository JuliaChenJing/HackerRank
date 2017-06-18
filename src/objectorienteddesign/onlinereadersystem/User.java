package objectorienteddesign.onlinereadersystem;

import java.util.Set;

public class User {
	private long ID;
	private String details;
	private int accountType;
	private static Set<User> users;

	public void renewMembership() {
	}

	public static User find(long ID) {

		for (User u : users) {
			if (u.getID() == ID)
				return u;
		}
		return null;
	}

	private long getID() {

		return ID;
	}

	public static void addUser(long ID, String details, int accountType) {
		users.add(new User(ID, details, accountType));
	}

	public User(long iD, String details, int accountType) {
	}
}
