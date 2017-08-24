package pramp.strings;

import java.util.*;

public class WordCountEngine {

	public static void main(String[] args) {
		String str = "Practice makes perfect, but practice is tiring.";

		wordCountEngine(str);
		

	}

	static void wordCountEngine(String document) {
	
		document.toLowerCase();

		String[] splitedStrings = document.toLowerCase().replace(",", "").replace(".", "").split(" ");

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		PriorityQueue<KeyValuePair> queue = new PriorityQueue<KeyValuePair>();
		for (String s : splitedStrings) {
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}
	     System.out.println("-----------------HashMap--------------\n"+map);
	     
        List< KeyValuePair> list = new ArrayList< KeyValuePair>();
        for( String key : map.keySet() ) {
            list.add( new  KeyValuePair( key, map.get(key) ) );
        }
        Collections.sort(list);
        System.out.println("-----------------List--------------\n"+list);
        
		
		for (String key : map.keySet()) {
			queue.add(new KeyValuePair(key, map.get(key)));
		}
		System.out.println("-----------------PriorityQueue--------------\n"+queue);
		
		String[][] results = new String[queue.size()][2];
		int index = 0;
		while (!queue.isEmpty()) {
			results[index][0] = queue.poll().getKey();
			results[index][1] = KeyValuePair.getValueToString(queue.poll().getValue());
			index++;
		}
		System.out.println("-----------------String [][]--------------\n"+queue);
		for(int i=0;i<results.length;i++)
			System.out.println(results[i][0]+":"+results[i][1]);

	}

}

class KeyValuePair implements Comparable<KeyValuePair> {
	private String key;
	private int value;

	KeyValuePair(String key, int value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public int getValue() {
		return value;
	}

	static String getValueToString(int n) {
		String[] numbers = { "0", "1", "2", "3" };
		return numbers[n];
	}

	@Override
	public int compareTo(KeyValuePair that) {
		return that.value - this.value;
	}
	
	@Override
	public String toString(){
		return "\n"+key+":"+value;
	}
}
