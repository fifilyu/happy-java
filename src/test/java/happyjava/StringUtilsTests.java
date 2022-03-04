package happyjava;

import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings(value = "unused")
public class StringUtilsTests {
    @Test
    public void bytesToHexTest() {
        byte[] cdGeekCamp = "happy-java".getBytes();
        assertEquals("68617070792d6a617661", StringUtils.bytesToHex(cdGeekCamp));
    }

    @Test
    public void isIPv4Test() {
        assertTrue(StringUtils.isIPv4("0.0.0.0"));
        assertTrue(StringUtils.isIPv4("1.1.1.1"));
        assertTrue(StringUtils.isIPv4("125.65.110.1"));
        assertTrue(StringUtils.isIPv4("125.125.110.110"));
        assertTrue(StringUtils.isIPv4("255.255.255.255"));

        assertFalse(StringUtils.isIPv4(null));
        assertFalse(StringUtils.isIPv4("0.a.0.0"));
        assertFalse(StringUtils.isIPv4("0.0..0.0"));
        assertFalse(StringUtils.isIPv4(".0.0.0.0"));
        assertFalse(StringUtils.isIPv4("0.0.0.0."));
        assertFalse(StringUtils.isIPv4("0.0.0.2555"));
    }

    @Test
    public void isPortTest() {
        assertTrue(StringUtils.isPort("0"));
        assertTrue(StringUtils.isPort("22"));
        assertTrue(StringUtils.isPort("1024"));
        assertTrue(StringUtils.isPort("65535"));

        assertFalse(StringUtils.isPort(null));
        assertFalse(StringUtils.isPort("a"));
        assertFalse(StringUtils.isPort("a1"));
        assertFalse(StringUtils.isPort(" 22"));
        assertFalse(StringUtils.isPort("22 "));
        assertFalse(StringUtils.isPort("2 2"));
        assertFalse(StringUtils.isPort("-1"));
        assertFalse(StringUtils.isPort("999999"));
    }
}
