package datastructure.hashtable.courseAndTeachers;
import java.util.HashMap;
import java.util.Iterator;

public class CourseHashMap {

	public static void main(String [] args)
	{
		HashMap <String, Course> courseMap=new HashMap<String, Course> ();
		
		String[] s0={"Renuka", "Joe Lermon", "Paul"};
		Course c0=new Course ("FPP",s0) ;
		courseMap.put(   "CS390" ,  c0);
		
		String[] s1={"Mei Li", "Payman"};
		
		Course c1=new Course ("MPP", s1);
		courseMap.put("CS400" ,  c1);
		
		courseMap.containsKey("FPP");
		Iterator<String> iter = courseMap.keySet().iterator();
		
		System.out.println("Retrieve only the Keys");
		while (iter.hasNext()  )
		{
			System.out.println(iter.next());
		}
		
		
		System.out.println("\nRetrieve only values");
		Iterator iter1 = courseMap.keySet().iterator();
		while (iter1.hasNext()  )
		{
			System.out.println(courseMap.get(iter1.next()).toString());
		}
		
		System.out.println("\n the size of the HashMap:"+courseMap.size());
		 
	}
}

/*
Retrieve only the Keys
CS400
CS390

Retrieve only values
Course [c_name=MPP, faculty=[Mei Li, Payman]]
Course [c_name=FPP, faculty=[Renuka, Joe Lermon, Paul]]

 the size of the HashMap:2



 */
