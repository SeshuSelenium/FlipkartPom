package seleniumMaven.flipkartPOM;

import java.util.*;
public class AppTest 
   
{
	public static void main(String[] args)
	{
		String s = "chripi reddy seshu reddy chripi reddy sirisha reddy";
		
		String[] s1 = s.split(" ");
		Set <String> set = new HashSet<String>();
		for (int i = 0; i < s1.length; i++) {
			
			set.add(s1[i]);
		}
		
		
		
		
		
		System.out.println("removing duplicate elements forword ");
		for(String s3 : set) {
			System.out.println(s3);
		}
		
		List<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		for(Integer i : list) {
			System.out.println(i);
			
		}
		
		for (int i = list.size()-1; i >=0; i--) {
			System.out.println(list.get(i));
		}
		
	}
}
