package ram;

import java.io.FileWriter;
import java.io.IOException;

public class Program {

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

            printer.printStep(controllerUnit.getProgramCounter(), cmd[0], Integer.parseInt(cmd[1]), accumulator.get(), memory);

            controllerUnit.run(cmd[0], Integer.parseInt(cmd[1]));
        }

        printer.printFooter(accumulator.get(), controllerUnit.getProgramCounter());
        System.out.println("Output wurde in die Datei '" + filename + "' geschrieben.");
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