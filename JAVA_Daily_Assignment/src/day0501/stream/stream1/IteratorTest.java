package day0501.stream.stream1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {

        List <String> list = Arrays.asList(new String[] {"홍길동" , "김유신", "이순신" , "유관순"});

        System.out.println("for문 이용");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();

        System.out.println("외부 반복자 이용");
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println();

        System.out.println("내부 반복자 이용");
        list.stream().forEach(s -> System.out.println(s));
    }
}
