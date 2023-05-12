package ram;

public class Program {

	public Program(String[] instructions) {

		Memory memory = new Memory(instructions.length);
		Accumulator accumulator = new Accumulator();
		ControllerUnit2 controllerUnit = new ControllerUnit2(memory, accumulator);

		for (int i = 0; i < (instructions.length); i++) {
			String[] cmd = instructions[i].split("\\s+"); // split command into parts using whitespace as delimiter
			controllerUnit.run(cmd[0], Integer.parseInt(cmd[1]));
		}
		
		memory.print();
		
		System.out.println("Result: " + accumulator.get());

		System.out.println("ProgrammCounter: " + controllerUnit.getProgramCounter());

	}

	public static void main(String[] args) {

		// Working Version //

		Memory memory = new Memory(5);
		Accumulator accumulator = new Accumulator();
		ControllerUnit2 controllerUnit = new ControllerUnit2(memory, accumulator);

		memory.write(0, 1); // Write into index 0 the value 5
		memory.write(1, 1); // Write into index 1 the value 10

		String[] cmds = { "LDA 1", "ADD 2", "STA 2", "ADD 2" };

		for (int i = 0; i < (cmds.length); i++) {
			String[] cmd = cmds[i].split("\\s+"); // split command into parts using whitespace as delimiter
			controllerUnit.run(cmd[0], Integer.parseInt(cmd[1]));
		}

		memory.print();

		System.out.println("Result: " + accumulator.get());

		System.out.println("ProgrammCounter: " + controllerUnit.getProgramCounter());

		// Working Version DONE//

	}

}
