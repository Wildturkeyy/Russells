package day0501.ch26.ex1;

import java.util.stream.IntStream;

public class IntStreamRangeClosedTest {
    static int sum = 0;
    public static void main(String[] args) {
        //특정 정수 범위에서 스트림 얻기

        IntStream intStream1 = IntStream.range(0, 100); //100이 포함되지 않음
        IntStream intStream2 = IntStream.rangeClosed(0, 100); //100이 포함됨
        intStream1.forEach(i -> sum += i);
        System.out.println("총합 : " + sum);

        intStream2.forEach(i -> sum += i);
        System.out.println("총합 : " + sum);
    }
}
