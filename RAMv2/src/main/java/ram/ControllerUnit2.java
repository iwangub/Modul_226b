package ram;

public class ControllerUnit2 {

	private Memory memory;
	private Accumulator accumulator;
	private int programCounter;

	public ControllerUnit2(Memory memory, Accumulator accumulator) {
		this.memory = memory;
		this.accumulator = accumulator;
		this.programCounter = 0;
	}

	public void lda(int address) {
		accumulator.load(memory.read(address));
		programCounter++;
	}

	public void ldi(int address) {
		int indirectAddress = memory.read(address);
		accumulator.load(memory.read(indirectAddress));
		programCounter++;
	}

	public void sta(int address) {
		memory.write(address, accumulator.get());
		programCounter++;
	}

	public void sti(int address) {
		int indirectAddress = memory.read(address);
		memory.write(indirectAddress, accumulator.get());
		programCounter++;
	}

	public void add(int address) {
		accumulator.add(memory.read(address));
		programCounter++;
	}

	public void sub(int address) {
		accumulator.subtract(memory.read(address));
		programCounter++;
	}

	public void jmp(int address) {
		programCounter = address;
	}

	public void jmz(int address) {
		if (accumulator.get() == 0) {
			programCounter = address;
		} else {
			programCounter++;
		}
	}

	public void hlt() {
		programCounter = -1; // stoppt die Ausführung
	}

	public void run() {
		while (programCounter >= 0) {
			int instruction = memory.read(programCounter);
			int opcode = instruction >> 16;
			int operand = instruction & 0xFFFF;

			switch (opcode) {
			case 0:
				// LDA
				lda(operand);
				break;
			case 1:
				// LDI
				ldi(operand);
				break;
			case 2:
				// STA
				sta(operand);
				break;
			case 3:
				// STI
				sti(operand);
				break;
			case 4:
				// ADD
				add(operand);
				break;
			case 5:
				// SUB
				sub(operand);
				break;
			case 6:
				// JMP
				jmp(operand);
				break;
			case 7:
				// JMZ
				jmz(operand);
				break;
			case 8:
				// HLT
				hlt();
				break;
			default:
				throw new IllegalArgumentException("Unknown opcode: " + opcode);
			}
		}
	}



}
