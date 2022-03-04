package happyjava;

import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings(value = "unused")
public class IntegerUtilsTests {
    @Test
    public void isPortTest() {
        assertTrue(IntegerUtils.isPort(0));
        assertTrue(IntegerUtils.isPort(22));
        assertTrue(IntegerUtils.isPort(1024));
        assertTrue(IntegerUtils.isPort(65535));

        assertFalse(IntegerUtils.isPort(-1));
        assertFalse(IntegerUtils.isPort(999999));
    }
}
