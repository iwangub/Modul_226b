package ram;

public class Memory {

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
		
	
	public static void main(String[] args) {
		Memory ram = new Memory(5);
		ram.write(0, 100);
		System.out.println("Value at address 0: " + ram.read(0));

		System.out.println("Printing whole Memory");
		ram.print();
	}
	
}
