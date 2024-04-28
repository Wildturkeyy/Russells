package day0426.ch24.ex1;

public class Box<T extends Person> {
	private T data;
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
}
