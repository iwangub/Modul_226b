package ram;

public class EazyRam2 {

	private int[] memory;
	private int ac;

	public EazyRam2(int size) {
		memory = new int[size];
		ac = 0;
	}
	
	public void write(int address, int value) {
		memory[address] = value;
	}
	
	public int readMem(int address) {
		return memory[address];
	}

	public void lda(int x) {
		ac = memory[x];
	}

	public void ldi(int x) {
		ac = memory[memory[x]];
	}

	public void sta(int x) {
		memory[x] = ac;
	}

	public void sti(int x) {
		memory[memory[x]] = ac;
	}

	public void add(int x) {
		ac += memory[x];
	}

	public void sub(int x) {
		ac -= memory[x];
	}

	public void jmp(int x) {
		// springe zur mit x markierten Instruktion
	}

	public void jmz(int x) {
		if (ac == 0) {
			// springe zur mit x markierten Instruktion
		}
	}

	public void halt() {
		// halte das Programm
	}

	public static void main(String[] args) {

		EazyRam2 ram = new EazyRam2(10); // erstelle einen RAM mit 10 Adressen
		ram.write(0, 2);
		ram.readMem(0);
		
		
		
		
		ram.ldi(0); // lade die Adresse 0 in den AC
		ram.readMem(0);
		ram.lda(1); // speichere den Inhalt des AC in Adresse 1
		ram.readMem(1);
		ram.ldi(2); // lade die Adresse 2 in den AC
		ram.add(1); // addiere den Inhalt von Adresse 1 zum AC
		ram.sti(3); // speichere den Inhalt des AC in Adresse 3
		ram.lda(4); // lade den Inhalt der Adresse, die in Adresse 4 gespeichert ist, in den AC
		ram.sub(3); // subtrahiere den Inhalt von Adresse 3 vom AC
		ram.jmp(5); // springe zur Adresse 5
		ram.ldi(6); // dieser Befehl wird übersprungen, da wir zur Adresse 5 gesprungen sind
		ram.halt(); // halte das Programm

//		for (int i = 0; i < 10; i++) {
//			System.out.println("Adresse " + i + ": ");
//		}

	}
}
