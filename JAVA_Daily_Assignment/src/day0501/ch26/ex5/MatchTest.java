package day0501.ch26.ex5;

import java.util.Arrays;

public class MatchTest {
    public static void main(String[] args) {
        //매칭 메서드 이용하기
        int[] scoreArr = {55, 66, 77, 88, 99};
        boolean result;

        result = Arrays.stream(scoreArr).allMatch(a->a<100);
        System.out.println(result);

        result = Arrays.stream(scoreArr).anyMatch(a -> a>100);
        System.out.println(result);

        result = Arrays.stream(scoreArr).noneMatch(a -> a>100);
        System.out.println(result);
    }
}
