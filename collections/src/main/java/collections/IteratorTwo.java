package collections;

import java.util.ArrayList;

public interface IteratorTwo {
	public static int sum(Iterable<Integer> iterable) {

		int result = 0;
		for (int number : iterable) {
			result += number;
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> myArray = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			myArray.add(i);
		}

		System.out.println(myArray);
		System.out.println(sum(myArray));

	}
}
