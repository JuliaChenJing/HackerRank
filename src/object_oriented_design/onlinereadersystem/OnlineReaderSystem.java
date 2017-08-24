package object_oriented_design.onlinereadersystem;

/*
 * Design the data structures for an online book reader system.
 * 
 * Since the problem doesn’t describe much about the functionality, let’s
 * assume we want to design a basic online reading system which provides the
 * following functionality: 
 * 
 * » User membership creation and extension. 
 * »Searching the database of books » Reading the books To implement these we
 * may require many other functions, like get, set, update, etc. Objects
 * required would likely include User, Book, and Library.
 * 
 */
public class OnlineReaderSystem {
	private Book b;
	private User u;

	public OnlineReaderSystem(Book b, User u) {
	}

	public void listenRequest() {
	}

	public void display() {
	}

	/*
	 * This design is a very simplistic implementation of such a system. We have
	 * a class for User to keep all the information regarding the user, and an
	 * identifier to identify each user uniquely. We can add functionality like
	 * registering the user, charging a membership amount and monthly / daily
	 * quota, etc. Next, we have book class where we will keep all the book’s
	 * information. We would also implement functions like add / delete / update
	 * books. Finally, we have a manager class for managing the online book
	 * reader system which would have a listen function to listen for any
	 * incoming requests to log in. It also provides book search functionality
	 * and display functionality. Because the end user interacts through this
	 * class, search must be implemented here.
	 */

}
