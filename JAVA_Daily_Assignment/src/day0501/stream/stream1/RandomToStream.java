package day0501.stream.stream1;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class RandomToStream {
    public static void main(String[] args) {

        System.out.println("int형 난수 스티림");
        IntStream isr = new Random().ints(3);
        isr.forEach(i-> System.out.print(i + " "));
        System.out.println();

        isr = new Random().ints(10, 0, 3);
        isr.forEach(i-> System.out.print(i + " "));
        System.out.println();

        System.out.println("long형 난수 스트림");
        LongStream lsr = new Random().longs(3);
        lsr.forEach(l -> System.out.print(l + " "));
        System.out.println();

        System.out.println("double형 난수 스트림");
        DoubleStream dsr = new Random().doubles(3);
        dsr.forEach(d -> System.out.print(d + " "));
    }
}
