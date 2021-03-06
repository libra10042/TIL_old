package javaUtilExam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		
		map.put("1", "kim");
		map.put("2", "lee");
		map.put("3", "hong");
		
		map.put("1", "kang");
		
		System.out.println(map.size());
		
		
		System.out.println(map.get("1"));  //kang
										  // 같은 값이 들어오면 기존 값을 새값으로 변경한다.
		
		System.out.println(map.get("2"));
		
		//KeySet 키들의 집합을 뽑는다.
		Set<String> keys = map.keySet();

		
		Iterator<String> iter =keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			String value = map.get(key);
			System.out.println("key 값 :" + key +  ", value 값 " +  value);
			
		}
		
		
		
	}
}
