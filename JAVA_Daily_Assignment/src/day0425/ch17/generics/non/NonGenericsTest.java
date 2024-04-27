package day0425.ch17.generics.non;

import day0425.ch17.generics.Apple;
import day0425.ch17.generics.Tiger;

public class NonGenericsTest {

	public static void main(String[] args) {
		var blackBox = new Box();
		
		blackBox.set(new Apple());
		Object content = blackBox.get();
		System.out.println(((Apple) content).getName());		
		
		blackBox.set(new Tiger());
		Object content2 = blackBox.get();
		System.out.println(((Apple) content2).getName());
	}

}

class Box {
	private Object object;
	
	public void set(Object object) {
		this.object = object;
	}
	public Object get() {
		return object;
	}
}


