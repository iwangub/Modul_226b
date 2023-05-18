package ram;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Die Program-Klasse repräsentiert ein Programm, das im RAM ausgeführt werden
 * kann.
 */
public class Program {

	private Memory memory;
	private Accumulator accumulator;
	private ControllerUnit contollerUnit;
	private Printer printer;

	/**
	 * Konstruktor für die Program-Klasse.
	 *
	 * @param filename     Der Dateiname, in den gedruckt werden soll.
	 * @param instructions Die Anweisungen des Programms.
	 * @param mem          Der Speicherinhalt.
	 */
	public Program(String filename, String[] instructions, String[] mem) {

		Memory memory = new Memory(16);
		Accumulator accumulator = new Accumulator();
		ControllerUnit controllerUnit = new ControllerUnit(memory, accumulator);
		Printer printer = new Printer(filename);

		// Prozessiere den Speicher
		for (int i = 0; i < mem.length; i++) {
			memory.write(i, Integer.parseInt(mem[i]));
		}

		printer.printHeader();

		// Prozessiere das Array der Anweisungen
		for (int i = 0; i < instructions.length; i++) {
			/**
			 * String auseinander nehmen
			 */
			String[] cmd = instructions[i].split("\\s+");

			controllerUnit.run(cmd[0], Integer.parseInt(cmd[1]));

			printer.printStep(controllerUnit.getProgramCounter(), cmd[0], Integer.parseInt(cmd[1]), accumulator.get(),
					memory);

		}

		printer.printFooter(accumulator.get(), controllerUnit.getProgramCounter());
		System.out.println("Output wurde in die Datei '" + filename + "' geschrieben.");
	}

}