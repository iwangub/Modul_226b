package ram;

public class ControllerUnitTesting {

	private Memory memory;
	private Accumulator accumulator;
	private int programCounter;

	public ControllerUnitTesting(Memory memory, Accumulator accumulator) {
		this.memory = memory;
		this.accumulator = accumulator;
		this.programCounter = 0;
	}

	public void run() {
		while (true) {
			int instruction = memory.read(programCounter);
			int opcode = instruction >> 16;
			int operand = instruction & 0xFFFF;

			switch (opcode) {
			case 0:
				// LDA
				accumulator.load(memory.read(operand));
				programCounter++;
				break;
			case 1:
				// LDI
				accumulator.load(memory.read(memory.read(operand)));
				programCounter++;
				break;
			case 2:
				// STA
				memory.write(operand, accumulator.get());
				programCounter++;
				break;
			case 3:
				// STI
				memory.write(memory.read(operand), accumulator.get());
				programCounter++;
				break;
			case 4:
				// ADD
				accumulator.add(memory.read(operand));
				programCounter++;
				break;
			case 5:
				// SUB
				accumulator.subtract(memory.read(operand));
				programCounter++;
				break;
			case 6:
				// JMP
				programCounter = operand;
				break;
			case 7:
				// JMZ
				if (accumulator.get() == 0) {
					programCounter = operand;
				} else {
					programCounter++;
				}
				break;
			case 8:
				// HLT
				return;
			default:
				throw new IllegalArgumentException("Unknown opcode: " + opcode);
			}
		}
	}

	public static void main(String[] args) {
		Memory ram = new Memory(10);
		ram.write(0, 100);
		System.out.println("Value at address 0: " + ram.read(0));

		
		
		
		System.out.println("Printing whole Memory");
		ram.print();
	}

}
