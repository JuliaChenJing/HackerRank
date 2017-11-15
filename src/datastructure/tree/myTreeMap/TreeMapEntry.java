package datastructure.tree.myTreeMap;

class TreeMapEntry {
	 
	    int key;
	    String name;
	 
	    TreeMapEntry leftChild;
	    TreeMapEntry rightChild;
	 
	    TreeMapEntry(int key, String name) {
	 
	        this.key = key;
	        this.name = name;
	 
	}
	 
	    public String toString() {
	 
	        return name + " has the key " + key;
	         
	    }
	 
	}
