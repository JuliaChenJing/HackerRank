package datastructure.hashtable;

import java.util.*;
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