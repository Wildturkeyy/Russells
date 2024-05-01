package day0501.ch26.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipelineTest {
    public static void main(String[] args) {
        //스트림 파이프라인
        List<Student> students = new ArrayList<>();
        students.add(new Student("홍길동", 2, 70));
        students.add(new Student("이순신", 2, 80));
        students.add(new Student("박찬호", 1, 90));
        students.add(new Student("손흥민", 2, 100));
        students.add(new Student("차범근", 3, 77));
        students.add(new Student("임꺽정", 1, 88));

        Stream<Student> stdStream = students.stream();
        Stream<Student> gradeStream = stdStream.filter(s->s.getAge() == 2);
        IntStream scoreStream = gradeStream.mapToInt(Student::getScore);

        OptionalDouble optionalDouble = scoreStream.average();
        double avgScore1 = optionalDouble.getAsDouble();
        System.out.println("2학년 평균 점수: " + avgScore1);

        double avgScore2 = students.stream()
                .filter(s->s.getAge() == 3)
                .mapToInt(Student::getScore)
                .average()
                .getAsDouble();

        System.out.println("3학년 평균: " + avgScore2);

    }
}
