package datastructure.hashtable.myMap;

public class DriverClass {

	public static void main(String[] args) 
	{
   
		HashMap hm = new HashMap();
   
		hm.put(1, 20);
   
		hm.put(2, 30);
    
		hm.put(5, 50);
      
		System.out.println("Value for the Key 1: " +hm.get(1));
  
		System.out.println("Value for the Key 5: " +hm.get(5));
   
		System.out.println("Size : " + hm.size());
    }
}

/*
Value for the Key 1: 20
Value for the Key 5: 50
Size : 3
 */
