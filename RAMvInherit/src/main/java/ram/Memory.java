package ram;

public class Memory implements RAMComponent{

	private int[] memory;

	public Memory(int size) {
		memory = new int[size];
	}

	public void write(int address, int value) {
		memory[address] = value;
	}

	public int read(int address) {
		return memory[address];
	}

	public void print() {
		for (int i = 0; i < memory.length; i++) {
			System.out.println("Address " + i + ": " + memory[i]);
		}
	}

	public int getMemorySize() {
		return memory.length;
	}

}
