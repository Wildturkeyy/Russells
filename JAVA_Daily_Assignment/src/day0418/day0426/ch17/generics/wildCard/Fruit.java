package day0426.ch17.generics.wildCard;

public class Fruit {
	
	public void whoAmI() {
		System.out.println("나는 과일");
	}
}

class Apple extends Fruit{
	@Override
	public void whoAmI() {
		System.out.println("나는 사과");
	}
	
}

class Mango extends Fruit{
	public void whoLikesU() {
		System.out.println("김경민");
	}
}
