package ram;

public class Program {

	private Memory memory;

	public Program(Memory memory, int[] instructions) {
		this.memory = memory;

		for (int i = 0; i < instructions.length; i++) {
			memory.write(i, instructions[i]);
		}

	}

	public static void main(String[] args) {

		Memory memory = new Memory(5);
		Accumulator accumulator = new Accumulator();
		ControllerUnit2 controllerUnit = new ControllerUnit2(memory, accumulator);

		memory.write(0, 5); // Write into index 0 the value 5
		memory.write(1, 10); // Write into index 1 the value 10
		memory.write(2, 10); // Write into index 2 the value 10
		memory.write(3, 10); // Write into index 3 the value 10
		memory.write(4, 10); // Write into index 4 the value 10

		/* TESTNG FOR CMD */

		String[] cmds = { "LDA 1", "LDA 2" };

		for (int i = 0; i < (cmds.length); i++) {
			String[] cmd = cmds[i].split("\\s+"); // split command into parts using whitespace as delimiter
			controllerUnit.run(cmd[0], Integer.parseInt(cmd[1]));

		}

		/* TESTNG FOR CMD DONE */

		memory.print();

		System.out.println("Result: " + accumulator.get());

	}

}
