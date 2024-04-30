package day0430.ch25.ex5;

import java.util.function.*;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> consumer = name -> System.out.println("이름: " + name);
        consumer.accept("홍길동");

        IntConsumer intConsumer = grade -> System.out.println("학년: " + grade);
        intConsumer.accept(3);

        LongConsumer longConsumer = age -> System.out.println("나이: " + age);
        longConsumer.accept(20L);

        DoubleConsumer doubleConsumer = height -> System.out.println("키: " + height);
        doubleConsumer.accept(178.8);

        System.out.println();
        BiConsumer<String, Integer> biConsumer = (name, age) -> System.out.println("이름: " + name + ", 나이: " + age );
        biConsumer.accept("이순신", 23);
    }
}
