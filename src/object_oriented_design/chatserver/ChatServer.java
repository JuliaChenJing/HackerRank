package object_oriented_design.chatserver;

/*
 * Explain how you would design a chat server. In particular, provide details about the
various back-end components, classes, and methods. What would be the hardest
problems to solve?
 */
public class ChatServer {
	/*
	 * What is our chat server?
	 * 
	 * This is something you should discuss with your interviewer, but let’s
	 * make a couple of as assumptions: imagine we’re designing a basic chat
	 * server that needs to support a small num ber of users. People have a
	 * contact list, they see who is online vs o%ine, and they can send
	 * text-based messages to them. We will not worry about supporting group
	 * chat, voice chat, etc. We will also assume that contact lists are mutual:
	 * I can only talk to you if you can talk to me. Let’s keep it simple. What
	 * specific actions does it need to support?
	 * 
	 * » User A signs online » User A asks for their contact list, with each
	 * person’s current status. » Friends of User A now see User A as online »
	 * User A adds User B to contact list » User A sends text-based message to
	 * User B » User A changes status message and/or status type » User A
	 * removes User B » User A signs offline
	 * 
	 * What can we learn about these requirements? We must have a concept of
	 * users, add request status, online status, and messages. What are the core
	 * components? We’ll need a database to store items and an “always online”
	 * application as the server. We might recommend using XML for the
	 * communication between the chat server and the clients, as it’s easy for a
	 * person and a machine to read. What are the key objects and methods? We
	 * have listed the key objects and methods below. Note that we have hidden
	 * many of the details, such as how to actually push the data out to a
	 * client.
	 */

	User getUserByUsername(String username) {
		return null;
	}

}
