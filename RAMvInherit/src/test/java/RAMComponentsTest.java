import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ram.Accumulator;
import ram.Memory;

public class RAMComponentsTest {

    private Memory memory;
    private Accumulator accumulator;

    @BeforeEach
    public void setUp() {
        memory = new Memory(16);
        accumulator = new Accumulator();
    }

    @Test
    public void testMemoryReadAndWrite() {
        memory.write(0, 42);
        int value = memory.read(0);
        Assertions.assertEquals(42, value);
    }

    @Test
    public void testAccumulatorLoad() {
        accumulator.load(10);
        int value = accumulator.get();
        Assertions.assertEquals(10, value);
    }

    @Test
    public void testAccumulatorAdd() {
        accumulator.load(5);
        accumulator.add(3);
        int value = accumulator.get();
        Assertions.assertEquals(8, value);
    }

    @Test
    public void testAccumulatorSubtract() {
        accumulator.load(10);
        accumulator.subtract(4);
        int value = accumulator.get();
        Assertions.assertEquals(6, value);
    }

    @Test
    public void testAccumulatorUnsupportedOperations() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            accumulator.read(0);
        });

        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            accumulator.write(0, 42);
        });

        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            accumulator.getMemorySize();
        });
    }

    @Test
    public void testMemorySize() {
        int size = memory.getMemorySize();
        Assertions.assertEquals(16, size);
    }
}
