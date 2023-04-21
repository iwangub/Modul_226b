package ram;

public class Main {

	public static void main(String[] args) {
		Memory memory = new Memory(2);

		memory.write(0, 5);
		System.out.println(memory.read(0));
		memory.write(1, 10);
		System.out.println(memory.read(1));

		Accumulator accumulator = new Accumulator();
		ControllerUnitTesting controllerUnit = new ControllerUnitTesting(memory, accumulator);

		
		controllerUnit.run();
		
//		memory.print();
//
//		controllerUnit.run();
//
//		System.out.println("Result: " + accumulator.get());

//		100 IQ solution
//        Memory memory = new Memory(1024);
//        memory.write(0, 0x00010001); // LDA 1
//        memory.write(1, 0x00020002); // LDI 2
//        memory.write(2, 0x00030003); // STA 3
//        memory.write(3, 0x00040004); // STI 4
//        memory.write(4, 0x00050003); // ADD 3
//        memory.write(5, 0x00060005); // SUB 5
//        memory.write(6, 0x00070000); // JMZ 0
//        memory.write(7, 0x00080000); // HLT

	}

}
