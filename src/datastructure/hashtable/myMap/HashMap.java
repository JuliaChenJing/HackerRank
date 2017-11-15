package datastructure.hashtable.myMap;

class HashMap {
    private final static int TABLE_SIZE = 127;
    HashEntry[] table;
    private int count = 0;

    HashMap() {
          table = new HashEntry[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
                table[i] = null;
    }
    public int get(int key) {
          int hash = (key % TABLE_SIZE);
          // Find the position of key until getting the exact match
          while (table[hash] != null && table[hash].getKey() != key)
                hash = (hash + 1) % TABLE_SIZE;
          if (table[hash] == null)
                return -1;
          else
                return table[hash].getValue();

    }
    public void put(int key, int value) {

          int hash = (key % TABLE_SIZE);
       // To check the index is occupied or not, if occupied it find the empty location
          while (table[hash] != null && table[hash].getKey() != key)

               hash = (hash + 1) % TABLE_SIZE;

          table[hash] = new HashEntry(key, value);
          count++;
          
    }
    public int size()
    {
   	 return count;
    }

}
