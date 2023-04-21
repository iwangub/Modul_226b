package ram;

public class Main {

	public static void main(String[] args) {

	//	String[] cmds = { "LDA 1", "STA 2" };

		Memory memory = new Memory(2);
		Accumulator accumulator = new Accumulator();
		ControllerUnit2 controllerUnit = new ControllerUnit2(memory, accumulator);

		memory.write(0, 5); // Write into index 0 the value 5
		memory.write(1, 10); // Write into index 1 the value 10

		memory.print();

//		controllerUnit.run();

		System.out.println("Result: " + accumulator.get());

	}

}
