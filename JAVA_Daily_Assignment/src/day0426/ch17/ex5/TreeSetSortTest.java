package day0426.ch17.ex5;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetSortTest {
    public static void main(String[] args) {

        TreeSet<Student> treeset = new TreeSet<>();
        treeset.add(new Student("홍길동", 3, 90));
        treeset.add(new Student("차범근", 2, 70));
        treeset.add(new Student("손흥민", 2, 80));
        treeset.add(new Student("유현진", 3, 94));

        Iterator<Student> iter1 = treeset.descendingIterator();
        System.out.println("\n시험 점수순으로 이름 출력하기");
        System.out.println("----------------------------------");
        while (iter1.hasNext()){
            Student s = (Student) iter1.next();
            System.out.println(s.score + ", " + s.name);


        }
    }
}
