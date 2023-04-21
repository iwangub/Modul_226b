package patterns.strategy;

/**
 * Die Klasse <code>SortContext</code> erm�glicht es, die Sortier-Strategie 
 * w�hrend der Laufzeit dynamisch auszutauschen.
 *
 * @param <E> Typisierter Parameter der Elemente, welche sortiert werden sollen.
 */
public class SortContext <E extends Comparable<E>> {
	private SortStrategy<E> strategy;
	/**
	 * Konstruktor f�r den Sortier Kontext.
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
	 * F�hrt das Sortierverfahren der aktuell gesetzten 
	 * Sortier-Strategie aus.
	 * 
	 * @param elements Elemente, welche ausgef�hrt werden sollen.
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
