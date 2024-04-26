package day0425.ch17.generics.gen;

import day0425.ch17.generics.Apple;
import day0425.ch17.generics.Tiger;

public class GenericsTest {

	public static void main(String[] args) {
		Box<Apple> appleBox = new Box<Apple>();		
		appleBox.set(new Apple());
		Apple content = appleBox.get();
		System.out.println(content.getName());
		
		Box<Tiger> tigerBox = new Box<Tiger>();
		tigerBox.set(new Tiger());
		Tiger content2 = tigerBox.get();
		content2.sleep();
	
	}

}

class Box<T> {
	private T object;
	
	public void set(T object) {
		this.object = object;
	}
	public T get() {
		return object;
	}
}
