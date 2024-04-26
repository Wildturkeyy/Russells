package day0426.ch17.generics.bounded;

public class Apple implements Comparable<Apple> {

	private double weight;
	
	Apple(double weight){
		this.weight = weight;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
//	public int compareTo(Apple o) {
//		if (this.weight > o.weight) {
//			return 1;
//		}else if (this.weight == o.weight) {
//			return 0;
//		}else {
//			return -1;
//		}
//	}
	public int compareTo(Apple o) {
		var diff = this.weight - o.weight;
		
		if (diff>0) {
			return 1;
		}else if(diff==0) {
			return 0;
		}else {
			return -1;
		}
	}
	
	
	
}
