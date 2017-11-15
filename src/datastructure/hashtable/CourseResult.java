package datastructure.hashtable;

import java.util.*;

/*
 *         将对象映射到其他对象的能力是一�?解决编程问题的�?�手�?。例如，考虑一个程�?，它将用�?�检查Java的Random类的�?机性。
 *         �?�想状�?下，Random�?�以产生�?�想的数字分布，但是�?想测试它，则需�?生�?大�?的�?机数，并对�?�入�?��?�?�?�范围的数字进行计数。
 *         Map�?�以很容易地解决该问题。在本例中，键是由Random产生的数字，而值是该数字出现的次数。*/
public class CourseResult {
	public static void main(String[] args) {
		HashMap<String, Double> map = new HashMap<String, Double>();
		Random rand = new Random(); // the use of Random()
		map.put("A开头", 89.0);
		map.put("语文", rand.nextDouble() * 100);
		map.put("数学", 89.0);
		map.put("英语", 78.2);
		System.out.println(map.get("语文"));
		System.out.println(map);

		if (map.containsKey("英语"))
			System.out.println("英语�?绩是" + map.get("英语"));

		if (map.containsValue(78.2))
			System.out.println("有科目得分78.2但是�?能倒�?�查");
	}
}