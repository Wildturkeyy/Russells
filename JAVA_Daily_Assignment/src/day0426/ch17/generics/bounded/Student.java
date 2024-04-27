package day0426.ch17.generics.bounded;

public class Student implements Comparable<Student>{
	
	private int score;
	
	Student(int score){
		this.score = score;
	}
	
	Student s1 = new Student(50);

	@Override
//	public int compareTo(Student o) {
//		
//		return 0;
//	}
//	
	public int compareTo(Student o) {
		return this.score - o.score;
	}
	
}
