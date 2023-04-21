package patterns.strategy;

/**
 * Schnittstellenbeschreibung der Methoden f�r die Sortier-Strategie.
 * Neben der eigentlichen Sortier-Methode wird noch eine zus�tzliche
 * Methode f�r die Laufzeit-Messung des Sortierverfahrens definiert.
 *
 * @param <E> Parametrisierter Typ der Elemente, welche sortiert werden sollen.
 */
public interface SortStrategy<E> {
	/**
	 * Sortiert einen Array von Elementen aufsteigend.
	 * @param elements Elemente, welche sortiert werden.
	 */
	void sort(E[] elements);
	/**
	 * Misst die Laufzeit f�r die Sortierung der Elemente-
	 * @param elements Elemente, welche sortiert werden.
	 * @return Laufzeit in Nanosekunden.
	 */
	long measureRuntime(E[] elements);
}
