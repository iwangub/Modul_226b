package ram;

/**
 * Die ControllerUnit-Klasse repräsentiert die Steuereinheit des Systems und
 * koordiniert die Aktionen von Memory, Accumulator und Program.
 */
public class ControllerUnit {

	private RAMComponent memory;
	private Accumulator accumulator;
	private int programCounter;

	/**
	 * Konstruktor für die ControllerUnit-Klasse.
	 *
	 * @param memory      Das RAM-Objekt.
	 * @param accumulator Der Akkumulator.
	 */
	public ControllerUnit(RAMComponent memory, Accumulator accumulator) {
		this.memory = memory;
		this.accumulator = accumulator;
		this.programCounter = 0;
	}

	/**
	 * Lädt den Wert an der angegebenen Adresse in den Akkumulator.
	 *
	 * @param address Die Adresse, von der der Wert geladen werden soll.
	 */
	/*
	 * public void lda(int address) { accumulator.load(memory.read(address));
	 * programCounter++; }
	 */
	public void lda(int address) {
		int value = memory.read(address);
		accumulator.load(value);
		programCounter++;
	}

	/**
	 * Lädt den Wert an der indirekt angegebenen Adresse in den Akkumulator.
	 *
	 * @param address Die Adresse, die den indirekten Speicherort enthält.
	 */
	public void ldi(int address) {
		int indirectAddress = memory.read(address);
		accumulator.load(memory.read(indirectAddress));
		programCounter++;
	}

	/**
	 * Schreibt den Wert im Akkumulator an die angegebene Adresse.
	 *
	 * @param address Die Adresse, an die der Wert geschrieben werden soll.
	 */
	public void sta(int address) {
		memory.write(address, accumulator.get());
		programCounter++;
	}

	/**
	 * Schreibt den Wert im Akkumulator an die indirekt angegebene Adresse.
	 *
	 * @param address Die Adresse, die den indirekten Speicherort enthält.
	 */
	public void sti(int address) {
		int indirectAddress = memory.read(address);
		memory.write(indirectAddress, accumulator.get());
		programCounter++;
	}

	/**
	 * Addiert den Wert an der angegebenen Adresse zum Wert im Akkumulator.
	 *
	 * @param address Die Adresse, von der der Wert gelesen werden soll.
	 */
	public void add(int address) {
		accumulator.add(memory.read(address));
		programCounter++;
	}

	/**
	 * Subtrahiert den Wert an der angegebenen Adresse vom Wert im Akkumulator.
	 *
	 * @param address Die Adresse, von der der Wert gelesen werden soll.
	 */
	public void sub(int address) {
		accumulator.subtract(memory.read(address));
		programCounter++;
	}

	/**
	 * Springt zur angegebenen Adresse.
	 *
	 * @param address Die Adresse, zu der gesprungen werden soll.
	 */
	public void jmp(int address) {
		programCounter = address;
	}

	/**
	 * Springt zur angegebenen Adresse, wenn der Wert im Akkumulator gleich null
	 * ist.
	 *
	 * @param address Die Adresse, zu der gesprungen werden soll.
	 */
	public void jmz(int address) {
		if (accumulator.get() == 0) {
			programCounter = address;
		} else {
			programCounter++;
		}
	}

	/**
	 * Gibt den aktuellen Wert des Program Counters zurück.
	 *
	 * @return Der aktuelle Wert des Program Counters.
	 */
	public int getProgramCounter() {
		// System.out.println(programCounter);
		return programCounter;
	}

	/**
	 * Stoppt die Ausführung des Programms.
	 */
	public void hlt() {
		programCounter = -1;
	}

	/**
	 * Führt den Befehl mit dem angegebenen Kommando und Operanden aus.
	 *
	 * @param cmd     Das Kommando des Befehls.
	 * @param operand Der Operand des Befehls.
	 */
	public void run(String cmd, int operand) {

		switch (cmd) {
		case "LDA":
			// Überprüfen, ob der Operand eine gültige Adresse ist
			if (operand < 0 || operand >= memory.getMemorySize()) {
				throw new IllegalArgumentException("Ungültige Speicheradresse: " + operand);
			}
			lda(operand);
			break;
		case "LDI":
			// Überprüfen, ob der Operand eine gültige Adresse ist
			if (operand < 0 || operand >= memory.getMemorySize()) {
				throw new IllegalArgumentException("Ungültige Speicheradresse: " + operand);
			}
			ldi(operand);
			break;
		case "STA":
			// Überprüfen, ob der Operand eine gültige Adresse ist
			if (operand < 0 || operand >= memory.getMemorySize()) {
				throw new IllegalArgumentException("Ungültige Speicheradresse: " + operand);
			}
			sta(operand);
			break;
		case "STI":
			// Überprüfen, ob der Operand eine gültige Adresse ist
			if (operand < 0 || operand >= memory.getMemorySize()) {
				throw new IllegalArgumentException("Ungültige Speicheradresse: " + operand);
			}
			sti(operand);
			break;
		case "ADD":
			// Überprüfen, ob der Operand eine gültige Adresse ist
			if (operand < 0 || operand >= memory.getMemorySize()) {
				throw new IllegalArgumentException("Ungültige Speicheradresse: " + operand);
			}
			add(operand);
			break;
		case "SUB":
			// Überprüfen, ob der Operand eine gültige Adresse ist
			if (operand < 0 || operand >= memory.getMemorySize()) {
				throw new IllegalArgumentException("Ungültige Speicheradresse: " + operand);
			}
			sub(operand);
			break;
		case "JMP":
			// Überprüfen, ob der Operand eine gültige Adresse ist
			if (operand < 0 || operand >= memory.getMemorySize()) {
				throw new IllegalArgumentException("Ungültige Sprungadresse: " + operand);
			}
			jmp(operand);
			break;
		case "JMZ":
			// Überprüfen, ob der Operand eine gültige Adresse ist
			if (operand < 0 || operand >= memory.getMemorySize()) {
				throw new IllegalArgumentException("Ungültige Sprungadresse: " + operand);
			}
			jmz(operand);
			break;
		case "HLT":
			hlt();
			break;
		default:
			throw new IllegalArgumentException("Unbekannter Befehl: " + cmd);
		}

	}

}
