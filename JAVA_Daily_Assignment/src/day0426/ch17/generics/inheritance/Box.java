package day0426.ch17.generics.inheritance;

public class Box<T extends Fruit> {
	
	
	
	private T obj;
	
	public void set(T obj) {
		this.obj = obj;
	}
	
	public T get() {
		return obj;
	}
}
