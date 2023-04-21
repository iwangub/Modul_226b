package collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Aufgabe3 {

	public static Integer[] eliminateDublicates(List<Integer> l) {

		HashSet<Integer> set = new HashSet<Integer>(l);
		Integer[] array = set.toArray(new Integer[set.size()]);
		return array;
	}

	public static void main(String[] args) {
		int[] myArray = { 1, 2, 3, 3 };
		System.out.println(Arrays.toString(myArray));

		Integer[] myArray2 = { 1, 2, 3, 3 };
		System.out.println(Arrays.toString(myArray2));

		int[] arrayResult = new int[15];
		arrayResult[0] = 1;

		System.out.println(Arrays.toString(arrayResult));

		System.out.println(arrayResult.length);
	}

}
