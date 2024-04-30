package day0430.ch25.ex5;

import java.util.*;

public class ComparatorTest {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길동", 20));
        studentList.add(new Student("이순신", 14));
        studentList.add(new Student("차범근", 17));
        studentList.add(new Student("손흥민", 13));

        //정렬 전
        for (var  student : studentList) {
            System.out.println(student);
        }
        System.out.println();

        // 정렬
//        var comp1 = new Comparator<Student>(){
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        };
//        Collections.sort(studentList, comp1);
//        Comparator comparator = (o1, o2) -> ((Student) o1).getAge() - ((Student) o2).getAge();
//        Collections.sort(studentList, comparator);
        Comparator<Student> descOrder = (s1, s2) -> s2.getAge() - s1.getAge();
        Collections.sort(studentList, descOrder);

//        Collections.sort(studentList, (Student o1, Student o2) -> o1.getAge() - o2.getAge());

        // 정렬 후
        for (var student : studentList) {
            System.out.println(student.getName() + ", " + student.getAge());
        }

    }
}
