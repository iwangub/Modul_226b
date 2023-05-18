package ram;

/**
 * Die Memory-Klasse implementiert die RAMComponent-Schnittstelle und
 * repräsentiert den Speicher im RAM.
 */
public class Memory implements RAMComponent {

	private int[] memory;

	/**
	 * Konstruktor für die Memory-Klasse.
	 *
	 * @param size Die Größe des Speichers.
	 */
	public Memory(int size) {
		memory = new int[size];
	}

	/**
	 * Schreibt den angegebenen Wert an die angegebene Adresse im Speicher.
	 *
	 * @param address Die Adresse, an der der Wert geschrieben werden soll.
	 * @param value   Der zu schreibende Wert.
	 */
	public void write(int address, int value) {
		memory[address] = value;
	}

	/**
	 * Liest den Wert an der angegebenen Adresse im Speicher.
	 *
	 * @param address Die Adresse, an der der Wert gelesen werden soll.
	 * @return Der gelesene Wert.
	 */
	public int read(int address) {
		return memory[address];
	}

	/**
	 * Gibt den gesamten Speicher aus.
	 */
	public void print() {
		for (int i = 0; i < memory.length; i++) {
			System.out.println("Address " + i + ": " + memory[i]);
		}
	}

	@Override
	public int getMemorySize() {
		return memory.length;
	}

}
