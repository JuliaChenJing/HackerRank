package datastructure.hashtable.myHashTable;
//demonstrates hash table user defined implementation with linear probing
import java.io.*;
import java.util.Scanner;


public class DriverClass {

	public static void main(String[] args) throws IOException {
		int aKey;
		String value;

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Enter size of hash table: ");
		int size = in.nextInt();

		HashTable theHashTable = new HashTable(size);

		theHashTable.insert(1, "FPP");
		theHashTable.insert(5, "Java");
		theHashTable.insert(7, "SE");
		theHashTable.insert(10, "C#");

		while (true) // interact with user
		{
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, delete, or find: ");
			char choice = in.next().charAt(0); // Read a Char from the console
			switch (choice) {
			case 's':
				theHashTable.displayTable();
				break;
			case 'i':
				System.out.print("Enter key and value to insert: ");
				aKey = in.nextInt();
				value = in.next();
				theHashTable.insert(aKey, value);
				break;
			case 'd':
				System.out.print("Enter key value to delete: ");
				aKey = in.nextInt();
				theHashTable.delete(aKey);
				break;
			case 'f':
				System.out.print("Enter key value to find: ");
				aKey = in.nextInt();
				System.out.println("Key Found status" + theHashTable.find(aKey));
				break;
			default:
				System.out.print("Invalid entry\n");
			} // end switch
		} // end while
	} // end main()
	// --------------------------------------------------------------
} // end class HashTableApp
	////////////////////////////////////////////////////////////////


