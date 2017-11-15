
package datastructure.hashtable.myHashTable;
class HashTable {
	private DataItem[] hashArray; // array holds hash table
	private int arraySize;
	private DataItem nonItem; // for deleted items
	// -------------------------------------------------------------

	public HashTable(int size) // constructor
	{
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1, "null"); // deleted item key is -1
	}

	// -------------------------------------------------------------
	public void displayTable() {
		System.out.println("Table: ");
		for (int j = 0; j < arraySize; j++) {
			if (hashArray[j] != null)
				System.out.println("Index : " + j + " " + hashArray[j].getKey() + " " + hashArray[j].getValue());
			else
				System.out.println("Index : " + j + " " + "**");
		}
		System.out.println("");
	}

	// -------------------------------------------------------------
	public int hashFunc(int key) {
		return key % arraySize; // hash function
	}

	// -------------------------------------------------------------
	public void insert(int key, String v) // insert a DataItem
	// (assumes table not full)
	{
		// extract key
		int hashVal = hashFunc(key); // hash the key
										// until empty cell
		// an index have some data and not match with existing key, it find next
		// vacant position
		while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != key) {
			++hashVal; // go to next cell
			hashVal %= arraySize; // wraparound if necessary
		}
		DataItem obj = new DataItem(key, v);
		hashArray[hashVal] = obj; // insert item
	} // end insert()
	// -------------------------------------------------------------

	public DataItem delete(int key) // delete a DataItem
	{
		int hashVal = hashFunc(key); // hash the key

		while (hashArray[hashVal] != null) // until empty cell,
		{ // found the key?
			if (hashArray[hashVal].getKey() == key) {
				DataItem temp = hashArray[hashVal]; // save item
				hashArray[hashVal] = nonItem; // delete item
				return temp; // return item
			}
			++hashVal; // go to next cell
			hashVal %= arraySize; // wraparound if necessary
		}
		return null; // can't find item
	} // end delete()
	// -------------------------------------------------------------

	public boolean find(int key) // find item with key
	{
		int hashVal = hashFunc(key); // hash the key

		while (hashArray[hashVal] != null) // until empty cell,
		{ // found the key?
			if (hashArray[hashVal].getKey() == key)
				return true; // yes, return item
			++hashVal; // go to next cell
			hashVal %= arraySize; // wraparound if necessary
		}
		return false; // can't find item
	}
	// -------------------------------------------------------------
} // end class HashTable
	////////////////////////////////////////////////////////////////

