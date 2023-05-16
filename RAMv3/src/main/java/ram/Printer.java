package ram;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Printer {
    private PrintWriter writer;

    public Printer(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            System.out.println("Fehler beim Öffnen der Datei: " + filename);
            e.printStackTrace();
        }
    }

    public void printHeader() {
        writer.println("Programmstart:");
        writer.println("Programmcounter\tInstruction\tOperand\tAccumulator\tMemory");
        writer.println("----------------------------------------------------------------");
    }

    public void printStep(int programCounter, String instruction, int operand, int accumulator, Memory memory) {
        writer.print(programCounter + "\t\t\t" + instruction + "\t\t" + operand + "\t\t" + accumulator + "\t\t");
        for (int j = 0; j < memory.getMemorySize(); j++) {
            writer.print(memory.read(j) + " ");
        }
        writer.println();
    }

    public void printFooter(int result, int programCounter) {
        writer.println("----------------------------------------------------------------");
        writer.println("Programmende:");
        writer.println("Result: " + result);
        writer.println("Programmcounter: " + programCounter);
        writer.close();
    }
}
