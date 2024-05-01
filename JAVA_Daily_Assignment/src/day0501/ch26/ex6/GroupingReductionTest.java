package day0501.ch26.ex6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingReductionTest {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길순", 2, 70, Student.FEMALE));
        studentList.add(new Student("이순신", 3, 80, Student.MALE));
        studentList.add(new Student("박세리", 1, 90, Student.FEMALE));
        studentList.add(new Student("손흥민", 2, 100, Student.MALE));
        studentList.add(new Student("김연아", 3, 100, Student.FEMALE));
        studentList.add(new Student("류현진", 1, 78, Student.MALE));
        studentList.add(new Student("차범근", 1, 77, Student.MALE));

        //
        Map<Integer, Double> mapByGender1 = studentList.stream()
                .collect(Collectors.groupingBy(
                        Student::getGender,
                        Collectors.averagingDouble(Student::getScore)
                ));

        double maleAvg = mapByGender1.get(Student.MALE);
        System.out.println("남학생 평균: " + maleAvg);

        double femaleAvg = mapByGender1.get(Student.FEMALE);
        System.out.println("여학생 평균: " + femaleAvg);

        Map<Integer, Long> mapByGender2 = studentList.stream()
                .collect(
                      Collectors.groupingBy(Student::getGender,
                              Collectors.counting())
                );
        long maleCnt = mapByGender2.get(Student.MALE);
        long femaleCnt = mapByGender2.get(Student.FEMALE);
        System.out.println("남학생 수: " + maleCnt);
        System.out.println("여학생 수: " + femaleCnt);
    }
}
