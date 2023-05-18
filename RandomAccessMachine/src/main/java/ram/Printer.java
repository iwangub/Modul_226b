package ram;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Die Printer-Klasse ermöglicht das Drucken des Programmstatus während der
 * Ausführung.
 */
public class Printer {
	private PrintWriter writer;

	/**
	 * Konstruktor für die Printer-Klasse.
	 *
	 * @param filename Der Dateiname, in den gedruckt werden soll.
	 */
	public Printer(String filename) {
		try {
			writer = new PrintWriter(new FileWriter(filename));
		} catch (IOException e) {
			System.out.println("Fehler beim Öffnen der Datei: " + filename);
			e.printStackTrace();
		}
	}

	/**
	 * Druckt den Header der Ausgabe.
	 */
	public void printHeader() {
		writer.println("Programmstart:");
		writer.println("Programmcounter\tInstruction\tOperand\tAccumulator\tMemory");
		writer.println("----------------------------------------------------------------");
	}

	/**
	 * Druckt einen Schritt des Programms mit den entsprechenden Werten.
	 *
	 * @param programCounter Der Programmcounter.
	 * @param instruction    Die aktuelle Anweisung.
	 * @param operand        Der Operand der Anweisung.
	 * @param accumulator    Der Wert des Akkumulators.
	 * @param memory         Der Speicherinhalt.
	 */
	public void printStep(int programCounter, String instruction, int operand, int accumulator, Memory memory) {
		writer.print(programCounter + "\t\t" + instruction + "\t\t" + operand + "\t" + accumulator + "\t\t");
		for (int j = 0; j < memory.getMemorySize(); j++) {
			writer.print(memory.read(j) + " ");
		}
		writer.println();
	}

	/**
	 * Druckt den Abschluss der Ausgabe und schließt die Datei.
	 */
	public void printFooter(int result, int programCounter) {
		writer.println("----------------------------------------------------------------");
		writer.println("Programmende:");
		writer.println("Accumulator: " + result);
		writer.println("Programmcounter: " + programCounter);
		writer.close();
	}
}
