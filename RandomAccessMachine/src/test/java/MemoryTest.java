import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ram.Memory;
public class MemoryTest {

    @Test
    public void testReadAndWrite() {
        int size = 10;
        Memory memory = new Memory(size);

        // Test write() and read() methods
        int address = 5;
        int valueToWrite = 42;
        memory.write(address, valueToWrite);
        int readValue = memory.read(address);

        Assertions.assertEquals(valueToWrite, readValue);
    }

    @Test
    public void testGetMemorySize() {
        int size = 8;
        Memory memory = new Memory(size);

        int expectedSize = 8;
        int actualSize = memory.getMemorySize();

        Assertions.assertEquals(expectedSize, actualSize);
    }
}
