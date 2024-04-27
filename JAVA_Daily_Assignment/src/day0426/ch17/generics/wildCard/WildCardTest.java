package day0426.ch17.generics.wildCard;

public class WildCardTest {
	public static void main(String[] args) {
		Box<Fruit> fbox = new Box<>();
		
		Apple apple = new Apple();
		fbox.set(apple);
		
		openBeox(fbox);
		 
	}
	
	
	void printCount() {
		
	}
	
	void openBox(Box<Fruit> box) {
		System.out.println(box.get());
	}
}

