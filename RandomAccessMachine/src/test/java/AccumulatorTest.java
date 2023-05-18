import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ram.Accumulator;

public class AccumulatorTest {

    @Test
    public void testLoad() {
        Accumulator accumulator = new Accumulator();
        int valueToLoad = 10;
        accumulator.load(valueToLoad);
        int actualValue = accumulator.get();
        Assertions.assertEquals(valueToLoad, actualValue);
    }

    @Test
    public void testAddition() {
        Accumulator accumulator = new Accumulator();
        int initialValue = 5;
        int valueToAdd = 10;
        int expectedValue = initialValue + valueToAdd;
        accumulator.load(initialValue);
        accumulator.add(valueToAdd);
        int actualValue = accumulator.get();
        Assertions.assertEquals(expectedValue, actualValue);
    }
}
