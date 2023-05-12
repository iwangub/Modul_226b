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

		Memory memory = new Memory(2);
		Accumulator accumulator = new Accumulator();
		ControllerUnit2 controllerUnit = new ControllerUnit2(memory, accumulator);

		memory.write(0, 5); // Write into index 0 the value 5
		memory.write(1, 10); // Write into index 1 the value 10

		/* TESTNG FOR CMD */

		String[] cmds = { "LDA 1", "LDA 2", "STI 1"};

		for (int i = 0; i < (cmds.length -1); i++) {
			
			String[] cmd = cmds[i].split("\\s+"); // split command into parts using whitespace as delimiter
			String[] memAddress = cmds[i].split(" ");
			
			System.out.println("Printing commands");
			System.out.println(cmd[0]);
			System.out.println("DONE printing commands");
			
			System.out.println("Printing MemoryAddress");
			System.out.println(memAddress[1]);
			System.out.println("DONE printing MemoryAddress");
				
			/*if (cmd[i].equals("LDA")) {
				controllerUnit.run(0, Integer.parseInt(memAddress[0]));
			}*/
/*
			if (cmd[0].equals("LDI")) {
				controllerUnit.run(1);
			}

			if (cmd[0].equals("STA")) {
				controllerUnit.run(2);
			}

			if (cmd[0].equals("STI")) {
				controllerUnit.run(3);
			}

			if (cmd[0].equals("ADD")) {
				controllerUnit.run(4);
			}
			
			if (cmd[0].equals("SUB")) {
				controllerUnit.run(5);
			}
			
			if (cmd[0].equals("JMP")) {
				controllerUnit.run(6);
			}
			
			if (cmd[0].equals("JMZ")) {
				controllerUnit.run(7);
			}*/
		}

		/* TESTNG FOR CMD DONE */

		//memory.print();

		// controllerUnit.run();

		//System.out.println("Result: " + accumulator.get());

	}

}
