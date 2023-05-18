package ram;

/**
 * Das RAMComponent-Interface definiert die grundlegenden Methoden, die eine
 * RAM-Komponente implementieren muss.
 */
public interface RAMComponent {

	/**
	 * Liest den Wert an der angegebenen Adresse im RAM.
	 *
	 * @param address Die Adresse, an der der Wert gelesen werden soll.
	 * @return Der gelesene Wert.
	 */
	public int read(int address);

	/**
	 * Schreibt den angegebenen Wert an die angegebene Adresse im RAM.
	 *
	 * @param address Die Adresse, an der der Wert geschrieben werden soll.
	 * @param value   Der zu schreibende Wert.
	 */
	public void write(int address, int value);

	/**
	 * Gibt die Größe des RAMs zurück.
	 *
	 * @return Die Größe des RAMs.
	 */
	public int getMemorySize();

}
