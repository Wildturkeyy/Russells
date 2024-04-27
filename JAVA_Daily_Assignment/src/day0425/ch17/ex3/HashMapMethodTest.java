package day0425.ch17.ex3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapMethodTest {

	public static void main(String[] args) {
		Map map = new HashMap();
		
		//객체 저장하기
		map.put(1, Integer.valueOf(100));
		map.put(2, Float.valueOf(3.5F));
		map.put("second", "hello");
		map.put("third", new Student());
		
		//객체 개수 얻기
		System.out.println(map.size());
		
		//객체 출력하기
		Integer num = (Integer)map.get(1); //다운캐스팅을 하지 않으면 에러발생
		String str = (String)map.get("second");
		System.out.println(num);
		System.out.println(str);
		
		Student st = (Student)map.get("third");
		System.out.println(st);
		
		System.out.println();
		System.out.println();
		
		System.out.println(map.get("third"));
		System.out.println(map.get("fourth")); //key값이 없으면  null반환
		
		//객체 수정하기
		System.out.println(map.toString());
		System.out.println();
		
		map.replace(1, Integer.valueOf(500));
		map.replace(2, "자바프로그래밍");
		map.replace("second", Double.valueOf(5.5));
		System.out.println(map.toString());
		System.out.println();
		
		//keySet 얻기
		Set keySet = map.keySet();
		System.out.println(keySet.toString());
		System.out.println();
		
		//entrySet 얻기
		Set entrySet = map.entrySet();
		System.out.println(entrySet.toString());
		
		//Collection
		Collection valueCol = map.values();
		System.out.println(valueCol.toString());
		System.out.println();
		
		//객체 제거하기
		System.out.println(map.toString());
		map.remove(1);
		System.out.println(map.toString());
		System.out.println(map.keySet().toString());
		System.out.println(map.values().toString());
		
		//모든 객체 제거
		map.clear();
		System.out.println(map.toString());
	}

}
