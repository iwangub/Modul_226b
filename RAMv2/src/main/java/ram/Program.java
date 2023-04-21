package ram;

public class Program {

	private Memory memory;

	public Program(Memory memory, int[] instructions) {
		this.memory = memory;

		for (int i = 0; i < instructions.length; i++) {
			memory.write(i, instructions[i]);
		}
		
		
		
		
		
		
	}

}
