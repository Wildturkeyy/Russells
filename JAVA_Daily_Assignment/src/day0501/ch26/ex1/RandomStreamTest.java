package day0501.ch26.ex1;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class RandomStreamTest {
    public static void main(String[] args) {
        //랜덤 수에서 스트림 얻기
        IntStream intStream1 = new Random().ints(5);
        intStream1.forEach(System.out::println);
        System.out.println();

        IntStream intStream2 = new Random().ints(1, 50).limit(10);
        intStream2.forEach(s -> System.out.print(s + " "));
        System.out.println("\n");

        DoubleStream doubleStream1 = new Random().doubles(5);
        doubleStream1.forEach(System.out::println);
    }
}
