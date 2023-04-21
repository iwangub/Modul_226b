package patterns.strategy;

/**
 * Abstrakte Klasse für die Sortier-Strategie. Implementiert konkret nur die Methode
 * zur Messung der Laufzeit.
 *
 * @param <E> Parametrisierter Typ der Elemene, welche sortiert werden sollen.
 */
public abstract class AbstractSortStrategy<E extends Comparable<E>> implements SortStrategy<E> {
	@Override
	public abstract void sort(E[] elements);

	@Override
	public long measureRuntime(E[] elements) {
		long start = System.nanoTime();
		sort(elements);
		long stop = System.nanoTime();
		return stop - start;
	}
	
	final void swap(E[] elements, int x, int y) { 
		E z = elements[x];
		elements[x] = elements[y];
		elements[y] = z;
	}
}
