package ram;

public class User {

	public static void main(String[] args) {

		String[] cmds = { "HLT 0", "LDA 1", "ADD 1" };
		String[] mem = { "0", "1", "2", "3" };
		Program basicProgram = new Program("basic.txt", cmds, mem);

		String[] cmdsFibonacci = { "LDA 2", "ADD 3", "STA 4", "LDA 3", "STA 2", "LDA 4", "STA 3", "LDA 0", "SUB 1",
				"STA 0", "JMZ 12", "JMP 0", "HLT 0", };
		String[] memFibonacci = { "6", "1", "1", "0", "0" };
		Program fibonacci = new Program("fibonacci.txt", cmdsFibonacci, memFibonacci);

	}

}
