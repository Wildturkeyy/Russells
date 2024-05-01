package day0501.stream.stream2.ex;

import java.util.Arrays;
import java.util.List;

public class PeekStream {
    public static void main(String[] args) {

        Shape s1 = new Rectangle(10, 3);
        Shape s2 = new Rectangle(20, 2);
        List<Shape> listS = Arrays.asList(s1, s2);
        listS.parallelStream().mapToDouble(a -> a.area()).peek(a-> System.out.println(a)).sum(); //출력 안됨 >최종처리 메서드가 호출되어야만 동작

        //스트림 내부의 요소들이 특정 조건을 마족하는 검사할 수 있는 메서드
        boolean result = listS.stream().allMatch(a -> (a instanceof Shape));
        System.out.println("모든 요소는 Shape의 객체이다: " + result);

        result = listS.stream().anyMatch(a -> (a instanceof Shape));
        System.out.println("모든 요소 중 하나 이상이 Shape 객체이다: " + result);

        result = listS.stream().noneMatch(a -> (a instanceof Shape));
        System.out.println("모든 요소가 Shape 객체가 아니다: " + result);
    }

}
