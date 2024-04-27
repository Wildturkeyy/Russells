package day0425.ch17.ex3.gTest.none;

public class NoneGenericTest{
	public static void main(String[] args) {
		var blackBox = new Box();
		blackBox.set(new Apple());
		
		Object content = blackBox.get();
		System.out.println(((Apple)content).getName());
		
		blackBox.set(new Tigger());
		Object content2 = blackBox.get();
		//exception 발생
		//ClassCastException
		System.out.println(((Apple)content2).getName());
	}
}




class Box {
	private Object obj;
	
	public void set(Object obj) {
		this.obj = obj;
	}
	
	public Object get() {
		return this.obj;
	}
}

class Apple{
	public String getName() {
		return "사과";
	}
	
}

class Tigger{
	public String sleep() {
		System.out.println("호랑이가 드르렁 거리면서 잠");
		return "호랑이가 으르렁 거리면서 잠";
	}
}