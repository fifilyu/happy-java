package io.github.happyjava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
