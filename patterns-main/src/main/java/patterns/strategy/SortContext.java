package patterns.strategy;

/**
 * Die Klasse <code>SortContext</code> ermöglicht es, die Sortier-Strategie 
 * während der Laufzeit dynamisch auszutauschen.
 *
 * @param <E> Typisierter Parameter der Elemente, welche sortiert werden sollen.
 */
public class SortContext <E extends Comparable<E>> {
	private SortStrategy<E> strategy;
	/**
	 * Konstruktor für den Sortier Kontext.
	 * 
	 * @param strategy Sortier-Strategie die aktuell verwendet werden soll.
	 */
	public SortContext(SortStrategy<E> strategy) {
		this.strategy = strategy;
	}

	/**
	 * Setzt die aktuelle Sortier-Strategie.
	 * @param strategy Sortier-Strategie, welche aktuell verwendet werden soll.
	 */
	public void setStrategy(SortStrategy<E> strategy) {
		this.strategy = strategy;
	}
	/**
	 * Führt das Sortierverfahren der aktuell gesetzten 
	 * Sortier-Strategie aus.
	 * 
	 * @param elements Elemente, welche ausgeführt werden sollen.
	 */
	public void sort(E[] elements) {
		strategy.sort(elements);
	}
	
	/**
	 * Misst das Laufzeitverhalten der aktuell gesetzten Sortier-Strategie.
	 * 
	 * @param elements Die zu sortierenden Elemente.
	 * @return Laufzeit in Nanosekunden.
	 */
	public long measureRuntime(E[] elements) {
		return strategy.measureRuntime(elements);
	}
}
