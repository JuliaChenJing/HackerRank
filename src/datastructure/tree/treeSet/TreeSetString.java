package datastructure.tree.treeSet;
import java.util.TreeSet;

// Pre defined Tree set methods

public class TreeSetString {

	public static void main(String[] args) {
		
		
		 
		 TreeSet<String> ts = new TreeSet<String>();
	        ts.add("Java");
	        ts.add("Software Engineering");
	        ts.add("Visual Basic");
	        ts.add("Computer Graphics");
	        ts.remove("Java");
	        System.out.println("Elements: "+ts);
	        //check is set empty?
	        System.out.println("Is set empty: "+ts.isEmpty());
	        //delete all elements from set
	        ts.clear();
	        System.out.println("Is set empty: "+ts.isEmpty());
	        ts.add("Multimedia");
	        ts.add("Multimedia");
	        ts.add("Coral Draw");
	        ts.add("Adobe Photoshop");
	        System.out.println("Elements: "+ts);
	        System.out.println("Size of the set: "+ts.size());
	        ts.remove("Multimedia");
	        System.out.println("Elements: "+ts);
	}

}
/*
[10, 20, 25, 30]
Elements: [Computer Graphics, Software Engineering, Visual Basic]
Is set empty: false
Is set empty: true
Elements: [Adobe Photoshop, Coral Draw, Multimedia]
Size of the set: 3
Elements: [Adobe Photoshop, Coral Draw]
 */
