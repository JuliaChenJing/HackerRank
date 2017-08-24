package object_oriented_design.chatserver;

class AddRequest {

	User from_user;
	User to_user;

	/*
	 * What problems would be the hardest to solve (or the most interesting)?
	 * 
	 * 1 How do we know if someone is online—I mean, really, really know? While
	 * we would like users to tell us when they sign o#, we can’t know for sure.
	 * A user’s connection might have died, for example. To make sure that we
	 * know when a user has signed o#, we might try regularly pinging the client
	 * to make sure it’s still there.
	 * 
	 * 2 How do we deal with conflicting information? We have some information
	 * stored in the computer’s memory and some in the database. What happens if
	 * they get out of sync? Which one is “right”?
	 * 
	 * 3 How do we make our server scale? While we designed out chat server
	 * without worrying—too much– about scalability, in real life this would be
	 * a concern. We’d need to split our data across many servers, which would
	 * increase our concern about out of sync data.
	 * 
	 * 4 How we do prevent denial of service attacks? Clients can push data to
	 * us—what if they try to DOS us? How do we prevent that?
	 */

}