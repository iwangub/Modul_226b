package ram;

public class User {
	public static void main(String[] args) {
		String[] cmds = { "LDA 1", "LDA 2"};
		String[] mem = { "0", "1", "2", "3", "4", "5" };

		Program ram = new Program(cmds, mem);
		ram.writeOutputToFile("output.txt");
	}
}
