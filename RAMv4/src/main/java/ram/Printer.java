package ram;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Printer {
    private PrintWriter writer;

    public Printer(String fileName) {
        try {
            writer = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printInstruction(String instruction, int accumulator, int programCounter) {
        writer.printf("Instruction: %s%n", instruction);
        writer.printf("Accumulator: %d%n", accumulator);
        writer.printf("Program Counter: %d%n", programCounter);
        writer.println("----------------------------------");
    }

    public void close() {
        writer.close();
    }
}

