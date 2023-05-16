package ram;

import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public Program(String[] instructions, String[] mem) {

		Memory memory = new Memory(512);
		Accumulator accumulator = new Accumulator();
		ControllerUnit controllerUnit = new ControllerUnit(memory, accumulator);

		// Prozessiere den Speicher
		for (int i = 0; i < mem.length; i++) {
			memory.write(i, Integer.parseInt(mem[i]));
		}

		// Prozessiere das Array der Anweisungen
		for (int i = 0; i < instructions.length; i++) {
			String[] cmd = instructions[i].split("\\s+");
			controllerUnit.run(cmd[0], Integer.parseInt(cmd[1]));
		}

		// Schreibe den Output in die Datei
		try {
			FileWriter writer = new FileWriter("output.txt");
			writer.write("Result: " + accumulator.get() + "\n");
			writer.write("ProgramCounter: " + controllerUnit.getProgramCounter() + "\n");
			writer.close();
			System.out.println("Output wurde in die Datei 'output.txt' geschrieben.");
		} catch (IOException e) {
			System.out.println("Fehler beim Schreiben in die Datei 'output.txt'");
			e.printStackTrace();
		}


	}
}


/*
 * Memory memory = new Memory(512); Accumulator accumulator = new Accumulator();
 * ControllerUnit controllerUnit = new ControllerUnit(memory, accumulator);
 * 
 * // Process the Memory for (int i = 0; i < mem.length; i++) { memory.write(i,
 * Integer.parseInt(mem[i])); } // Process the Memory DONE
 * 
 * // Process the Array of Instructions START for (int i = 0; i <
 * (instructions.length); i++) { String[] cmd = instructions[i].split("\\s+");
 * // split command into parts using whitespace as delimiter
 * controllerUnit.run(cmd[0], Integer.parseInt(cmd[1])); } // Process the Array
 * of Instructions DONE
 * 
 * System.out.println("Result: " + accumulator.get());
 * 
 * System.out.println("ProgrammCounter: " + controllerUnit.getProgramCounter());
 */