package patterns.strategy;

import java.util.Arrays;
import java.util.Random;

/**
 * Kunden Klasse, welche verschiedene Sortier-Strategien und Laufzeitberechnungen
 * durchführt.
 */
public class SortClient {
	private static final Random rnd;
	
	static {
		rnd = new Random();
	}
	
	/**
	 * Entrypoint Methode für die Durchführung verschiedener Sortier-Strategien und
	 * Laufzeitberechnungen.
	 * @param args Folge von ganzen Zahlen, welche sortiert werden soll (separiert durch einzelne Blanks).
	 */
	public static void main(String[] args) {
		SortStrategy<Integer> strategy = new HeapSortStrategy<Integer>();
		int size = args.length;
		Integer[] elements;
		if(args.length > 0) {
			elements = new Integer[size];
			for(int i=0;i<size;i++) {
				elements[i] = Integer.valueOf(args[i]);
			}
		}
		else {
			elements = generateRandomNumbers(10,1000);
		}
		
		System.out.println(Arrays.toString(elements));
		long nanos = strategy.measureRuntime(elements);
		System.out.println(Arrays.toString(elements));
		System.out.println(nanos);
	}
	
	private static Integer[] generateRandomNumbers(int nof, int max) {
		Integer[] elements = new Integer[nof];
		for(int i=0;i<nof;i++) {
			elements[i] = rnd.nextInt(0,max+1);
		}
		return elements;
	}
}
