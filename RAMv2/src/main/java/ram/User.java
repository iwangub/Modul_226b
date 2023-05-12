package ram;

public class User {

	public static void main(String[] args) {

		String[] cmds = { "LDA 1", "ADD 1", "ADD 1", "JMP 0", "STA 1" };
		String[] mem = { "1", "1", "1" };
		Program ram = new Program(cmds, mem);

		// TESTING ARE START

		// TESTING ARE DONE

		// Program ram = new Program(args[0], args[1]);

		// System.out.println(args[1]);

	}

}
