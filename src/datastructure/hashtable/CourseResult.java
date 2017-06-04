package datastructure.hashtable;

import java.util.*;
/*
 *         将对象映射到其他对象的能力是一种解决编程问题的杀手锏。例如，考虑一个程序，它将用来检查Java的Random类的随机性。
 *         理想状态下，Random可以产生理想的数字分布，但是要想测试它，则需要生成大量的随机数，并对落入各种不同范围的数字进行计数。
 *         Map可以很容易地解决该问题。在本例中，键是由Random产生的数字，而值是该数字出现的次数。*/
public class CourseResult{
    public static void main(String[] args)
    {
          HashMap<String , Double> map = new HashMap<String , Double>();  
          Random rand=new Random(); //the use of Random()
          map.put("A开头" , 89.0); 
          map.put("语文" ,rand.nextDouble()*100 );  
          map.put("数学" , 89.0);   
          map.put("英语" , 78.2);          
       System.out.println(map.get("语文"));
       System.out.println(map);
       
       if(map.containsKey("英语"))
    	   System.out.println("英语成绩是"+map.get("英语"));
       
       if(map.containsValue(78.2))
    	   System.out.println("有科目得分78.2但是不能倒着查");
    }
}