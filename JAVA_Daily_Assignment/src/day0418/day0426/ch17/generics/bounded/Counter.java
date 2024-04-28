package day0426.ch17.generics.bounded;

public class Counter {
	
	public static <T extends Comparable<T>> int countGreaterThan(T[] array, T elem) {
		int count = 0;
		for (T e: array) {
			if (e.compareTo(elem) > 0) {
				count++;
			}
		}
		return 0;
	}
}
