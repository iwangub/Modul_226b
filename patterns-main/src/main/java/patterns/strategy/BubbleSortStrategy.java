package patterns.strategy;

import java.util.Arrays;

/**
 * Klasse, welche Sortier Strategie BubbleSort implementiert.
 * Laufzeitverhalten des Sortierverfahrens ist O(n^2). Algorithmus
 * braucht n Schritte falls Input Sequenz bereits aufsteigend sortiert ist.
 * 
 * @param <E> Typisierter Paramenter der Elemente, welche sortiert werden sollen.
 */
public class BubbleSortStrategy<E extends Comparable<E>> extends AbstractSortStrategy<E> {

	@Override
	public void sort(E[] elements) {
		for(int i=0;i<elements.length-1;i++) {
			boolean swap = false;
			for(int j=0;j<elements.length-1-i;j++) {
				if (elements[j].compareTo(elements[j+1])>0) {
					swap(elements,j,j+1);
					swap = true;
					System.out.println(Arrays.toString(elements));
				}
			}
			if (!swap) {
				break;
			}
		}
	}
}

