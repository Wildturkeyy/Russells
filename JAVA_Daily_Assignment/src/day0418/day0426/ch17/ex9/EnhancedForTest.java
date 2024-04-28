package day0426.ch17.ex9;

import java.util.List;

public class EnhancedForTest {

	public static void main(String[] args) {
		
		String[] strings = {"world", "hello", "love", "victory", "truth"};
		for (int i=0; i<strings.length; i++) {
			System.out.println(strings[i]);
		}
		System.out.println();
		
		var iter = List.of(strings).iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		for (String str: strings) {
			System.out.println(str);
		}
	}

}
