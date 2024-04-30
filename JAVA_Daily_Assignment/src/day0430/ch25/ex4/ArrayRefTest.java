package day0430.ch25.ex4;

@FunctionalInterface
interface MyFuncInterface3{
    int[] method(int len);
}

public class ArrayRefTest {
    public static void main(String[] args) {

        MyFuncInterface3 mfi1 = new MyFuncInterface3() {
            @Override
            public int[] method(int len) {
                return new int[len];
            }
        };

        int[] arr1 = mfi1.method(5);
        System.out.println("arr1.length: " + arr1.length);

        MyFuncInterface3 mfi2 = (len) -> new int[len];
        int[] arr2 = mfi2.method(10);
        System.out.println("arr2.length: " + arr2.length);

        MyFuncInterface3 mfi3 = int[]::new;
        int[] arr3 = mfi3.method(15);
        System.out.println("arr3.length: " + arr3.length);
    }
}
