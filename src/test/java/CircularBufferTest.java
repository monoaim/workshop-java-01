import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CircularBufferTest {

    CircularBuffer cb;

    @Before
    public void setUp() {
        this.cb = new CircularBuffer();
    }

    @Test
    public void CreateNewBufferShouldEmpty() {
        boolean result = cb.isEmpty();
        assertTrue("Buffer not available", result);
    }

    @Test
    public void CreateNewBufferWithDefaultSizeShould10() {
        for (int i = 0; i < 10; i++) {
            cb.writeData(String.format("A%d", i));
        }
        boolean result = cb.isFull();
        assertTrue("Buffer not full", result);
    }

    @Test
    public void WriteAtoBufferShouldReadA() {
        cb.writeData("A");
        cb.writeData("B");
        assertEquals("A", cb.readData());
        assertEquals("B", cb.readData());
    }
}