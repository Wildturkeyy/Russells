package day0501.stream.stream1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntStreamEx {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Arrays.stream() 생성");
        IntStream intStream1 = Arrays.stream(arr);
        intStream1.forEach(i -> System.out.print(i + "\t"));
        System.out.println();

        System.out.println("IntStream.of() 생성");
        IntStream intStream2 = IntStream.of(arr);
        intStream2.forEach(i -> System.out.print(i + "\t"));
        System.out.println();

        System.out.println("IntStream.range(1, 6) 생성");
        IntStream intStream3 = IntStream.range(1, 6);
        intStream3.forEach(i -> System.out.print(i + "\t"));
        System.out.println();

        System.out.println("IntStream.rangeClosed(1, 5) 생성");
        IntStream intStream4 = IntStream.rangeClosed(1, 5);
        intStream4.forEach(i -> System.out.print(i + "\t"));
        System.out.println();

    }
}
