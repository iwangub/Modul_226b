package ram;

public class User {

	public static void main(String[] args) {

		String[] cmds = { "LDA 1"};
		String[] mem = { "1", "2", "3" };
		Program ram = new Program("output1.txt", cmds, mem);

	}

}
