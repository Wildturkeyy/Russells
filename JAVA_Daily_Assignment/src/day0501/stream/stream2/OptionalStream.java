package day0501.stream.stream2;

import java.util.Arrays;
import java.util.OptionalInt;

public class OptionalStream {
    public static void main(String[] args) {

        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }

        long cnt = Arrays.stream(arr).count();
        System.out.println(cnt);

        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);

        System.out.println("요소들 중 첫 번째 값");
        OptionalInt firstN = Arrays.stream(arr).findFirst();
        int first = firstN.getAsInt();
        System.out.println(first);
    }
}
