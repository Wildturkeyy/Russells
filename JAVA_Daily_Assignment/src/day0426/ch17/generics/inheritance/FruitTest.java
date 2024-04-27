package day0426.ch17.generics.inheritance;

import java.util.ArrayList;
import java.util.List;

public class FruitTest {

	public static void main(String[] args) {

		var apple = new Apple();
		var mango = new Mango();
		
		Box<Fruit> box1 = new Box<Fruit>();
		box1.set(apple);
		Fruit fruit = box1.get();
//		Apple fruit = (Apple)box1.get();
		fruit.whoAmI();
		
		box1.set(mango);
		fruit = box1.get();
		fruit.whoAmI();
//		fruit.whoLikesU();//Fruit로 받아서 호출 못함
		((Mango) fruit).whoLikesU();
		 
//		Box<Fruit> box2 = new Box<>();
		
		Box<Mango> box2 = new Box<>();
//		box2.set(new Fruit()); //box2는 Apple타입만 받을 수 있음 Fruit은 Apple보다는 상위클래스라 안됨
//		box2.set((Mango)new Fruit());
//		Mango mango1 = box2.get();
//		mango1.whoAmI();
//		mango1.whoLikesU(); //컴파일 상에서는 문제가 없지만 에러 발생
		
		box2.set(mango);
		Mango mango2 = box2.get();
		mango2.whoAmI();
		mango2.whoLikesU();
		
		// 과일하고 망고는 상속관계이지만
		// 과일 박스와 망고 박스는 상속관계가 아닌 별도의 타입
		
//		Box<Fruit> fbox = new Box<Apple>;//안됨 제네릭을 봐야함.
//		Box<Student> sBox = new Box<>(); //T extends Fruit되어 있어서 컴파일 에러
		
		List<String> list = new ArrayList<String>();
		List<Fruit> list1 = new ArrayList<Fruit>(); //같으면 문제 ㅇ벗지만
//		List<Fruit> list2 = new ArrayList<Mango>(); // 상속관계가 아니므로 안됨
		List<String> list3 = new ArrayList<>();
		
	}

}
