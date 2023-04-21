package patterns.strategy;

import java.util.Arrays;

/**
 * Klasse, welche die Sortier-Strategie MergeSort implementiert.
 * Laufzeitverhalten des Sortierverfahrens ist O(n*log(n)).
 * 
 * @param <E> Typisierter Paramenter der Elemente, welche sortiert werden
 *            sollen.
 */
public class MergeSortStrategy<E extends Comparable<E>> extends AbstractSortStrategy<E> {

	@Override
	public void sort(E[] elements) {
		sort(elements, 0, elements.length - 1);
	}

	private void sort(E[] elements, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			sort(elements, low, middle);
			sort(elements, middle + 1, high);
			merge(elements, low, middle, high);
		}
	}
	
	private void merge(E[] elements, int low, int middle, int high) {
        E[] temp = Arrays.copyOf(elements, elements.length);
        int i = low;
        int j = middle+1;
        int k = low;
        while (i <= middle && j <= high) {
            if (temp[i].compareTo(temp[j]) <= 0) {
                elements[k] = temp[i];
                i++;
            } else {
                elements[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            elements[k] = temp[i];
            i++;
            k++;
        }
    }
}
