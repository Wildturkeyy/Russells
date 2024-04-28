package day0425.ch17.ex3.gTest;

public class GenericTest {

	public static void main(String[] args) {
		var blackBox = new Box();
		blackBox.set(new Apple());
		
		Object content = blackBox.get();
		System.out.println(((Apple)content).getName());
		
		blackBox.set(new Tiger());
		Object content2 = blackBox.get();
		//exception 발생
		//ClassCastException
		System.out.println(((Apple)content2).getName());
		}
	}
