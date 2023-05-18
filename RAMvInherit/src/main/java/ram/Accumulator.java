package ram;

/**
 * Die Accumulator-Klasse implementiert die RAMComponent-Schnittstelle und
 * repräsentiert einen Akkumulator im RAM.
 */
public class Accumulator implements RAMComponent {
	private int data;

	/**
	 * Konstruktor für die Accumulator-Klasse.
	 */
	public Accumulator() {
	}

	/**
	 * Gibt den Wert des Akkumulators zurück.
	 *
	 * @return Der Wert des Akkumulators.
	 */
	public int get() {
		return data;
	}

	/**
	 * Lädt den angegebenen Wert in den Akkumulator.
	 *
	 * @param data Der zu ladende Wert.
	 */
	public void load(int data) {
		this.data = data;
	}

	/**
	 * Addiert den angegebenen Wert zum aktuellen Wert im Akkumulator.
	 *
	 * @param data Der zu addierende Wert.
	 */
	public void add(int data) {
		this.data += data;
	}

	/**
	 * Subtrahiert den angegebenen Wert vom aktuellen Wert im Akkumulator.
	 *
	 * @param data Der zu subtrahierende Wert.
	 */
	public void subtract(int data) {
		this.data -= data;
	}

	@Override
	public int read(int address) {
		throw new UnsupportedOperationException("Accumulator does not support read operation.");
	}

	@Override
	public void write(int address, int value) {
		throw new UnsupportedOperationException("Accumulator does not support write operation.");
	}

	@Override
	public int getMemorySize() {
		throw new UnsupportedOperationException("Accumulator does not have memory size.");
	}
}
