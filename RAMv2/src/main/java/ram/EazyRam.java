package ram;

public class EazyRam {
	
	private Memory memory;
	private Accumulator accumulator;
	private int programCounter;
	
	public EazyRam(Memory memory, Accumulator accumulator) {
		this.memory = memory;
		this.accumulator = accumulator;
		this.programCounter = 0;
	}
	
	
	public void lda(int address) {
		accumulator.load(memory.read(address));
		programCounter++;
	}

	public static void runEZ() {
		String cmd = "LDA";
		
		
		
		while(cmd != "HLT") {
			switch(cmd) {
			case "LDA":
				lda(1);
			}
			
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		

	}

}
