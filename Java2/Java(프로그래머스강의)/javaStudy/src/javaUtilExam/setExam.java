package javaUtilExam;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class setExam {
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<>();
		boolean flag1 = set1.add("kang");
		boolean flag2 = set1.add("kim");
		boolean flag3 = set1.add("kang");
		
		System.out.println(set1.size());	//결과 2 출력 ( 중복 값 x ) 
		
		System.out.println(flag1); //true
		System.out.println(flag2); //true
		System.out.println(flag3); //false
		System.out.println("----------------------");
		Iterator<String> iter = set1.iterator(); //값을 순회해서 꺼내므로 while을 사용한다.
		while(iter.hasNext()) {
			String str = iter.next();
			System.out.println(str);
		}
		
		
	}
	
}
