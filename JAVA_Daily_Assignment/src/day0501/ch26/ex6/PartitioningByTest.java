package day0501.ch26.ex6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningByTest {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길순", 2, 70, Student.FEMALE));
        studentList.add(new Student("이순신", 3, 80, Student.MALE));
        studentList.add(new Student("박세리", 1, 90, Student.FEMALE));
        studentList.add(new Student("손흥민", 2, 100, Student.MALE));
        studentList.add(new Student("김연아", 3, 100, Student.FEMALE));
        studentList.add(new Student("류현진", 1, 78, Student.MALE));

        Map<Boolean, List<Student>> stdBygender = studentList.stream()
                .collect(Collectors.partitioningBy(s -> s.getGender() == Student.MALE));
        List<Student> studentMale = stdBygender.get(true);
        List<Student> studentFemale = stdBygender.get(false);

        studentMale.forEach(s -> System.out.println(s.toString()));
        System.out.println();
        studentFemale.forEach(s -> System.out.println(s.toString()));
    }
}
