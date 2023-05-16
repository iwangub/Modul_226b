package ram;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Program {
	private String[] instructions;
	private String[] mem;
	private Memory memory;
	private Accumulator accumulator;
	private ControllerUnit controllerUnit;

	public Program(String[] instructions, String[] mem) {
		this.instructions = instructions;
		this.mem = mem;
		this.memory = new Memory(16);
		this.accumulator = new Accumulator();
		this.controllerUnit = new ControllerUnit(memory, accumulator);

		// Process the Memory
		for (int i = 0; i < mem.length; i++) {
			memory.write(i, Integer.parseInt(mem[i]));
		}

		// Process the Array of Instructions
		for (int i = 0; i < instructions.length; i++) {
			String[] cmd = instructions[i].split("\\s+");
			String command = cmd[0];
			int operand = 0;
			if (cmd.length > 1) {
				operand = Integer.parseInt(cmd[1]);
			}
			controllerUnit.run(command, operand);
			printStep(i, command, operand);
		}

		// Print final results
		System.out.println("Result: " + accumulator.get());
		System.out.println("ProgramCounter: " + controllerUnit.getProgramCounter());
	}

	private void printStep(int step, String cmd, int operand) {
		System.out.printf("Step %d: %s %d%n", step, cmd, operand);
		System.out.printf("Accumulator: %d%n", accumulator.get());
		System.out.printf("ProgramCounter: %d%n", controllerUnit.getProgramCounter());
		System.out.println("Memory: ");
		printMemory();
		System.out.println("------------");
	}

	private void printMemory() {
		for (int j = 0; j < memory.getMemorySize(); j++) {
			System.out.printf("Address %d: %d%n", j, memory.read(j));
		}
	}

	public void writeOutputToFile(String filename) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
			writer.println("Result: " + accumulator.get());
			writer.println("ProgramCounter: " + controllerUnit.getProgramCounter());
			writer.println("Memory: ");
			for (int j = 0; j < memory.getMemorySize(); j++) {
				writer.printf("Address %d: %d%n", j, memory.read(j));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
