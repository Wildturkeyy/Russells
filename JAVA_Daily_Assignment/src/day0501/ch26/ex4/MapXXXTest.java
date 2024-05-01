package day0501.ch26.ex4;

import java.util.ArrayList;
import java.util.List;

public class MapXXXTest {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("홍길동", 2, 70));
        studentList.add(new Student("이순신", 3, 80));
        studentList.add(new Student("박찬호", 1, 90));
        studentList.add(new Student("손흥민", 2, 100));
        studentList.add(new Student("차범근", 3, 77));
        studentList.add(new Student("임꺽정", 1, 88));

        studentList.stream()
                .mapToInt(Student::getScore)
                .forEach(System.out::println);
    }
}
