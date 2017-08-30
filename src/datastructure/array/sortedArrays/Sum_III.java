package datastructure.array.sortedArrays;

import java.util.*;

/*
 * 设计一个类，包�?�如下两个�?员函数：
   Save（int input）：�?�入一个整数到一个整数集�?�里
    Test(int target)：检验是�?�存在两个数和为输出值。如果存在这两个数，则返回true；�?�则返回false
    
      �??问 :在这个整数集�?�里是�?��?许有相�?�值的元素？
      �?许。
    
     �?考
      这�?��?�试题是“两个数之和�?的�?�体，但必须注�?的是，整数集�?�里的数是�?�能有�?�?的。
      如果Test函数的输入值target为集�?�里�?个数的两�?，我们该如何判断呢？在“两数之和II�?的哈希表里存放<值，下标>，
      而在这里就需�?改�?�为记录�?个数出现的次数，在哈希表里存放 <值，个数>。如果�?数两�?为target值，
      那么�?�有该数出现两次或两次以上，�?能返回true。
 */
public class Sum_III {

	// 哈希表hm初始化
	static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

	public static void main(String[] args) {

		hm.put(1, 1);
		hm.put(2, 1);
		hm.put(3, 1);
		save(4);
		int sum = 7;
		if (test(sum))
			System.out.println("存在两数之和等于" + sum);
	}

	// 以下函数实现插入一个整数到一个整数集合里
	public static void save(int input) {
		int originalCount = 0;
		if (hm.containsKey(input)) {// 如果input的这个值已经在哈希表中了
			// 则读取该key的个数
			originalCount = hm.get(input);// get() 的作用是获取key对应的value
		}
		hm.put(input, originalCount + 1);// 将这个新整数插入这个哈希表
	}

	// 以下函数检验是否存在两个数和为输出值
	public static boolean test(int target) {
		boolean re = false;

		// 将哈希表的key值存入迭代器
		Iterator<Integer> it = hm.keySet().iterator(); // iterator=迭代器

		while (it.hasNext()) {
			int val = it.next();
			if (hm.containsKey(target - val))// 如果哈希表里存在两个数之和为输出值
			{
				boolean isDouble = (target == val * 2);// target是否等于两倍的某key
				// 如果某数两倍为target值，那么只有该数出现两次或两次以上，才能返回true
				if (isDouble == false)
					re = true;
				if ((isDouble == true) && (hm.get(val) >= 2))
					re = true;
			}
		}
		return re;
	}
}
