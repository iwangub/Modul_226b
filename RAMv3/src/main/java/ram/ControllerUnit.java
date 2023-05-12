package ram;

public class ControllerUnit {

	private Memory memory;
	private Accumulator accumulator;
	private int programCounter;

	public ControllerUnit(Memory memory, Accumulator accumulator) {
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
	
	public int getProgramCounter() {
		//System.out.println(programCounter);
		return programCounter;
	}

	public void hlt() {
		programCounter = -1;
	}

	public void run(String cmd, int operand) {
		switch (cmd) {
		case "LDA":
			// LDA
			lda(operand);
			break;
		case "LDI":
			// LDI
			ldi(operand);
			break;
		case "STA":
			// STA
			sta(operand);
			break;
		case "STI":
			// STI
			sti(operand);
			break;
		case "ADD":
			// ADD
			add(operand);
			break;
		case "SUB":
			// SUB
			sub(operand);
			break;
		case "JMP":
			// JMP
			jmp(operand);
			break;
		case "JMZ":
			// JMZ
			jmz(operand);
			break;
		case "HLT":
			// HLT
			hlt();
			break;
		default:
			throw new IllegalArgumentException("Unknown command: " + cmd);
		}
	}
}
