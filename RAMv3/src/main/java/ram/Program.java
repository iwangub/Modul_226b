package ram;

public class Program {

	public Program(String[] instructions, String[] mem) {

		Memory memory = new Memory(512);
		Accumulator accumulator = new Accumulator();
		ControllerUnit controllerUnit = new ControllerUnit(memory, accumulator);

		// Process the Memory
		for (int i = 0; i < mem.length; i++) {
			memory.write(i, Integer.parseInt(mem[i]));
		}
		// Process the Memory DONE

		// Process the Array of Instructions START
		for (int i = 0; i < (instructions.length); i++) {
			String[] cmd = instructions[i].split("\\s+"); // split command into parts using whitespace as delimiter
			controllerUnit.run(cmd[0], Integer.parseInt(cmd[1]));
		}
		// Process the Array of Instructions DONE

		System.out.println("Result: " + accumulator.get());

		System.out.println("ProgrammCounter: " + controllerUnit.getProgramCounter());

	}
}
