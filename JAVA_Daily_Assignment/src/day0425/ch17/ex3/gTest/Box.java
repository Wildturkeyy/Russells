package day0425.ch17.ex3.gTest;

public class Box<T> {
	private Object obj;
	
	public void set(Object obj) {
		this.obj = obj;
	}
	
	public Object get() {
		return this.obj;
	}
}